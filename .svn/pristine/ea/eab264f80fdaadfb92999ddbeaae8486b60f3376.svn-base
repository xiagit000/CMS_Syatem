package com.boventech.cms.service.log.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.log.LogDao;
import com.boventech.cms.module.log.AppLog;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.log.LogService;

@Service
@Transactional
public class LogServiceImpl implements LogService{

	private LogDao logDao;
	
	public void delete(AppLog t) {
		this.logDao.delete(t);
	}

	public AppLog findById(Integer id) {
		return this.logDao.findById(id);
	}

	public void save(AppLog t) {
		this.logDao.save(t);
	}

	public void update(AppLog t) {
		this.logDao.update(t);
	}
	
	public List<AppLog> list(PageIndex pageIndex) {
		return this.logDao.listOrderByTime(pageIndex);
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
}
