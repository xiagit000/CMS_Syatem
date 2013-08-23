package com.boventech.cms.module.download;

import java.io.Serializable;

import com.boventech.cms.module.user.User;

public interface AttachAccessStrategy extends Serializable{
	
	boolean canBeAccessBy(User user);
	
	AccessStrategyTag getTag();
	
	AttachAccessStrategy copy();

}
