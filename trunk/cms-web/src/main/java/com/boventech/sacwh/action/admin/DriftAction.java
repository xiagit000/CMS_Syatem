/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 27 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-09-25 14:12:50 +0800 (二, 25  9 2012) $
 *
 */

package com.boventech.sacwh.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.sacwh.module.Drift;
import com.boventech.sacwh.service.DriftService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireLogin;
import com.boventech.web.annotation.RequireRight;

@Results({
    @Result(name = "new", type = "dispatcher", location = "drift/new.jsp"),
    @Result(name = "edit", type = "dispatcher", location = "drift/edit.jsp"),
    @Result(name = "list", type = "redirect", location = "/admin/drift"),
    @Result(name = "create", type = "redirect", location = "/admin/drift")
})
@RequireLogin
@RequireRight(right = UserRight.ADMIN)
public class DriftAction extends AdminAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Drift drift;

    private DriftService driftService ;
    
    private List<Drift> drifts;
    
    public Drift getDrift() {
        return drift;
    }

    public void setDrift(Drift drift) {
        this.drift = drift;
    }

    public List<Drift> getDrifts() {
        return drifts;
    }

    public void setDrifts(List<Drift> drifts) {
        this.drifts = drifts;
    }

    public void setDriftService(DriftService driftService) {
        this.driftService = driftService;
    }

    @Override
    public HttpHeaders index() {
        this.drifts = this.driftService.listAll(getPageIndex());
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        this.drift = this.driftService.findById(getIntegerId());
        return new DefaultHttpHeaders(SHOW).disableCaching();
    }

    @Override
    public HttpHeaders create() {
        this.driftService.save(drift);
        return new DefaultHttpHeaders(CREATE).disableCaching();
    }

    @Override
    public HttpHeaders editNew() {
        return new DefaultHttpHeaders(NEW).disableCaching();
    }

    @Override
    public String update() {
        Drift oldDrift = this.driftService.findById(getIntegerId());
        oldDrift.setTitle(this.drift.getTitle());
        oldDrift.setContent(this.drift.getContent());
        this.driftService.update(oldDrift);
        return LIST;
    }

    @Override
    public String edit() {
        this.drift = this.driftService.findById(getIntegerId());
        return EDIT;
    }

    @Override
    public String destroy() {
        // TODO Auto-generated method stub
        return null;
    }

    public String delete() {
        Drift drift = this.driftService.findById(getIntegerId());
        this.driftService.delete(drift);
        return redirect();
    }
    
    public String onIndex(){
        Drift drift = this.driftService.findById(getIntegerId());
        this.driftService.putOnIndex(drift);
        return redirect();
    }
    
    
}
