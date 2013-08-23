/*
 * Copyright 2009. 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of ELWG. 
 */
package com.boventech.cms.action.util;

import java.util.Map;

/**
 * flash类消息的存储上下文,用于在客户消费消息之前临时保存客户的消息,一旦客户消费其消息则从本上下文移除
 * 
 * @author xiedongming
 *
 */
public final class FlashMessageContext {
	
	private FlashMessageContext(){
		
	}
	
	private static Map<String, Map<String, Object>> messagesMap = new OneTimeConsumeHashMap<String, Map<String,
	Object>>();

	/**
	 * 为某个客户注册消息列表
	 * 
	 * @param sessionID 客户的sessionID
	 * @param messages 客户的消息列表
	 */
	public static void registerMessages(String sessionID,
			Map<String, Object> messages) {
		messagesMap.put(sessionID, messages);	
	}
	
	/**
	 * 获取某个客户的消息列表,且将其消息列表从上下文中移除
	 * 
	 * @param sessionID 客户的sessionID
	 * @return 客户的消息列表
	 */
	public static Map<String, Object> consumeMessages(String sessionID){
		return messagesMap.get(sessionID);
	}

}
