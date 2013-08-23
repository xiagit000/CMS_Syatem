package com.boventech.cms.action.admin.image;

import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.WebUtil;
import com.boventech.cms.module.Image;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.ImageService;

public class ManageAction extends AdminAction{

	private static final int SUPER_NUMBER = 50;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367816391466217446L;

	private ImageService imageService;
	
	private List<Image> images;
	
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
		PageIndex pageIndex = WebUtil.createPageIndex(SUPER_NUMBER);
		this.images = this.imageService.list(pageIndex);
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

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public List<Image> getImages() {
		return images;
	}

}
