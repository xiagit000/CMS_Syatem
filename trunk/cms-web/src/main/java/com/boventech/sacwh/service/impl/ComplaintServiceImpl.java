/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 18 $
 * $Author: zinan.liao $
 * $LastChangedDate: 2012-09-24 09:39:10 +0800 (星期一, 24 九月 2012) $
 *
 */

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.ComplaintDao;
import com.boventech.sacwh.module.Complaint;
import com.boventech.sacwh.service.ComplaintService;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintDao complaintDao;
    
    public void setComplaintDao(ComplaintDao complaintDao) {
        this.complaintDao = complaintDao;
    }

    public void save(Complaint t) {
        this.complaintDao.save(t);
    }

    public void delete(Complaint t) {
        this.complaintDao.delete(t);
    }

    public void update(Complaint t) {
        this.complaintDao.update(t);
    }

    public Complaint findById(Integer id) {
        return this.complaintDao.findById(id);
    }

    public List<Complaint> listAll(PageIndex pageIndex) {
        return this.complaintDao.list(pageIndex);
    }
    
}
