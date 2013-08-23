/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 22 $
 * $Author: zinan.liao $
 * $LastChangedDate: 2012-09-24 17:30:48 +0800 (一, 24  9 2012) $
 *
 */

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.DriftDao;
import com.boventech.sacwh.module.Drift;
import com.boventech.sacwh.service.DriftService;

@Service
@Transactional
public class DriftServiceImpl implements DriftService {

    private DriftDao driftDao;
    
    public void setDriftDao(DriftDao driftDao) {
        this.driftDao = driftDao;
    }

    public void save(Drift t) {
        this.driftDao.save(t);
    }

    public void delete(Drift t) {
        this.driftDao.delete(t);
    }

    public void update(Drift t) {
        this.driftDao.update(t);
    }

    public Drift findById(Integer id) {
        return this.driftDao.findById(id);
    }

    public List<Drift> listAll(PageIndex pageIndex) {
        return this.driftDao.list(pageIndex);
    }

    public Drift getOnIndex() {
        return this.driftDao.getOnIndex();
    }

    public void putOnIndex(Drift drift) {
        List<Drift> drifts = this.driftDao.list();
        for(Drift d : drifts){
            if(d.isOnIndex()){
                d.setOnIndex(false);
                this.driftDao.update(d);
            }
        }
        drift.setOnIndex(true);
        this.driftDao.update(drift);
    }
    
}
