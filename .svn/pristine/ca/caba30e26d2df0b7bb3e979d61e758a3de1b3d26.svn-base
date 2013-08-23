package com.boventech.cms.module.download;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.boventech.cms.module.right.Role;
import com.boventech.cms.module.user.User;

@Entity
public class RoleBasedAccessStrategy extends AbstractAccessStrategy{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3350765706632419714L;
	@OneToOne(fetch=FetchType.LAZY)
	private Role role;
	
	public RoleBasedAccessStrategy(){
		this.setTag(AccessStrategyTag.ROLEBASED);
	}
	
	public RoleBasedAccessStrategy(Role role){
		this.setTag(AccessStrategyTag.ROLEBASED);
		this.role = role;
	}

	public boolean canBeAccessBy(User user) {
		return user != null && user.hasRole(this.role);
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	
	public AttachAccessStrategy copy() {
		return new RoleBasedAccessStrategy(this.role);
	}
	
}
