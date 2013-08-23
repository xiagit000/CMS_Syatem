/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 25 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-09-25 11:11:05 +0800 (星期二, 25 九月 2012) $
 *
 */

package com.boventech.sacwh.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.sacwh.module.Complaint;
import com.boventech.sacwh.service.ComplaintService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireLogin;
import com.boventech.web.annotation.RequireRight;

@Results({
    @Result(name = "show", type = "dispatcher", location = "complaint/show.jsp"),
})
@RequireLogin
@RequireRight(right = UserRight.ADMIN)
public class ComplaintAction extends AdminAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Complaint complaint;

    private ComplaintService complaintService;
    
    private List<Complaint> complaints;
    
    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public void setComplaintService(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    @Override
    public HttpHeaders index() {
        this.complaints = this.complaintService.listAll(getPageIndex());
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        this.complaint = this.complaintService.findById(getIntegerId());
        return new DefaultHttpHeaders(SHOW).disableCaching();
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
    
    public String delete() {
        Complaint complaint = this.complaintService.findById(getIntegerId());
        this.complaintService.delete(complaint);
        return redirect();
    }

}
