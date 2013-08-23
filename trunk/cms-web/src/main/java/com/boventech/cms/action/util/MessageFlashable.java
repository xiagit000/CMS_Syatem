/*
 * Copyright 2009. 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of ELWG. 
 */
package com.boventech.cms.action.util;

import java.util.Map;

/**
 * 进行消息flash的接口.flash一般为操作之后的提示消息,可被一次性消费.
 * 
 * @author xiedongming
 *
 */
public interface MessageFlashable {
	
	/**
	 * 获取本次action调用之后需要保存的flash消息
	 * @return
	 */
	Map<String, Object> messagesToStore();
	
	/**
	 * 在本次方法调用之前需要重新恢复的flash消息,通常是由上一次操作产生的;此消息由容器负责传递给当前action
	 * @param messages
	 */
	void restoreMessages(Map<String, Object> messages);

}
