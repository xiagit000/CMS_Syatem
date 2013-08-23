/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.sacwh.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;

/**
 * 登陆控制器
 * @author liang.zhou
 */
@Results({ 
    @Result(name = "index", type = "dispatcher", location = "login.jsp"),
    @Result(name = "open", type = "redirect", location = "/open")
})
public class LoginAction extends OpenAction{

    private static final long serialVersionUID = 1L;

    public HttpHeaders index() { 
        String result = getCurrentUser() != null ? "open" : INDEX;
        return new DefaultHttpHeaders(result).disableCaching();
    }

}
