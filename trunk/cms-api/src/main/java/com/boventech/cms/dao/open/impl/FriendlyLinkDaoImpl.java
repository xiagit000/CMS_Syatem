package com.boventech.cms.dao.open.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.open.FriendlyLinkDao;
import com.boventech.cms.module.open.FriendlyLink;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.module.web.PageIndex;

@Repository
public class FriendlyLinkDaoImpl extends AbstractDaoImpl<FriendlyLink, Integer> implements FriendlyLinkDao{


	/**
     * 
     */
    private static final long serialVersionUID = 4365463687891248036L;

    private static final String TYPE = "type";

    private static final String POSITION = "position";

    @SuppressWarnings("unchecked")
    public List<FriendlyLink> listByPosition(final PageIndex pageIndex, final boolean desc) {
    	
    	
    	
    	
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
            	Query query = session.createQuery("from FriendlyLink fl order by fl.position");
            	return query.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<FriendlyLink> listByPosition(final boolean desc) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(FriendlyLink.class);
                criteria.addOrder(desc ? Order.desc(POSITION) : Order.asc(POSITION));
                return criteria.list();
            }
        });
    }

	public List<FriendlyLink> findByPosition(int position) {
		return listByProperty(POSITION, position);
	}

	@SuppressWarnings("unchecked")
	public List<FriendlyLink> listByTypeAndPosition(final FriendlyLinkType type,
			final boolean desc) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			public List doInHibernate(Session session) throws HibernateException,SQLException {
				String hql = "from FriendlyLink f where f.type.id="
						+ type.getId() + " order by position "
						+ (desc ? "desc" : "asc");
				return session.createQuery(hql).setCacheable(true).list();
			}
		});
	}

	public int count(FriendlyLinkType type) {
		return countByProperty(TYPE, type);
	}

	@SuppressWarnings("unchecked")
	public FriendlyLink getByTypeAndPosition(FriendlyLinkType type, int position) {
		List<FriendlyLink> ts = this.getHibernateTemplate().find("from FriendlyLink fl where fl.type.id=" 
				+ type.getId() + " and fl.position=" + position);
		return ts != null && ts.size() > 0 ? ts.get(0) : null;
	}

}
