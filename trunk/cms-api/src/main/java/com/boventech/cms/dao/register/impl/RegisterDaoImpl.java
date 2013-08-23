package com.boventech.cms.dao.register.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.register.RegisterDao;
import com.boventech.cms.module.register.Register;
import com.boventech.cms.module.web.PageIndex;

@Repository
public class RegisterDaoImpl extends AbstractDaoImpl<Register, Long> implements RegisterDao{

	private static final long serialVersionUID = -8641838244056318191L;
	private static final String LIST_HQL = "select reg from " + Register.class.getName() + " reg";
	private static final String COUNT_HQL = "select count(*) from " + Register.class.getName();

	@SuppressWarnings("unchecked")
	public List<Register> list(final PageIndex index) {
		index.setTotalRows(count());
		List<Register> list =  this.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				Query query = arg0.createQuery(LIST_HQL);
				query.setFirstResult(index.getStartRow());
				query.setFetchSize(index.getPageSize());
				return query.list();
			}
		});
		return list;
	}

	public Long getCount() {
		return Long.valueOf((this.getHibernateTemplate().find(COUNT_HQL).iterator().next().toString()));
	}
	
	@Override
	public Class<Register> getPersistClass() {
		return Register.class;
	}
}
