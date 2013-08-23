package com.boventech.cms.event;

import java.io.Serializable;
import java.util.Date;

public class Event{

	private static final long serialVersionUID = 8539434246581970462L;

	private String username = null;
	
	private Date date = null;
	
	private EventType operation = null;
	
	private Serializable objId = null;
	
	private Class<?> objClass;


	public Event(String user, EventType operation, Serializable objId, Class<?> objClass) {
		this.username = user;
		this.date = new Date();
		this.operation = operation;
		this.objId = objId;
		this.objClass = objClass;
	}


	public String getUsername() {
		return username;
	}

	public Date getDate() {
		return date;
	}

	public EventType getOperation() {
		return operation;
	}

	public Serializable getObjId() {
		return objId;
	}

	public Class<?> getObjClass() {
		return objClass;
	}

	public void setObjClass(Class<?> objClass) {
		this.objClass = objClass;
	}
}
