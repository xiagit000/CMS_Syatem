package com.boventech.cms.dao.node.impl;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.node.EntryDao;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.EntryCriteria;
import com.boventech.cms.module.node.EntryEmptyType;
import com.boventech.cms.module.node.EntryNullType;
import com.boventech.cms.module.node.EntryOrderType;
import com.boventech.cms.module.node.EntryRestrictionType;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.web.PageIndex;

@Repository
public class EntryDaoImpl extends AbstractDaoImpl<Entry, Integer> implements EntryDao{


	private static final String CLEAN_POSITION_BELOW_DELETED = "update Entry e set e.position=e.position-1 where e.belonged.id=:nodeId and e.position>:position";

	/**
	 * 
	 */
	private static final long serialVersionUID = -5784137076212231226L;

	private static final String ENTRY_ID = "entryId";
	
	private static final String NEW_POSITION = "newPosition";
	
	private static final String OLD_POSITION = "oldPosition";
	
	private static final String CHANGE_POSITION_BY_ENTRY_ID = 
		"update Entry e set e.position=:newPosition where e.id=:entryId";
	
	private static final String CHANGE_POSITION_BY_POSITION_AND_BELONGED = 
		"update Entry e set e.position =:oldPosition"+
		" where e.position=:newPosition and e.belonged.id=:nodeId";
	
	private static final String COUNT_BY_NODE_ID = "select count(*) from Entry"+
		" e where e.belonged.id =:nodeId";

	private static final String ID = "id";

	private static final String NODE_ID = "nodeId";

//	private static final String LIST_NODE_IDS_ROOT_BY_NODEID = "select id from Node"+
//	" start with {0} connect by prior id = parent_id order siblings by position";

	private static final String LIST_NODE_IDS_ROOT_BY_NODEID2 = "select id from Node"+
	" where parent_id with {0} connect by prior id = parent_id order siblings by position";

	
//	private static final String LIST_ALL_ENTRYS_ROOT_BY_NODEID = "from Entry e"+
//		" where {0} e.belonged.id in (:ids)"+
//		" order by e.published asc,e.publishedDate desc";
//	
	private static final String LIST_ALL_ENTRYS_ROOT_BY_NODEID = "from Entry e"+
			" where {0} e.belonged.id =:ids"+
			" order by e.published asc,e.publishedDate desc";
			
//	private static final String COUNT_ALL_ENTRYS_ROOT_BY_NODEID = "select count(*) from"+
//	" Entry e where {0} e.belonged.id in (:ids)" +" order by timeline desc";
	
	private static final String COUNT_ALL_ENTRYS_ROOT_BY_NODEID = "select count(*) from"+
			" Entry e where {0} e.belonged.id =:ids" +" order by timeline desc";
	
	private static final String LIST_PUBLISHED_ENTRYS = "from Entry e"+
	" where e.published = true and e.belonged.link = false order by timeline desc";

	private static final String LIST_PUBLISHED_BY_NODEID = "from Entry e"+
	" where e.published = true and e.belonged.id =:nodeId order by timeline desc";

	private static final String COUNT_PUBLISHED_BY_NODEID = "select count(*) from Entry"+
	" e where e.published = true and e.belonged.id =:nodeId order by timeline desc";

	private static final String UPDATE_HITS_BY_ID = "update Entry"+
	" set hits = hits + 1 where id =:id";
	
	private static final String LIST_PIC_ENTRYS = "from Entry e"+
	" where e.published = true and e.belonged.id =3 and e.image is not null order by timeline desc";

	private static final String LIST_BY_NODEID = "from Entry e"+
		" where e.belonged.id =:nodeId order by timeline desc";

	private static final String COUNT_LIST_BY_NODEID = "select count(*) from Entry e"+
		" where e.belonged.id =:nodeId order by timeline desc";

	private static final String IDS = "ids";

	private static final String BELONGED = "belonged";
	
	private static final String PUBLISHED = "published";
	
    private static final String TIMELINE = "timeline";
    
    private static final String PLAIN_TEXT = "plainText";
    
    private static final String TITLE = "title";
	
	@SuppressWarnings("unchecked")
	public List<Entry> listByNodeId(Integer nodeId) {
		return this.getHibernateTemplate().find("from Entry e where e.belonged.id = "
				+ nodeId);
	}

	public List<Entry> list(int size, Node node) {
		return listByPropertyAndSize(size, BELONGED , node);
	}

	@SuppressWarnings("unchecked")
	public List<Entry> listEntrys(final int number) {
		return this.getHibernateTemplate()
			.executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Entry order by timeline desc");
				return query.setMaxResults(number).list();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Entry> listByNodeId(final Integer nodeId, final PageIndex pageIndex) {
		return this.getHibernateTemplate()
			.executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query countQuery = session.createQuery(COUNT_LIST_BY_NODEID)
					.setParameter(NODE_ID, nodeId);
				int count = ((Number)countQuery.uniqueResult()).intValue();
				pageIndex.setTotalRows(count);
				Query listQuery = session.createQuery(LIST_BY_NODEID)
					.setParameter(NODE_ID, nodeId);
				return listQuery.setFirstResult(pageIndex.getStartRow())
					.setMaxResults(pageIndex.getPageSize()).list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Entry> listPicEntrys(final int number) {
		return this.getHibernateTemplate()
			.executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(LIST_PIC_ENTRYS);
				query.setCacheable(true);
				return query.setMaxResults(number).list();
			}
		});
	}

	public void updateHits(final Entry entry) {
		this.getHibernateTemplate().execute(new HibernateCallback<Entry>() {

			public Entry doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(UPDATE_HITS_BY_ID)
					.setParameter(ID, entry.getId());
				query.executeUpdate();
				return null;
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	public List<Entry> listPubishedByNodeId(final Integer nodeId
			, final PageIndex pageIndex) {
		return this.getHibernateTemplate()
			.executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query countQuery = session.createQuery(COUNT_PUBLISHED_BY_NODEID)
					.setParameter(NODE_ID, nodeId);
				int count = ((Number)countQuery.uniqueResult()).intValue();
				pageIndex.setTotalRows(count);
				Query listQuery = session.createQuery(LIST_PUBLISHED_BY_NODEID)
				.setParameter(NODE_ID, nodeId);
				return listQuery.setFirstResult(pageIndex.getStartRow())
				.setMaxResults(pageIndex.getPageSize()).list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Entry> listPubishedEntrys(final int number) {
		return this.getHibernateTemplate()
			.executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(LIST_PUBLISHED_ENTRYS)
					.setCacheable(true);
				return query.setMaxResults(number).list();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Entry> listAllByNodeId(final Integer nodeId,
			final PageIndex pageIndex, final boolean needPublished) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Integer[] ids = listIdsByNodeId(nodeId, session);
				String publishedSql = needPublished ? " e.published = true and " : " ";
				String countSql = MessageFormat.format(COUNT_ALL_ENTRYS_ROOT_BY_NODEID, publishedSql);
				Query countQuery = session.createQuery(countSql)
					.setParameter(IDS, nodeId)
					.setCacheable(true);
				int count = ((Number)countQuery.uniqueResult()).intValue();
				pageIndex.setTotalRows(count);
				String listSql = MessageFormat.format(LIST_ALL_ENTRYS_ROOT_BY_NODEID, publishedSql);
				Query listQuery = session.createQuery(listSql)
					.setParameter(IDS, nodeId)
					.setCacheable(true);
				return listQuery.setFirstResult(pageIndex.getStartRow())
				.setMaxResults(pageIndex.getPageSize()).list();
			}

			private Integer[] listIdsByNodeId(final Integer nodeId,
					Session session) {
				
				//String nodeSql = nodeId == null ? "id is null" : "id = " + nodeId;
				//String sql = MessageFormat.format(LIST_NODE_IDS_ROOT_BY_NODEID, nodeSql);
				
				String sql = "";
				if(nodeId == null){
//					private static final String LIST_NODE_IDS_ROOT_BY_NODEID = "select id from Node"+
//							" start with {0} connect by prior id = parent_id order siblings by position";
					sql = "select id from Node where id is null";
				} else {
					sql = "select id from Node where parent_id = " + nodeId;
				}
				
				SQLQuery query = session.createSQLQuery(sql);
				List<Integer> list = query.addScalar(ID,new IntegerType())
					.setCacheable(true).list();
				Integer[] ids = list.toArray(new Integer[list.size()]);
				return ids;
			}

		});
	}

	public List<Entry> listPublished(int size, Node node) {
		return listByPropertiesAndSize(size, new String[]{BELONGED, PUBLISHED}
			, new Object[]{node,true});
	}

	@SuppressWarnings("unchecked")
	public List<Entry> search(final String keyword, final PageIndex pageIndex,
			final boolean published) {
		final String value = "%" + keyword + "%";
        final Class<Entry> persistClass = this.getPersistClass();
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException
            	, SQLException {
                Criteria criteria = session.createCriteria(persistClass);
                criteria.add(Restrictions.or(Restrictions.like(TITLE, value),
                		Restrictions.like(PLAIN_TEXT, value)));
                if(published)
                    criteria.add(Restrictions.eq(PUBLISHED, true));
                criteria.addOrder(Order.desc(TIMELINE));
                criteria.setProjection(Projections.rowCount());
                int number = ((Number)criteria.list().get(0)).intValue();
                pageIndex.setTotalRows(number);
                criteria.setProjection(null);
                criteria.setFirstResult(pageIndex.getStartRow());
                criteria.setMaxResults(pageIndex.getPageSize());
                return criteria.list();
            }
        });
	}

	@SuppressWarnings("unchecked")
	public List<Entry> listAllPublished() {
		return this.getHibernateTemplate()
			.executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(LIST_PUBLISHED_ENTRYS);
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Entry> list(final EntryCriteria entryCriteria) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = createCriteria(entryCriteria, session);
				return list(criteria);
			}

			private List<Entry> list(Criteria criteria) {
				return criteria.list();
			}

		});
			
	}
	
	private Criteria createCriteria(final EntryCriteria entryCriteria,
			Session session) {
		Criteria criteria = session.createCriteria(Entry.class);
		addOrder(entryCriteria, criteria);
		addRestriction(entryCriteria, criteria);
		addNull(entryCriteria, criteria);
		addNotNull(entryCriteria, criteria);
		addEmpty(entryCriteria, criteria);
		addNotEmpty(entryCriteria, criteria);
		criteria.setCacheable(entryCriteria.isCacheable());
		return criteria;
	}
	
	private void addNotEmpty(EntryCriteria entryCriteria,
			Criteria criteria) {
		List<EntryEmptyType> notEmptys = entryCriteria.getNotEmptys();
		for(EntryEmptyType type:notEmptys){
			String propertyName = type.getField();
			criteria.add(Restrictions.isNotEmpty(propertyName));
		}
	}
	
	private void addEmpty(EntryCriteria entryCriteria, Criteria criteria) {
		List<EntryEmptyType> emptys = entryCriteria.getEmptys();
		for(EntryEmptyType type:emptys){
			String propertyName = type.getField();
			criteria.add(Restrictions.isEmpty(propertyName));
		}
	}
	
	private void addNotNull(EntryCriteria entryCriteria,
			Criteria criteria) {
		List<EntryNullType> notNulls = entryCriteria.getNotNulls();
		for(EntryNullType type:notNulls){
			String propertyName = type.getField();
			criteria.add(Restrictions.isNotNull(propertyName));
		}
	}
	
	private void addNull(EntryCriteria entryCriteria, Criteria criteria) {
		List<EntryNullType> nulls = entryCriteria.getNulls();
		for(EntryNullType type:nulls){
			String propertyName = type.getField();
			criteria.add(Restrictions.isNull(propertyName));
		}
	}
	
	private void addRestriction(final EntryCriteria entryCriteria,
			Criteria criteria) {
		Map<EntryRestrictionType, Object> restrictions = entryCriteria.getRestrictions();
		Set<java.util.Map.Entry<EntryRestrictionType, Object>> restrictionSet = 
			restrictions.entrySet();
		for(java.util.Map.Entry<EntryRestrictionType, Object> entry: restrictionSet){
			String propertyName = entry.getKey().getField();
			criteria.add(Restrictions.eq(propertyName, entry.getValue()));
		}
	}
	
	private void addOrder(final EntryCriteria entryCriteria,
			Criteria criteria) {
		Map<EntryOrderType, Boolean> orders = entryCriteria.getOrders();
		Set<java.util.Map.Entry<EntryOrderType, Boolean>> orderSet = orders.entrySet();
		for(java.util.Map.Entry<EntryOrderType, Boolean> entry:orderSet){
			String propertyName = entry.getKey().getField();
			boolean desc = entry.getValue();
			criteria.addOrder(desc?Order.desc(propertyName):Order.asc(propertyName));
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entry> list(final EntryCriteria entryCriteria, final int number) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = createCriteria(entryCriteria, session);
				return list(criteria, number);
			}

			private List<Entry> list(Criteria criteria, int number) {
				criteria.setMaxResults(number);
				return criteria.list();
			}

		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Entry> list(final EntryCriteria entryCriteria, final PageIndex pageIndex) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Entry>>() {

			public List<Entry> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = createCriteria(entryCriteria, session);
				return list(criteria, pageIndex);
			}

			private List<Entry> list(Criteria criteria, PageIndex pageIndex) {
				criteria.setProjection(Projections.rowCount());
				int count = ((Number)criteria.uniqueResult()).intValue();
				pageIndex.setTotalRows(count);
				criteria.setProjection(null);
				criteria.setFirstResult(pageIndex.getStartRow());
				criteria.setMaxResults(pageIndex.getPageSize());
				return criteria.list();
			}

		});
	}
	
	public int countByNodeId(final Integer nodeId) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(COUNT_BY_NODE_ID)
					.setInteger(NODE_ID, nodeId);
				return ((Number) query.uniqueResult()).intValue();
			}
		});
	}
	
	public void changePosition(final int entryId, final Integer nodeId
			, final int oldPosition, final int newPosition) {
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(CHANGE_POSITION_BY_POSITION_AND_BELONGED)
					.setParameter(OLD_POSITION, oldPosition)
					.setParameter(NEW_POSITION, newPosition)
					.setParameter(NODE_ID, nodeId);
				query.executeUpdate();
				query = session.createQuery(CHANGE_POSITION_BY_ENTRY_ID)
					.setParameter(NEW_POSITION, newPosition)
					.setParameter(ENTRY_ID, entryId);
				query.executeUpdate();
				return null;
			}
		});
	}
	
	public void cleanPosition(final int nodeId, final int position) {
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(CLEAN_POSITION_BELOW_DELETED)
					.setParameter("nodeId", nodeId)
					.setParameter("position", position);
				query.executeUpdate();
				return null;
			}
		});
	}

	public void initPositionByNodeId(final Integer nodeId) {
		List<Entry> entrys = this.listByNodeId(nodeId);
		int i=0;
		for(Entry entry:entrys){
			entry.setPosition(++i);
			this.update(entry);
		}
	}

}
