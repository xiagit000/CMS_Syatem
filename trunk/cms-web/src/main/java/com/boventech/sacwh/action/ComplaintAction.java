/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 22 $
 * $Author: zinan.liao $
 * $LastChangedDate: 2012-09-24 17:30:48 +0800 (星期一, 24 九月 2012) $
 *
 */

package com.boventech.sacwh.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.sacwh.module.Complaint;
import com.boventech.sacwh.service.ComplaintService;

@Results({
    @Result(name = "new", type = "dispatcher", location = "sacwh/complaint/new.jsp"),
    @Result(name = "create", type = "redirect", location = "/open")
})
public class ComplaintAction extends OpenAction {

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
        return null;
    }

    @Override
    public HttpHeaders show() {
        return null;
    }

    @Override
    public HttpHeaders create() {
        this.complaintService.save(this.complaint);
        return new DefaultHttpHeaders(CREATE).disableCaching();
    }

    @Override
    public HttpHeaders editNew() {
        return new DefaultHttpHeaders(NEW).disableCaching();
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
