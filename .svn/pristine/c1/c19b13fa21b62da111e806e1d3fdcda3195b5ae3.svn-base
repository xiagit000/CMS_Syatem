package com.boventech.cms.action.admin.register;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.WebUtil;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.register.Register;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.register.RegisterService;

@Results( {
		@Result(name = "manage", location = "manage.jsp", type = "dispatcher"),
		@Result(name = "manage-delete", location = "/admin/register/manage", type = "redirect") })
public class ManageAction extends AdminAction {

	@Resource
	private RegisterService registerService;

	private List<Register> registers;

	@Override
	public HttpHeaders create() {
		return null;
	}

	@Override
	public String destroy() {
		Long id = Long.valueOf(getId());
		this.registerService.removeRegister(id);
		doBroadCast(EventType.DELETE_REGISTER, id);
		return "manage-delete";
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders editNew() {
		return new DefaultHttpHeaders(NEW).disableCaching();
	}

	@Override
	public HttpHeaders index() {
		PageIndex pageIndex = WebUtil.createPageIndex();
		List<Register> registers2 = this.registerService.list(pageIndex);
		setRegisters(registers2);
		return new DefaultHttpHeaders("manage").disableCaching();
	}
	
	/**
	 * broadcast register operation events.
	 * @param type		EventType
	 * @param registerId	the id of register
	 */
	private void doBroadCast(EventType type, Long registerId){
		Event event = new Event(getCurrentUser().getUsername(),
				type, registerId, Register.class);
		EventManager.getManager().broadcastEvent(event);
	}

	@Override
	public HttpHeaders show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	private static final long serialVersionUID = -6230994831564272677L;

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

}
