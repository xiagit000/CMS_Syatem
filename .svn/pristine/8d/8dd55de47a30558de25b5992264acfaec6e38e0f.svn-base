package com.boventech.cms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.ApplicationSettingDao;
import com.boventech.cms.module.ApplicationSetting;

@Repository
public class ApplicationSettingDaoImpl extends AbstractDaoImpl<ApplicationSetting, Integer>
	implements ApplicationSettingDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6696637296255584731L;

	private static final String KEY_PROPERTY = "key";
	
	public ApplicationSetting getByKey(String key) {
		List<ApplicationSetting> settings = this.listByProperty(KEY_PROPERTY, key);
		return settings.size() > 0 ? settings.get(0) : null;
	}

}
