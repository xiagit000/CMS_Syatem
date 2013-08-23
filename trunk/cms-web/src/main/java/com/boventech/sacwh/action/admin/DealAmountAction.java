/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 234 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-12-18 11:23:59 +0800 (周二, 18 十二月 2012) $
 *
 */

package com.boventech.sacwh.action.admin;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.boventech.cms.action.AdminAction;
import com.boventech.sacwh.module.DealAmount;
import com.boventech.sacwh.service.DealAmountService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireLogin;
import com.boventech.web.annotation.RequireRight;

@Results({ @Result(name = "new", type = "dispatcher", location = "deal-amount/new.jsp"),
        @Result(name = "edit", type = "dispatcher", location = "deal-amount/edit.jsp"),

        @Result(name = "list", type = "redirect", location = "/admin/deal-amount"),
        @Result(name = "create", type = "redirect", location = "/admin/deal-amount") })
@RequireLogin
@RequireRight(right = UserRight.ADMIN)
public class DealAmountAction extends AdminAction {

    /**
     * 交易量管理
     */
    private static final long serialVersionUID = 1L;

    private DealAmount dealAmount;

    private DealAmountService dealAmountService;

    private List<DealAmount> dealAmounts;

    // 接受页面传递多个id值的int类型数组
    private int[] chk_list;

    public int[] getChk_list() {
        return chk_list;
    }

    public void setChk_list(int[] chk_list) {
        this.chk_list = chk_list;
    }

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
        this.dealAmounts = this.dealAmountService.listAll(getPageIndex());
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        this.dealAmount = this.dealAmountService.findById(getIntegerId());
        return new DefaultHttpHeaders(SHOW).disableCaching();
    }

    @Override
    public HttpHeaders create() {
        this.dealAmountService.save(dealAmount);
        return new DefaultHttpHeaders(CREATE).disableCaching();
    }

    @Override
    public HttpHeaders editNew() {
        return new DefaultHttpHeaders(NEW).disableCaching();
    }

    @Override
    public String edit() {
        this.dealAmount = this.dealAmountService.findById(getIntegerId());
        return EDIT;
    }

    @Override
    public String update() {
        DealAmount oldDealAmount = this.dealAmountService.findById(getIntegerId());
        oldDealAmount.setCompany(this.dealAmount.getCompany());
        oldDealAmount.setPercent(this.dealAmount.getPercent());
        oldDealAmount.setTotalAmount(this.dealAmount.getTotalAmount());
        oldDealAmount.setOrderBy(this.dealAmount.getOrderBy());
        oldDealAmount.setDealTime(this.dealAmount.getDealTime());
        this.dealAmountService.update(oldDealAmount);
        return LIST;
    }

    @Override
    public String destroy() {
        // TODO Auto-generated method stub
        return null;
    }

    public String delete() {
        DealAmount dealAmount = this.dealAmountService.findById(getIntegerId());
        this.dealAmountService.delete(dealAmount);
        return redirectForDelete();
    }

    // 批量删除方法
    public String multiDelete() {
        this.dealAmountService.deleteAll(getDealAmountList());
        return redirectForDelete();
    }

    // 根据删除方法传回的参数判断跳转页面
    private String redirectForDelete() {
        String previousUrl = getPreviousUrl();
        if (getPreviousUrl().contains("page")) {
            String replaceString = getPreviousUrl().substring(getPreviousUrl().indexOf("page"));
            previousUrl = getPreviousUrl().replace(replaceString, "page=");
        }
        boolean isLastRecord = getPageIndex().getCurrentPage() != 1;
        return isLastRecord ? redirectTo(previousUrl + (getPageIndex().getCurrentPage() - 1)) : redirect();
    }

    // 把id赋值给实体类，并将实体类加入list集合
    private List<DealAmount> getDealAmountList() {
        List<DealAmount> list = new ArrayList<DealAmount>();
        for (int i = 0; i < chk_list.length; i++) {
            DealAmount dealAmount = this.dealAmountService.findById(chk_list[i]);
            list.add(dealAmount);
        }
        return list;
    }

    public HttpHeaders search() {
        this.dealAmounts = this.dealAmountService.search(getPageIndex(), dealAmount);
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }
}
