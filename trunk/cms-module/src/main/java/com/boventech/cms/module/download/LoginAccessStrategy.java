package com.boventech.cms.module.download;

import javax.persistence.Entity;

import com.boventech.cms.module.user.User;

@Entity
public class LoginAccessStrategy extends AbstractAccessStrategy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1794619601355908808L;

	public LoginAccessStrategy(){
		this.setTag(AccessStrategyTag.LOGINACESS);
	}
	
	public boolean canBeAccessBy(User user) {
		return user != null;
	}

	public AttachAccessStrategy copy() {
		return new LoginAccessStrategy();
	}
	
}
