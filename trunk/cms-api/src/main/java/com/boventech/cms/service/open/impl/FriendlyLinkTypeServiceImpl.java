package com.boventech.cms.service.open.impl;

import org.springframework.stereotype.Service;

import com.boventech.cms.dao.open.FriendlyLinkTypeDao;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.service.impl.DataTypeServiceImpl;
import com.boventech.cms.service.open.FriendlyLinkTypeService;

@Service
public class FriendlyLinkTypeServiceImpl extends DataTypeServiceImpl<FriendlyLinkType> implements FriendlyLinkTypeService{

	public void setFriendlyLinkTypeDao(FriendlyLinkTypeDao friendlyLinkTypeDao) {
		this.initDataTypeDao(friendlyLinkTypeDao);
	}
}
