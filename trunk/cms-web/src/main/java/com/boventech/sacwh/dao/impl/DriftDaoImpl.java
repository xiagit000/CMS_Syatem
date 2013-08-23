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

package com.boventech.sacwh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.sacwh.dao.DriftDao;
import com.boventech.sacwh.module.Drift;

@Repository
public class DriftDaoImpl extends AbstractDaoImpl<Drift, Integer> implements DriftDao {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    public Drift getOnIndex() {
        List<Drift> drifts = (List<Drift>) this.executeListWithPaging("from Drift where onIndex = ?", null, true);
        return drifts.isEmpty() ? null : drifts.get(0);
    }

}
