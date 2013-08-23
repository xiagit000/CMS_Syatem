package com.boventech.cms.action.admin.my;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.user.User;
import com.boventech.util.file.Md5Util;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireRight;

@RequireRight(right = UserRight.NORMAL)
public class PasswordAction extends AdminAction{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7919729485504148603L;

	private String password;

	private String newRepeartPassword;
	
	private String newPassword;

	@Override
	public HttpHeaders create() {
		User current = getCurrentUser();
        if (current.getPassword().equals(Md5Util.encodeByMd5(this.password))&&
                this.newPassword.equals(this.newRepeartPassword)) {
            current.setPassword(Md5Util.encodeByMd5(this.newPassword));
            this.getUserService().update(current);
            addFlashMessage(getText(FlashMessageConstants.UPDATE_PASSWORD_SUCCESS));
            doBroadCast(EventType.CHANGE_PASSWORD, current.getId());
        }else{
        	addFlashMessage(getText(FlashMessageConstants.ERROR_PASSWORD));
        }
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewRepeartPassword(String newRepeartPassword) {
		this.newRepeartPassword = newRepeartPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
