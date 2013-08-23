package com.boventech.cms.action.admin.info;

import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.DataTypeAction;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.service.open.FriendlyLinkTypeService;

public class FriendlyLinkTypeAction extends DataTypeAction<FriendlyLinkType>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3359397362430599457L;

	@Override
	public String initCurrentAction() {
		return "/admin/info/friendly-link-type";
	}

	@Override
	public String initCurrentTypeName() {
		return "friendlyLinkType";
	}

	@Override
	public FriendlyLinkType newInstance() {
		return new FriendlyLinkType();
	}

	@Override
	public String destroy() {
		return null;
	}

	@Override
	public HttpHeaders show() {
		return null;
	}
	
	public void setFriendlyLinkTypeService(
			FriendlyLinkTypeService friendlyLinkTypeService) {
		this.initDataTypeService(friendlyLinkTypeService);
	}

}
