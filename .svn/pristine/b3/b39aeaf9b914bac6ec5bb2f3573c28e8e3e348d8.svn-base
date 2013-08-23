package com.boventech.cms.action.admin.system;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.ApplicationUtils;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.action.util.URLPatternEngine;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.system.AttachmentInfo;
import com.boventech.cms.module.system.BaseInfo;
import com.boventech.cms.module.system.HighlightInfo;
import com.boventech.cms.module.system.SystemInfo;
import com.boventech.cms.service.system.SystemInfoService;

@Result(name = "success", location = "/admin/system/manage", type = "redirect")
public class ManageAction extends AdminAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7099859583242429090L;

	private BaseInfo baseInfo;
	
	private AttachmentInfo attachmentInfo;
	
	private HighlightInfo hightlightInfo;
	
	private SystemInfoService systemInfoService;
	
	private boolean allowComment;
	
	private String urlPattern;

	private boolean allowLDAP;
	
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
		SystemInfo systemInfo = this.getSystemInfoService().loadSystemInfo();
		if (systemInfo == null) {
			systemInfo = new SystemInfo();
			systemInfo.setBaseInfo(new BaseInfo());
			systemInfo.setAttachmentInfo(new AttachmentInfo());
			systemInfo.setHighlightInfo(new HighlightInfo());
			systemInfo.setAllowComment(false);
			systemInfo.setAllowLDAP(false);
			systemInfo = this.getSystemInfoService().updateSystemInfo(systemInfo);
		}
		this.attachmentInfo = systemInfo.getAttachmentInfo();
		this.baseInfo = systemInfo.getBaseInfo();
		this.hightlightInfo = systemInfo.getHighlightInfo();
		this.allowComment = systemInfo.isAllowComment();
		this.allowLDAP = systemInfo.isAllowLDAP();
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		SystemInfo oldInfo = this.systemInfoService.loadSystemInfo();
		oldInfo.setAttachmentInfo(this.attachmentInfo);
		oldInfo.setBaseInfo(this.baseInfo);
		oldInfo.setHighlightInfo(this.hightlightInfo);
		oldInfo.setAllowComment(getCommentEnabled() && this.allowComment);
		oldInfo.setAllowLDAP(getLdapEnabled() && this.allowLDAP);
		oldInfo.setUrlPattern(this.urlPattern);
		SystemInfo newInfo = this.getSystemInfoService().updateSystemInfo(oldInfo);
		doBroadCast(EventType.UPDATE_SYSTEM_INFO, oldInfo.getId());
		ServletContext context = ServletActionContext.getServletContext();
		ApplicationUtils.updateSystemInfo(context, newInfo);
		//restart the URLPatternEngine
		URLPatternEngine.restart(context);
		addFlashMessage(getText(FlashMessageConstants.SYSTEM_COFIG_UPDATE_SUCCESS));
		return "success";
	}
	
	 /**
	 * broadcast user operation events.
	 * @param type		EventType
	 * @param userId	the id of user
	 */
	private void doBroadCast(EventType type, Integer infoId){
		Event event = new Event(getCurrentUser().getUsername(),
				type, infoId, SystemInfo.class);
		EventManager.getManager().broadcastEvent(event);
	}


	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public AttachmentInfo getAttachmentInfo() {
		return attachmentInfo;
	}

	public void setAttachmentInfo(AttachmentInfo attachmentInfo) {
		this.attachmentInfo = attachmentInfo;
	}

	public HighlightInfo getHightlightInfo() {
		return hightlightInfo;
	}

	public void setHightlightInfo(HighlightInfo hightlightInfo) {
		this.hightlightInfo = hightlightInfo;
	}

	public void setSystemInfoService(SystemInfoService systemInfoService) {
		this.systemInfoService = systemInfoService;
	}

	public SystemInfoService getSystemInfoService() {
		return systemInfoService;
	}

	public void setAllowComment(boolean allowComment) {
		this.allowComment = allowComment;
	}

	public boolean isAllowComment() {
		return allowComment;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getUrlPattern() {
		return urlPattern;
	}
	
	public boolean isAllowLDAP() {
		return allowLDAP;
	}
	
	public void setAllowLDAP(boolean allowLDAP) {
		this.allowLDAP = allowLDAP;
	}

}
