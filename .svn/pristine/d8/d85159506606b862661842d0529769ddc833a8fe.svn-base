package com.boventech.cms.dao.description.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.description.DescriptionDao;
import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.module.description.Description;

@Repository
public class DescriptionDaoImpl extends AbstractDaoImpl<Description, Integer> implements
		DescriptionDao {

	private static final String ALIAS = "alias";

	private static final long serialVersionUID = -3917382733165251391L;
	
	private static final String LIST = "select des from Description des";
	
	public List<Description> list(final boolean cacheEnable) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Description>>() {
			@SuppressWarnings("unchecked")
			public List<Description> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(LIST);
				query.setCacheable(cacheEnable);
				return query.list();
			}
		});
	}

	public Description findByAlias(String name) {
		List<Description> descs = listByProperty(ALIAS, name); 
		return descs != null && descs.size() > 0 ? descs.get(0) : null;
	}

}
