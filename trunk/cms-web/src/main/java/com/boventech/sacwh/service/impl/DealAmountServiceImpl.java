/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 227 $
 * $Author: peng.xia $
 * $LastChangedDate: 2012-12-17 09:17:39 +0800 (星期一, 17 十二月 2012) $
 *
 */

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.DealAmountDao;
import com.boventech.sacwh.module.DealAmount;
import com.boventech.sacwh.service.DealAmountService;

@Service
@Transactional
public class DealAmountServiceImpl implements DealAmountService {

    private DealAmountDao DealAmountDao;
    
    public void setDealAmountDao(DealAmountDao dealAmountDao) {
        DealAmountDao = dealAmountDao;
    }

    public void save(DealAmount t) {
        this.DealAmountDao.save(t);
    }

    public void delete(DealAmount t) {
        this.DealAmountDao.delete(t);
    }

    public void update(DealAmount t) {
        this.DealAmountDao.update(t);
    }

    public DealAmount findById(Integer id) {
        return this.DealAmountDao.findById(id);
    }

    public List<DealAmount> listAll(PageIndex pageIndex) {
        return this.DealAmountDao.listAllOrderbyOrder(pageIndex);
    }

    public DealAmount findLatest() {
        return this.DealAmountDao.findLatest();
    }

    public List<DealAmount> listAll() {
        return this.DealAmountDao.listAll();
    }

    /* (non-Javadoc)
     * @see com.boventech.sacwh.service.DealAmountService#deleteAll(java.util.List)
     */
    public void deleteAll(List<DealAmount> list) {
        // TODO Auto-generated method stub
        this.DealAmountDao.deleteAll(list);
    }

    /* (non-Javadoc)
     * @see com.boventech.sacwh.service.DealAmountService#search(com.boventech.sacwh.module.DealAmount)
     */
    public List<DealAmount> search(PageIndex pageIndex,DealAmount dealAmount) {
        // TODO Auto-generated method stub
        return this.DealAmountDao.search(pageIndex,dealAmount);
    }
    
}
