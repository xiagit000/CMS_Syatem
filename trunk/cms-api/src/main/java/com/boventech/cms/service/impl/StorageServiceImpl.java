package com.boventech.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boventech.util.action.ActionUtil;

@Service
public class StorageServiceImpl {

	@Resource
	private String basePath;
	
	@Resource
	private String imagePath;
	
	@Resource
	private String attachmentPath;
	
	public String getRealBase(){
		return ActionUtil.getContextRealPath();
	}
	
	public String getRealBasePath(){
		return ActionUtil.getContextRealPath() + this.basePath;
	}
	
	public String getRealImagePath(){
		return ActionUtil.getContextRealPath() + this.basePath + this.imagePath;
	}
	
	public String getBaseImagePath(){
		return this.basePath + this.imagePath;
	}
	
	public String getRealAttachmentPath(){
		return ActionUtil.getContextRealPath() + this.basePath + this.attachmentPath;
	}
	
	public String getBaseAttachmentPath(){
		return this.basePath + this.attachmentPath;
	}

	public String getBasePath() {
		return this.basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	public String getAttachmentPath() {
		return attachmentPath;
	}

}
