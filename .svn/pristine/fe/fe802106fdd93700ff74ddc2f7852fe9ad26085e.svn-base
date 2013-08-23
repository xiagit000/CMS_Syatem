package com.boventech.cms.dao.system.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.system.SystemInfoDao;
import com.boventech.cms.module.system.SystemInfo;

@Repository
public class SystemInfoDaoImpl implements SystemInfoDao{

	@Resource
	private HibernateTemplate hibernateTemplate;

	public SystemInfo getSystemInfo() {
		return this.hibernateTemplate.execute(new HibernateCallback<SystemInfo>() {

			public SystemInfo doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select s from " + SystemInfo.class.getName() + " s";
				Query query = session.createQuery(hql);
				return (SystemInfo) query.uniqueResult();
			}
			
		});
	}
	
	public void update(SystemInfo systemInfo) {
		this.hibernateTemplate.merge(systemInfo);
	}

}
