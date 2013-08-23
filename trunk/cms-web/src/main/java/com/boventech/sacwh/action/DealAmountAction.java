/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 174 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-11-15 10:22:02 +0800 (星期四, 15 十一月 2012) $
 *
 */

package com.boventech.sacwh.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.sacwh.module.DealAmount;
import com.boventech.sacwh.service.DealAmountService;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.user.UserRight;

@Results({
    @Result(name = "index", type = "dispatcher", location = "sacwh/dataCenter/index.jsp"),
    @Result(name = "login", type = "redirect", location = "/open/login")
})
public class DealAmountAction extends OpenAction {

    /**
     * 交易量管理
     */
    private static final long serialVersionUID = 1L;

    private DealAmount dealAmount;

    private DealAmountService dealAmountService;
    
    private List<DealAmount> dealAmounts;
    
    public DealAmount getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(DealAmount dealAmount) {
        this.dealAmount = dealAmount;
    }

    public List<DealAmount> getDealAmounts() {
        return dealAmounts;
    }

    public void setDealAmounts(List<DealAmount> dealAmounts) {
        this.dealAmounts = dealAmounts;
    }

    public void setDealAmountService(DealAmountService dealAmountService) {
        this.dealAmountService = dealAmountService;
    }

    @Override
    public HttpHeaders index() {
        UserRight userRight = (UserRight) ActionUtil.getSession("right");
        if(userRight != null){
            if(userRight.getRight() >= UserRight.ADMIN.getRight()){
                this.dealAmounts = this.dealAmountService.listAll(getPageIndex());
                return new DefaultHttpHeaders(INDEX).disableCaching(); 
            }
        }
        return new DefaultHttpHeaders("login").disableCaching(); 
    }

    @Override
    public HttpHeaders show() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HttpHeaders create() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HttpHeaders editNew() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String edit() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String destroy() {
        // TODO Auto-generated method stub
        return null;
    }

    

}
