package com.boventech.cms.module.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemInfo implements Serializable {

	public static final SystemInfo EMPTY_INSTANCE = new SystemInfo();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Embedded
	private BaseInfo baseInfo;

	@Embedded
	private HighlightInfo highlightInfo;

	@Embedded
	private AttachmentInfo attachmentInfo;

	@Column(name = "SYSTEMINFO_ALLOWCOMMENT")
	private Boolean allowComment;
	
	@Column(name = "SYSTEMINFO_ALLOWLDAP")
	private boolean allowLDAP;
	
	@Column(name = "SYSTEMINFO_URLPATTERN")
	private String urlPattern;
	
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public HighlightInfo getHighlightInfo() {
		return highlightInfo;
	}

	public AttachmentInfo getAttachmentInfo() {
		return attachmentInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public void setHighlightInfo(HighlightInfo highlightInfo) {
		this.highlightInfo = highlightInfo;
	}

	public void setAttachmentInfo(AttachmentInfo attachmentInfo) {
		this.attachmentInfo = attachmentInfo;
	}

	public void setAllowComment(Boolean allowComment) {
		this.allowComment = allowComment;
	}

	public Boolean isAllowComment() {
		return allowComment;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getUrlPattern() {
		if(urlPattern != null && !urlPattern.startsWith("/"))
			urlPattern = "/" + urlPattern;
		return urlPattern;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4261531575430853889L;

	public boolean isAllowLDAP() {
		return allowLDAP;
	}

	public void setAllowLDAP(boolean allowLDAP) {
		this.allowLDAP = allowLDAP;
	}

	public Boolean getAllowComment() {
		return allowComment;
	}

}
