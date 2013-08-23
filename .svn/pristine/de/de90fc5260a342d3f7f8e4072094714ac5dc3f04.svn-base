package com.boventech.cms.module.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttachmentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3660953471788013572L;

	@Column(name = "SYSTEMINFO_ALLOWATTACHMENT")
	private Boolean allowAttachment;

	@Column(name = "SYSTEMINFO_ATTACHMENTSIZE")
	private Integer attachmentSize;
	
	@Column(name = "SYSTEMINFO_ATTACHMENTTYPE")
	private String attachmentType;
	
	@Column(name = "SYSTEMINFO_ATTACHMENTEXTENSION")
	private String attachmentExtension;

	public Boolean getAllowAttachment() {
		return allowAttachment;
	}

	public Integer getAttachmentSize() {
		return attachmentSize;
	}

	public void setAttachmentSize(Integer attachmentSize) {
		this.attachmentSize = attachmentSize;
	}

	public void setAllowAttachment(Boolean allowAttachment) {
		this.allowAttachment = allowAttachment;
	}
	
	public String getAttachmentType() {
		return attachmentType;
	}
	
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	
	public String getAttachmentExtension() {
		return attachmentExtension;
	}
	
	public void setAttachmentExtension(String attachmentExtension) {
		this.attachmentExtension = attachmentExtension;
	}

}
