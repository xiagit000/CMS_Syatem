package com.boventech.cms.action.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.right.Operation;
import com.boventech.cms.module.right.Privilege;
import com.boventech.cms.module.right.Role;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.node.NodeService;
import com.boventech.cms.service.right.RoleService;
import com.boventech.util.math.Util;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.Before;

@Results({
	@Result(name = "list", type = "redirect", location = "/admin/role")
})

public class RoleAction extends AdminAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142399316111847542L;
	
	private List<Role> roles;
	
	private RoleService roleService;
	
	private NodeService nodeService;
	
	private String name;

	private Role role;
	
	private String[] privilege = {};
	
	private Integer parentId = null;
	
	private Integer grandParentId = null;
	
	public List<Operation> getOpts(){
		return Arrays.asList(Operation.values());
	}
	
	public List<Menu> getMenus(){
		return this.nodeService.listMenu(false, this.parentId);
	}
	
	@Before(include = {"create", "destroy", "update", "index", "edit", "editNew"})
	public void prepare(){
		User user = getCurrentUser();
		if(!user.getUserRight().equals(UserRight.SUPERADMIN)){
			addFlashMessage(getText(FlashMessageConstants.NO_RIGHT_OPERATION));
			redirectTo("/noRight");
			return;
		}
	}

	@Override
	public HttpHeaders create() {
		Role role = new Role();
		role.setName(this.name);
		List<Privilege> privileges = collectPrivileges();
		role.setPrivileges(privileges);
		this.roleService.save(role);
		doBroadCast(EventType.ADD_ROLE, role.getId());
		return new DefaultHttpHeaders(LIST).disableCaching();
	}

	private List<Privilege> collectPrivileges() {
		List<Privilege> privileges = new ArrayList<Privilege>(privilege.length);
		for(String p:this.privilege){
			String[] ids = p.split("-");
			Integer nodeId = null;
			if(ids[0] != null && Util.isNumeric(ids[0]))
				nodeId = Integer.valueOf(ids[0]);
			Node node = this.nodeService.findById(nodeId);
			Operation opt = Operation.valueOf(ids[1]);
			if(node != null && opt != null){
				Privilege plg = new Privilege(node, opt);
				plg.setName(node.getName() + ":" + opt.getName());
				privileges.add(plg);
			}
		}
		return privileges;
	}

	@Override
	public String destroy() {
		this.roleService.delete(getIntegerId());
		doBroadCast(EventType.DELETE_ROLE, getIntegerId());
		redirect();
		return null;
	}

	@Override
	public String edit() {
		this.role = this.roleService.findById(getIntegerId());
		this.grandParentId = initGrandParentId();
		return EDIT;
	}

	@Override
	public HttpHeaders editNew() {
		return new DefaultHttpHeaders(NEW).disableCaching();
	}

	@Override
	public HttpHeaders index() {
		this.roles = this.roleService.list();
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		this.role = this.roleService.findById(getIntegerId());
		this.role.setName(this.name);
		this.role.replacePrivileges(collectPrivileges());
		this.roleService.update(role);
		addFlashMessage(getText(FlashMessageConstants.UPDATE_SUCCESS));
		doBroadCast(EventType.UPDATE_ROLE, role.getId());
		redirect();
		return null;
	}
	
	public Integer getGrandParentId() {
		return grandParentId;
	}
	
	public Integer initGrandParentId(){
		if(this.parentId != null){
			Node node = this.nodeService.findById(this.parentId);
			if(node != null && node.getParent() != null)
				return node.getParent().getId();
		}
		return null;
	}
	
	/**
	 * broadcast role operation events.
	 * @param type		EventType
	 * @param roleId	the id of role
	 */
	private void doBroadCast(EventType type, Integer roleId){
		Event event = new Event(getCurrentUser().getUsername(),
				type, roleId, Role.class);
		EventManager.getManager().broadcastEvent(event);
	}
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}
	
	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}
	
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
}
