package com.boventech.cms.module.open;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.boventech.cms.module.DataType;

@Entity
@DiscriminatorValue("FRIENDLINKTYPE")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FriendlyLinkType extends DataType{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2879422651128539334L;

}
