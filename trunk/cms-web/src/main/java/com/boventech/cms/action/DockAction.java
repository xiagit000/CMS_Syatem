package com.boventech.cms.action;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;

/**
 * the dock action for building actions with no implements
 * @author Junxue Rao
 *
 */
public class DockAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8454212453549149690L;

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
		return new DefaultHttpHeaders("building").disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		return null;
	}

}
