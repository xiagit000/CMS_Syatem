package com.boventech.cms.action.user;

import java.io.File;
import java.util.Random;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;
import com.boventech.cms.action.util.TemplateUtil;
import com.boventech.cms.module.email.EmailTemplate;
import com.boventech.cms.module.user.User;
import com.boventech.util.file.Md5Util;

public class FindPasswordAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1613086003708814279L;
	
	private String username;
	
	private String email;
	
	private static final int RECOVER_PASSWORD_RANK = 99999999;

	private static final File FIND_PASS_TEMPLATE_FILE;
	
	static{
		FIND_PASS_TEMPLATE_FILE = new File(Thread.currentThread().getContextClassLoader()
				.getResource("findPasswordTemplate.html").getPath());
	}
	
	public String getEmailLink(){
		if(this.email != null && this.email.contains("@")){
			int pos = this.email.lastIndexOf("@");
			return "http://www." + this.email.substring(pos + 1);
		}
		return null;
	}
	
	@Override
	public HttpHeaders create() {
		User user = checkUser();
		String result = "error";
		if(user != null){
			Random random = new Random();
			String password = String.valueOf(random.nextInt(RECOVER_PASSWORD_RANK));
			user.setPassword(Md5Util.encodeByMd5(password));
			EmailTemplate template = TemplateUtil.newTemplate(FIND_PASS_TEMPLATE_FILE,
					new String[]{user.getUsername()}, new String[]{user.getUsername(),password});
			this.getUserService().findPasswordBack(user,template);
			result = "back";
		}
		return new DefaultHttpHeaders(result).disableCaching();
	}

	private User checkUser() {
		if(this.username != null && this.email != null){
			User user = this.getUserService().getByName(this.username);
			return user != null && this.email.equals(user.getEmail()) ? user : null;
		}
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
