package com.boventech.cms.service;

import com.boventech.cms.module.ApplicationSetting;

public interface ApplicationSettingService extends BasicService<ApplicationSetting>{

	ApplicationSetting getByKey(String key);
	
	void saveOrUpdate(ApplicationSetting setting);
}
