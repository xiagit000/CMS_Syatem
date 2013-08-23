package com.boventech.cms.action.open;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.action.util.ApplicationConstants;
import com.boventech.cms.action.util.ApplicationUtils;
import com.boventech.cms.module.node.Menu;

@Action("sitemap")
@Result(name = "index", type = "dispatcher", location = "sitemap.jsp")
public class SiteMapAction extends OpenAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7736575191602132534L;

	private List<Menu> links;
	
	@Override
	public HttpHeaders index() {
		this.links = ApplicationUtils.get(ApplicationConstants.OPEN_MENUS);
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}
	
	public List<Menu> getLinks() {
		return links;
	}
}
