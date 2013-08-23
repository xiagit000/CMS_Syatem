package com.boventech.cms.dao.index.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.index.BlockDao;
import com.boventech.cms.module.index.Block;

@Repository
public class BlockDaoImpl extends AbstractDaoImpl<Block, Long> implements
		BlockDao {

	private static final long serialVersionUID = -6382406086751342963L;

	public int nextIndex() {
		int count = count();
		final int index = count + 1;
		return index;
	}
	
	@SuppressWarnings("unchecked")
	public int count() {
		 final Class<Block> persistentClass = Block.class;
	        return (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                Criteria criteria = session.createCriteria(persistentClass);
	                criteria.setCacheable(true);
	                criteria.setProjection(Projections.rowCount());
	                int count = ((Number)criteria.uniqueResult()).intValue();
	                return count;
	            }
	        });
	}

	public void updateIndex(int index) {
		final String hql = "update Block b set b.index = b.index - 1 where b.index > " + index;
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.executeUpdate();
				return null;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Block> list() {
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "select b from Block b order by b.index";
				return session.createQuery(hql).setCacheable(true).list();
			}
		});
	}

}
