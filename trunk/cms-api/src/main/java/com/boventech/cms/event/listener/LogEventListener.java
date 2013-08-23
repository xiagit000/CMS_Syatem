package com.boventech.cms.event.listener;

import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventListener;
import com.boventech.cms.module.log.AppLog;
import com.boventech.cms.service.log.LogService;

public class LogEventListener implements EventListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731444395267317218L;

	private LogService logService;
	
	public void processEvent(Event event) {
		AppLog appLog = new AppLog();
		appLog.setUsername(event.getUsername());
		appLog.setCreateTime(event.getDate());
		appLog.setOperation(event.getOperation().toString());
		appLog.setTargetIdentifier(String.valueOf(event.getObjId()));
		appLog.setTargetType(event.getObjClass() != null ? event.getObjClass().getName() : "");
		this.logService.save(appLog);
	}
	
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
}
