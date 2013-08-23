package com.boventech.cms.action.admin.user;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.module.user.LdapSetting;
import com.boventech.cms.service.user.LdapSettingService;
import com.boventech.web.annotation.Before;

@Results({
	@Result(name = "toIndex", type = "redirect", location = "/admin/user/ldap")
})
public class LdapAction extends AdminAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1269993507200175330L;

	private LdapSetting setting;
	
	private LdapSettingService ldapSettingService;

	private int port;

	private String admin;

	private String password;

	private boolean secure;

	private String host;

	private String baseDN;

	private String loginName;
	
	@Before(include = {"index", "update"})
	public void prepare(){
		this.setting = this.ldapSettingService.getSetting();
		if(this.setting == null)
			this.setting = new LdapSetting();
	}
	
	@Override
	public HttpHeaders create() {
		return null;
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
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		this.setting.setName("default");
		this.setting.setHost(host);
		this.setting.setPort(port);
		this.setting.setSecure(secure);
		this.setting.setAdmin(admin);
		this.setting.setPassword(password);
		this.setting.setBaseDN(baseDN);
		this.setting.setLoginName(loginName);
		this.ldapSettingService.saveOrUpdate(this.setting);
		addFlashMessage(getText(FlashMessageConstants.LDAP_UPDATE_SUCCESS));
		return TO_INDEX;
	}
	
	public LdapSetting getSetting() {
		return setting;
	}

	public void setLdapSettingService(LdapSettingService ldapSettingService) {
		this.ldapSettingService = ldapSettingService;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setBaseDN(String baseDN) {
		this.baseDN = baseDN;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
