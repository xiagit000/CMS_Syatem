package com.boventech.cms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.web.PageIndex;

public abstract class AbstractDaoImpl<T, ID extends Serializable> implements AbstractDao<T, ID> {

    private static final String IDS = "ids";

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public Class<T> getPersistClass() {
        return persistClass;
    }

    /**
	 * 
	 */
    private static final long serialVersionUID = 2416439074188213079L;

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractDaoImpl.class);

    private HibernateTemplate hibernateTemplate;

    private Class<T> persistClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl() {
        this.persistClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void delete(T t) {
        this.hibernateTemplate.delete(t);
    }

    public T findById(ID id) {
        return (T) this.hibernateTemplate.get(this.persistClass, id);
    }

    public void save(T t) {
        this.hibernateTemplate.save(t);
    }

    public void saveOrUpdate(T t) {
        this.hibernateTemplate.saveOrUpdate(t);
    }

    public void update(T t) {
        this.hibernateTemplate.update(t);
    }

    @SuppressWarnings("unchecked")
    public void deleteById(final ID id) {
        final Class<T> persistentClass = this.persistClass;
        this.hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("delete from " + persistentClass.getName() + " where id="
                        + id);
                query.executeUpdate();
                return null;
            }
        });
    }

    public T load(ID id) {
        return (T) this.hibernateTemplate.load(this.persistClass, id);
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByProperty(final String propertyName, final Object property) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass).add(
                        Restrictions.eq(propertyName, property));
                return criteria.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByPropertys(final String[] propertyNames, final Object[] values) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                for (int i = 0; i < propertyNames.length && i < values.length; i++) {
                    criteria.add(Restrictions.eq(propertyNames[i], values[i]));
                }
                return criteria.list();
            }
        });

    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.setCacheable(true);
                return criteria.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    public List<T> list(final PageIndex pageIndex) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                return executeQuery(pageIndex, criteria);
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected List<T> listOrder(final PageIndex pageIndex, final String orderProperty, final boolean desc) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass).addOrder(
                        desc ? Order.desc(orderProperty) : Order.asc(orderProperty));
                return executeQuery(pageIndex, criteria);
            }
        });
    }

    @SuppressWarnings("unchecked")
    public int count() {
        final Class<T> persistentClass = this.persistClass;
        return (Integer) this.hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.setProjection(Projections.rowCount());
                int count = ((Number) criteria.list().get(0)).intValue();
                return count;
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected int countByProperty(final String propertyName, final Object value) {
        final Class<T> persistentClass = this.persistClass;
        return (Integer) this.hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.add(Restrictions.eq(propertyName, value));
                criteria.setProjection(Projections.rowCount());
                int count = ((Number) criteria.list().get(0)).intValue();
                return count;
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByProperty(final PageIndex pageIndex, final String propertyName,
            final Object property) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.add(Restrictions.eq(propertyName, property));
                return executeQuery(pageIndex, criteria);
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected int countByProperties(final String[] propertyNames, final Object[] values) {
        final Class<T> persistentClass = this.persistClass;
        return (Integer) this.hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                for (int i = 0; i < propertyNames.length && i < values.length; i++) {
                    criteria.add(Restrictions.eq(propertyNames[i], values[i]));
                }
                criteria.setProjection(Projections.rowCount());
                return ((Number) criteria.list().get(0)).intValue();
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected <D> List<D> listProperty(final String propertyName, final String condition,
            final Object conditionValue) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.add(Restrictions.eq(condition, conditionValue));
                criteria.setProjection(Projections.distinct(Projections.projectionList().add(
                        Projections.property(propertyName))));
                return criteria.list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByPropertyAndDesc(final PageIndex pageIndex, final String propertyName,
            final Object property, final String indexPropertyName, final boolean desc) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.add(Restrictions.eq(propertyName, property));
                criteria.addOrder(desc ? Order.desc(indexPropertyName) : Order.asc(indexPropertyName));
                return executeQuery(pageIndex, criteria);
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByPropertyAndSize(final int size, final String propertyName, final Object property) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass);
                criteria.add(Restrictions.eq(propertyName, property));
                return criteria.setMaxResults(size).list();
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByPropertiesAndSize(final int size, final String[] propertyNames,
            final Object[] properties) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(persistentClass).setCacheable(true);
                for (int i = 0; i < propertyNames.length && i < properties.length; i++) {
                    criteria.add(Restrictions.eq(propertyNames[i], properties[i]));
                }
                return criteria.setMaxResults(size).list();
            }
        });
    }

    protected Object executeQuery(final PageIndex pageIndex, Criteria criteria) {
        criteria.setProjection(Projections.rowCount());
        int count = ((Number) criteria.list().get(0)).intValue();
        pageIndex.setTotalRows(count);
        pageIndex.clearPageNumber();
        criteria.setProjection(null);
        criteria.setFirstResult(pageIndex.getStartRow());
        criteria.setMaxResults(pageIndex.getPageSize());
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    protected List<T> listByIds(final Integer[] ids) {
        final Class<T> persistentClass = this.persistClass;
        return this.hibernateTemplate.executeFind(new HibernateCallback<List<T>>() {

            public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
                Query listQuery = session.createQuery(
                        "from " + persistentClass.getName() + " e where e.id in (:ids)").setParameterList(
                        IDS, ids);
                return (List<T>) listQuery.list();
            }
        });
    }

    protected List<?> executeListWithPaging(final String hql, final PageIndex pageIndex,
            final Object... params) {
        return (List<?>) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws SQLException {
                if (pageIndex != null) {
                    Query countQuery = session.createQuery("select count(*) " + getCountHqlNotOrder(hql));
                    initCountQuery(countQuery, pageIndex, params);
                }
                Query query = session.createQuery(hql);
                initQuery(query, pageIndex, params);
                return query.list();
            }
        });
    }
    
    protected List<?> executeListWithPagingOutOfParams(final String hql, final PageIndex pageIndex) {
        return (List<?>) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws SQLException {
                if (pageIndex != null) {
                    Query countQuery = session.createQuery("select count(*) " + getCountHqlNotOrder(hql));
                    initCountQuery(countQuery, pageIndex, null);
                }
                Query query = session.createQuery(hql);
                initQuery(query, pageIndex, null);
                return query.list();
            }
        });
    }
    
    private void initCountQuery(final Query countQuery, final PageIndex pageIndex, final Object... params) {
        setParams(countQuery, params);
        Object count = countQuery.iterate().next();
        pageIndex.setTotalRows(((Long) count).intValue());
    }
    
    private void initQuery(final Query query, final PageIndex pageIndex, final Object... params) {
        setParams(query, params);
        if (pageIndex != null) {
            query.setFirstResult(pageIndex.getStartRow());
            query.setMaxResults(pageIndex.getPageSize());
            query.setCacheable(true);
        }
    }

    private void setParams(Query query, Object... params) {
        if (params != null && params.length != 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
    }
    
    private String getCountHqlNotOrder(String hql) {
        String newHql = "";
        int index = hql.indexOf("order by");
        if (index != -1) {
            newHql = hql.substring(0, index);
        } else {
            return hql;
        }
        return newHql;
    }

}
