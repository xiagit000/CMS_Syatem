package com.boventech.cms.action.admin.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.right.Role;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.right.RoleService;
import com.boventech.web.annotation.Before;

public class RightAction extends AdminAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2747772609171625778L;
	
	private RoleService roleService;
	
	private List<User> users;
	
	private User user;
	
	private Integer[] selectRoles= {};
	
	@Before(include = {"edit","update"})
	public void prepare(){
		this.user = this.getUserService().findById(getIntegerId());
	}
	
	public List<Role> getRoles(){
		return this.roleService.list();
	}

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
		return EDIT;
	}

	@Override
	public HttpHeaders editNew() {
		return null;
	}

	@Override
	public HttpHeaders index() {
		this.users = this.getUserService().list(getPageIndex());
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		List<Role> roles = new ArrayList<Role>();
		for(Integer selRole:selectRoles){
			Role role = this.roleService.findById(selRole);
			if(role != null){
				roles.add(role);
			}
		}
		this.user.replaceRoles(roles);
		this.getUserService().update(this.user);
		addFlashMessage(getText(FlashMessageConstants.UPDATE_SUCCESS));
		doBroadCast(EventType.ASSIGN_ROLE, this.user.getId());
		redirect();
		return null;
	}
	
	/**
	 * broadcast user operation events.
	 * @param type		EventType
	 * @param userId	the id of user
	 */
	private void doBroadCast(EventType type, Integer userId){
		Event event = new Event(getCurrentUser().getUsername(),
				type, userId, User.class);
		EventManager.getManager().broadcastEvent(event);
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void setSelectRoles(Integer[] selectRoles) {
		this.selectRoles = selectRoles;
	}

}
