package com.boventech.cms.action.user;

import java.io.File;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;
import com.boventech.cms.action.util.SessionParameters;
import com.boventech.cms.action.util.TemplateUtil;
import com.boventech.cms.module.email.EmailTemplate;
import com.boventech.cms.module.user.User;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.file.Md5Util;
import com.boventech.util.user.UserRight;

@Results({
    @Result(name = "errorCode", type = "redirect", location = "/user/register/error"),
    @Result(name = "registerPass", type = "redirect", location = "/user/register/pass")
})
public class RegisterAction extends AbstractAction{

    private static final String NOT = "N";

	private static final String YES = "Y";

	/**
     * 
     */
    private static final long serialVersionUID = -1661966259021590805L;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private String verifyCode;
    
    private String message;
    
    private static final File REG_TEMPLATE_FILE;
    
    static{
    	REG_TEMPLATE_FILE = new File(Thread.currentThread().getContextClassLoader()
    		.getResource("registerTemplate.html").getPath());
    }
    
    @Override
    public HttpHeaders create() {
    	if(this.verifyCode == null || !this.verifyCode.equals(ActionUtil
                        .getSession(SessionParameters.VERIFYCODE))){
    		this.message = "errorCode";
    	}else{
    		User user = new User();
    		user.setUsername(username);
    		user.setPassword(Md5Util.encodeByMd5(password));
    		user.setEmail(email);
    		user.setUserRight(UserRight.NORMAL);
    		user.setActivated(true);
    		EmailTemplate template = TemplateUtil.newTemplate(REG_TEMPLATE_FILE
    				, new String[]{username}, new String[]{username});
    		this.getUserService().registerSuccess(user,template);
    		this.message = "registerPass";
    	}
        return new DefaultHttpHeaders(this.message).disableCaching();
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
        return new DefaultHttpHeaders(getId()).disableCaching();
    }

    @Override
    public String update() {
        return null;
    }
    
    public void checkName() {
        String name = ActionUtil.getRequestParameter("name");
        User current = this.getUserService().getByName(name);
        String result = (current == null) ? YES : NOT;
        ActionUtil.writeResponse(result);
    }
    
    public void checkEmail() {
        String checkedEmail = ActionUtil.getRequestParameter("email");
        User current = this.getUserService().getByEmail(checkedEmail);
        String result = (current == null) ? YES : NOT;
        ActionUtil.writeResponse(result);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getMessage() {
		return message;
	}

}
