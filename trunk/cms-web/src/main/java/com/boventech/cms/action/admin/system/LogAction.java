package com.boventech.cms.action.admin.system;

import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.module.log.AppLog;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.log.LogService;

public class LogAction extends AdminAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -565739993723622352L;
	
	private LogService logService;
	
	private List<AppLog> logs;

	@Override
	public HttpHeaders create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String destroy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders editNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders index() {
		PageIndex pageIndex = getPageIndex();
		this.logs = this.logService.list(pageIndex);
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AppLog> getLogs() {
		return logs;
	}
	
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
}
