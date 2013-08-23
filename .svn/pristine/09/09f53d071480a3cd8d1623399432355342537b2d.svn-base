package com.boventech.cms.action.admin.description;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.module.description.Description;
import com.boventech.cms.service.description.DescriptionService;
import com.boventech.util.action.ActionUtil;
import com.boventech.web.annotation.Before;

@Result(name="success", type = "redirect", location = "/admin/description/manage")
public class ManageAction extends AdminAction {

	private static final String NOT = "N";

	private static final String YES = "Y";
	
	private DescriptionService descriptionService;
	private List<Description> descriptions;
	
	private String name;
	private String description;
	private String alias;
	
	@Before(include = { "index" })
	public void prepareIndex() {
		this.descriptions = this.descriptionService.list(false);
	}
	
	@Override
	public HttpHeaders create() {
		Description description = new Description();
		setParameters(description);
		this.descriptionService.save(description);
		return new DefaultHttpHeaders("success").disableCaching();
	}

	
	@Override
	public String destroy() {
		Integer id = getIntegerId();
		this.descriptionService.delById(id);
		redirect();
		return null;
	}

	@Override
	public String edit() {
		Integer id = getIntegerId();
		Description des  = this.descriptionService.findById(id);
		this.name = des.getName();
		this.description = des.getDescription();
		this.alias = des.getAlias();
		return EDIT;
	}

	@Override
	public HttpHeaders editNew() {
		return new DefaultHttpHeaders(NEW).disableCaching();
	}

	@Override
	public HttpHeaders index() {
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		Integer id = getIntegerId();
		Description des = this.descriptionService.findById(id);
		setParameters(des);
		this.descriptionService.update(des);
		return "success";
	}

	public void checkAlias() {
		String type = ActionUtil.getRequestParameter("type");
		if (type.equals("new")) {
			Description description = this.descriptionService
					.findByAlias(this.alias);
			String result = (description == null) ? YES : NOT;
			ActionUtil.writeResponse(result);
		} else {
			String oldAlias = ActionUtil.getRequestParameter("oldAlias");
			String result = NOT;
			if (this.alias.equals(oldAlias)) {
				result = YES;
			} else {
				Description description = this.descriptionService
						.findByAlias(this.alias);
				if (description == null) {
					result = YES;
				}
			}
			ActionUtil.writeResponse(result);
		}
	}

	private void setParameters(Description des) {
		des.setName(this.name);
		des.setDescription(this.description);
		des.setAlias(this.alias);
	}

	public void setDescriptionService(DescriptionService descriptionService) {
		this.descriptionService = descriptionService;
	}

	public DescriptionService getDescriptionService() {
		return descriptionService;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}

	private static final long serialVersionUID = 5607051749424735194L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

}
