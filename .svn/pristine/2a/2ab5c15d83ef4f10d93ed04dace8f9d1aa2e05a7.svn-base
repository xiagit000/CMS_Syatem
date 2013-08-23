package com.boventech.cms.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.boventech.cms.dao.DataTypeDao;
import com.boventech.cms.module.DataType;
import com.boventech.cms.module.web.PageIndex;

@SuppressWarnings("unchecked")
public class DataTypeDaoImpl<T extends DataType> extends AbstractDaoImpl<T, Integer> implements DataTypeDao<T>{

    private static final String NAME = "name";

    private static final String POSITION = "position";
    /**
     * 
     */
    private static final long serialVersionUID = -6327149897082620927L;
    
    private Class<T> currentClass = (Class<T>) ((ParameterizedType)
            getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public List<T> listByPosition(final boolean desc) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(currentClass).setCacheable(true);
                criteria.addOrder(desc ? Order.desc(POSITION):Order.asc(POSITION));
                return criteria.list();
            }
        });
    }

    public int count() {
        return (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(currentClass).setCacheable(true);
                criteria.setProjection(Projections.rowCount());
                int count = ((Number)criteria.uniqueResult()).intValue();
                return count;
            }
        });
    }

    public List<T> listByPosition(final PageIndex pageIndex, final boolean desc) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(currentClass).setCacheable(true);
                criteria.addOrder(desc ? Order.desc(POSITION):Order.asc(POSITION));
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

	public List<T> findByName(String name) {
		return listByProperty(NAME, name);
	}

	public List<T> findByPosition(int position) {
		return listByProperty(POSITION, position);
	}

}
