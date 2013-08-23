package com.boventech.cms.action.user;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.user.User;
import com.boventech.util.action.ActionUtil;

@Result(name = "logout", type = "redirect", location = "/open")
public class LogoutAction extends AbstractAction{

    /**
     * 
     */
    private static final long serialVersionUID = 987142135094269513L;
    
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
    	User user = getCurrentUser();
    	if(user != null){
    		ActionUtil.removeUserId();
    		ActionUtil.removeCurrentUserRight();
    		/*if(this.getContinueURL() == null){
	        	redirect();
	        	return null;
        	}*/
    		doBroadCast(EventType.USER_LOGOUT, user.getUsername());
    	}
        return new DefaultHttpHeaders("logout").disableCaching();
    }
    
    /**
	 * broadcast user operation events.
	 * @param type		EventType
	 * @param username	the username of user
	 */
	private void doBroadCast(EventType type, String username){
		Event event = new Event(username,
				type, username, User.class);
		EventManager.getManager().broadcastEvent(event);
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
