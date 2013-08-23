/*
 * Copyright 2009. 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of ELWG. 
 */
package com.boventech.cms.action.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 模拟一次性消费的HashMap实现,并保证了线程安全.
 * 
 * @author xiedongming
 *
 * @param <K> key
 * @param <V> value
 */
public class OneTimeConsumeHashMap<K, V> extends ConcurrentHashMap<K, V> {

	private static final long serialVersionUID = 6678133155520052804L;

	/**
	 * 返回本HashMap中符合指定key的值,同时将此key-value移除
	 */
	@Override
	public V get(Object key) {
		return remove(key);
	}
	
}
