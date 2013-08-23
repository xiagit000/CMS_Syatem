package com.boventech.cms.module.download;

import javax.persistence.Entity;

import com.boventech.cms.module.user.User;

@Entity
public class PublicAccessStrategy extends AbstractAccessStrategy{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6199548000626684514L;

	public  PublicAccessStrategy(){
		this.setTag(AccessStrategyTag.PUBLICACESS);
	}
	
	public boolean canBeAccessBy(User user) {
		return true;
	}
	
	public AttachAccessStrategy copy() {
		return new PublicAccessStrategy();
	}

}
