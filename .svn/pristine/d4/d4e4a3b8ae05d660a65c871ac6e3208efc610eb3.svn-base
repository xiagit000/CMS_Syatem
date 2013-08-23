package com.boventech.cms.action.admin.application;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.ApplicationConstants;
import com.boventech.cms.module.ApplicationSetting;
import com.boventech.cms.service.ApplicationSettingService;

public class SettingAction extends AdminAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7182869763074818427L;

	private String baseURL;
	
	private ApplicationSettingService applicationSettingService;
	
	@Override
	public HttpHeaders create() {
		ApplicationSetting setting = this.applicationSettingService.getByKey(ApplicationConstants.BASE_URL);
		if(setting == null){
			setting = new ApplicationSetting();
			setting.setKey(ApplicationConstants.BASE_URL);
		}
		setting.setValue(this.baseURL);
		this.applicationSettingService.saveOrUpdate(setting);
		return new DefaultHttpHeaders(SUCCESS).disableCaching();
	}

	@Override
	public String destroy() {
		return null;
	}

	@Override
	public String edit() {
		return null;
	}

	@Override
	public HttpHeaders editNew() {
		return null;
	}

	@Override
	public HttpHeaders index() {
		ApplicationSetting setting = this.applicationSettingService.getByKey(ApplicationConstants.BASE_URL);
		this.baseURL = setting != null ? setting.getValue() : "";
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		return null;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public void setApplicationSettingService(
			ApplicationSettingService applicationSettingService) {
		this.applicationSettingService = applicationSettingService;
	}

}
