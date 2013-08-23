/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 208 $
 * $Author: peng.xia $
 * $LastChangedDate: 2012-11-30 10:45:36 +0800 (星期五, 30 十一月 2012) $
 *
 */

package com.boventech.sacwh.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.AdwordDao;
import com.boventech.sacwh.module.Adword;

@Repository
public class AdwordDaoImpl extends AbstractDaoImpl<Adword, Integer> implements AdwordDao {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see com.boventech.sacwh.dao.AdwordDao#listOrderBy()
     */
    @SuppressWarnings("unchecked")
    public List<Adword> listOrderBy() {
        // TODO Auto-generated method stub
        return getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Adword.class);
                criteria.setCacheable(true);
                criteria.addOrder(Order.desc("order_id"));//升序
                return criteria.list();
            }
        });
    }

    /* (non-Javadoc)
     * @see com.boventech.sacwh.dao.AdwordDao#listOrderBy(com.boventech.cms.module.web.PageIndex)
     */
    @SuppressWarnings("unchecked")
    public List<Adword> listOrderBy(final PageIndex pageIndex,final String property) {
        // TODO Auto-generated method stub
        return getHibernateTemplate().executeFind(new HibernateCallback<Object>() {

            public Object doInHibernate(final Session session) throws HibernateException, SQLException {
                final Criteria criteria = session.createCriteria(Adword.class);
                criteria.setCacheable(true);
                criteria.addOrder(Order.desc(property));//升序
                return executeQuery(pageIndex, criteria);
            }
        });
    }

    

}
