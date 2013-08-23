package com.boventech.cms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.ApplicationSettingDao;
import com.boventech.cms.module.ApplicationSetting;
import com.boventech.cms.service.ApplicationSettingService;

@Service
@Transactional
public class ApplicationSettingServiceImpl implements ApplicationSettingService{

	private ApplicationSettingDao applicationSettingDao;
	
	public void delete(ApplicationSetting t) {
		this.applicationSettingDao.delete(t);
	}

	public ApplicationSetting findById(Integer id) {
		return this.applicationSettingDao.findById(id);
	}

	public void save(ApplicationSetting t) {
		this.applicationSettingDao.save(t);
	}

	public void update(ApplicationSetting t) {
		this.applicationSettingDao.update(t);
	}
	
	public ApplicationSetting getByKey(String key) {
		return this.applicationSettingDao.getByKey(key);
	}
	
	public void setApplicationSettingDao(
			ApplicationSettingDao applicationSettingDao) {
		this.applicationSettingDao = applicationSettingDao;
	}

	public void saveOrUpdate(ApplicationSetting setting) {
		this.applicationSettingDao.saveOrUpdate(setting);
	}
}
