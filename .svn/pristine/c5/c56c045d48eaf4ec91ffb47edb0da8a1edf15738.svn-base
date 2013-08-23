package com.boventech.cms.module.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BaseInfo implements Serializable {

	@Column(name = "SYSTEMINFO_NAME")
	private String systemName;

	@Column(name = "SYSTEMINFO_KEYWORD")
	private String keyWord;

	@Column(name = "SYSTEMINFO_COPYRIGHT")
	private String copyRight;

	@Column(name = "SYSTEMINFO_HOSTNAME")
	private String hostName;
	
	@Column(name = "SYSTEMINFO_DESCRIPTION")
	private String description;

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	private static final long serialVersionUID = 424265761066347918L;

}
