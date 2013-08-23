package com.boventech.cms.module.download;

import com.boventech.cms.module.right.Role;

/**
 * enumn for attachment access strategy
 * @author junxue.rao
 *
 */
public enum AccessStrategyTag {

	PUBLICACESS {
		@Override
		public AttachAccessStrategy newInstant(Object... params) {
			return new PublicAccessStrategy();
		}
	},
	
	LOGINACESS {
		@Override
		public AttachAccessStrategy newInstant(Object...params) {
			return new LoginAccessStrategy();
		}
	},
	
	ROLEBASED {
		@Override
		public AttachAccessStrategy newInstant(Object... params) {
			if(params != null && params.length > 0 && params[0] != null && params[0] instanceof Role)
				return new RoleBasedAccessStrategy((Role) params[0]);
			return null;
		}
	};
	
	public abstract AttachAccessStrategy newInstant(Object... params);
	
	public String getValue(){
		return this.toString();
	}
}
