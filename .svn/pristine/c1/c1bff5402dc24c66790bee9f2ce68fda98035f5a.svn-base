package com.boventech.cms.service.system.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.system.SystemInfoDao;
import com.boventech.cms.module.system.SystemInfo;
import com.boventech.cms.service.system.SystemInfoService;

@Service
@Transactional
public class SystemInfoServiceImpl implements SystemInfoService {

	private SystemInfoDao systemInfoDao;
	
	public SystemInfo updateSystemInfo(final SystemInfo systemInfo) {
		this.systemInfoDao.update(systemInfo);
		return this.systemInfoDao.getSystemInfo();
	}
	
	public SystemInfo loadSystemInfo() {
		return this.systemInfoDao.getSystemInfo();
	}
	
	public void setSystemInfoDao(SystemInfoDao systemInfoDao) {
		this.systemInfoDao = systemInfoDao;
	}
	
	public SystemInfoDao getSystemInfoDao() {
		return systemInfoDao;
	}

}
