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

package com.boventech.sacwh.service;

import java.util.List;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;
import com.boventech.sacwh.module.Drift;

public interface DriftService extends BasicService<Drift>{

    List<Drift> listAll(PageIndex pageIndex);
    
    Drift getOnIndex();
    
    void putOnIndex(Drift drift);
}
