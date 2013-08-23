package com.boventech.cms.dao.node.impl;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.node.NodeDao;
import com.boventech.cms.module.node.Node;

@Repository
public class NodeDaoImpl extends AbstractDaoImpl<Node, Integer> implements NodeDao {

    /**
	 * 
	 */
    private static final long serialVersionUID = -4995365893941554377L;

    // private static final String LIST_NODE_TREE_BY_ROOT_ID =
    // "select id,name,parent_id,level,orders"+
    // " from Node {0} start with {1} connect by prior id = parent_id order siblings by position";

    private static final String LIST_NODE_TREE_BY_ROOT_ID = "select id,name,parent_id,level,orders"
            + " from Node {0} and {1}";

    private static final String FIND_BY_PARENT_ID_AND_DISPLAY = "from Node n"
            + " where n.parent.id {0}{1} order by n.position asc";

    private static final String POSITION = "position";

    private static final String UPDATE_POSITION_BY_DELETE = "update Node n set"
            + " n.position = n.position - 1 where n.position >:position and n.parent.id {0}";

    private static final String COUNT_BY_PARENT_ID = "select count(*) from Node n" + " where n.parent.id {0}";

    private static final String ID = "id";

    private static final String NEW_POSITION = "newPosition";

    private static final String OLD_POSITION = "oldPosition";

    private static final String UPDATE_NEW_POSITION = "update Node n"
            + " set n.position =:newPosition where n.id=:id";

    private static final String UPDATE_OLD_POSITION = "update Node n set n.position"
            + " =:oldPosition where n.position=:newPosition and n.parent.id {0}";

    private static final String FIND_NODE_BY_PARENT_ID = "from Node n"
            + " where n.parent.id {0} order by n.position asc";

    @SuppressWarnings("unchecked")
    public List<Node> findByParentId(Integer parentId) {
        String parentIdSql = parentId != null ? "=" + parentId : "is null";
        String hql = MessageFormat.format(FIND_NODE_BY_PARENT_ID, parentIdSql);
        return this.getHibernateTemplate().find(hql);
    }

    public void changePosition(final Integer id, final Integer parentId, final int oldPosition,
            final int newPosition) {
        this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String parentIdSql = parentId != null ? "=" + parentId : "is null";
                String hql = MessageFormat.format(UPDATE_OLD_POSITION, parentIdSql);
                Query query = session.createQuery(hql).setParameter(OLD_POSITION, oldPosition)
                        .setParameter(NEW_POSITION, newPosition);
                query.executeUpdate();
                query = session.createQuery(UPDATE_NEW_POSITION).setParameter(NEW_POSITION, newPosition)
                        .setParameter(ID, id);
                query.executeUpdate();
                return null;
            }
        });
    }

    public int count(final Integer parentId) {
        return (Integer) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String parentIdSql = parentId != null ? "=" + parentId : "is null";
                String hql = MessageFormat.format(COUNT_BY_PARENT_ID, parentIdSql);
                Query query = session.createQuery(hql);
                Object result = query.uniqueResult();
                if (result != null)
                    return ((Number) result).intValue();
                return 0;
            }
        });
    }

    public void changePosition(final Integer parentId, final int position) {
        this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String parentIdSql = parentId != null ? "=" + parentId : "is null";
                String hql = MessageFormat.format(UPDATE_POSITION_BY_DELETE, parentIdSql);
                Query query = session.createQuery(hql).setParameter(POSITION, position);
                query.executeUpdate();
                return null;
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<Node> findByParentId(Integer parentId, boolean display) {
        String parentIdSql = parentId != null ? "=" + parentId : "is null";
        String displaySql = display ? " and n.display = 1" : "";
        String hql = MessageFormat.format(FIND_BY_PARENT_ID_AND_DISPLAY, parentIdSql, displaySql);
        return this.getHibernateTemplate().find(hql);
    }

    public List<Object[]> listTree(final boolean display) {
        if (display) {
            return listTree(display, null);
        }
        return listTreeForAll();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> listTree(final boolean display, final Integer parentId) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String displaySql = display ? "where display = 1" : "where display = ";
                String parentSql = parentId == null ? "parent_id is null" : "parent_id = " + parentId;
                String sql = MessageFormat.format(LIST_NODE_TREE_BY_ROOT_ID, displaySql, parentSql);
                SQLQuery query = session.createSQLQuery(sql);
                return query.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> listTreeForAll() {
        return this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String listAll = "select id,name,parent_id,orders from Node";
                SQLQuery query = session.createSQLQuery(listAll);
                return query.list();
            }
        });
    }

    public Node findByName(String name) {
        List<Node> nodes = this.listByProperty("name", name);
        return nodes.isEmpty() ? null : nodes.get(0);
    }

}
