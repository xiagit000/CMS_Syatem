package com.boventech.cms.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.user.LdapSettingDao;
import com.boventech.cms.module.user.LdapSetting;
import com.boventech.cms.service.user.LdapSettingService;

@Service
@Transactional
public class LdapSettingServiceImpl implements LdapSettingService{

	private LdapSettingDao ldapSettingDao;
	
	public LdapSetting getSetting() {
		List<LdapSetting> settings = this.ldapSettingDao.list();
		return settings != null && settings.size() > 0 ? settings.get(0) : null;
	}
	
	public void saveOrUpdate(LdapSetting setting) {
		this.ldapSettingDao.saveOrUpdate(setting);
	}
	
	public void delete(LdapSetting t) {
		this.ldapSettingDao.delete(t);
	}

	public LdapSetting findById(Integer id) {
		return this.ldapSettingDao.findById(id);
	}

	public void save(LdapSetting t) {
		this.ldapSettingDao.save(t);
	}

	public void update(LdapSetting t) {
		this.ldapSettingDao.update(t);
	}

	public void setLdapSettingDao(LdapSettingDao ldapSettingDao) {
		this.ldapSettingDao = ldapSettingDao;
	}
}
