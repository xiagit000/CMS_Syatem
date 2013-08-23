package com.boventech.cms.action.open;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.module.description.Description;

@Actions({
	@Action("meta")
})
@Result(name = "show", location = "description-show.jsp", type = "dispatcher")
public class DescriptionAction extends OpenAction {

	private static final long serialVersionUID = 7053328199943869929L;

	private Description description;
	
	@Override
	public HttpHeaders show() {
		super.setLinks();
		String name = this.getId();
		this.description = getDescriptionService().findByAlias(name);
		return new DefaultHttpHeaders(SHOW).disableCaching();
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Description getDescription() {
		return description;
	}

	
	
}
