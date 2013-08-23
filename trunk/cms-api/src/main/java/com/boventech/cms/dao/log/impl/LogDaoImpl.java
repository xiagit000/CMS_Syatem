package com.boventech.cms.dao.log.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.log.LogDao;
import com.boventech.cms.module.log.AppLog;
import com.boventech.cms.module.web.PageIndex;

@Repository
public class LogDaoImpl extends AbstractDaoImpl<AppLog, Integer> implements LogDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 379733251745183687L;

	private static final String CREATE_TIME = "createTime";

	public List<AppLog> listOrderByTime(PageIndex pageIndex) {
		return listOrder(pageIndex, CREATE_TIME, true);
	}

}
