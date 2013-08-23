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

package com.boventech.sacwh.service;

import java.util.List;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;
import com.boventech.sacwh.module.DealAmount;

public interface DealAmountService extends BasicService<DealAmount>{

    List<DealAmount> listAll(PageIndex pageIndex);

    /**
     * 查找最新的一条记录
     * @return
     */
    DealAmount findLatest();

    List<DealAmount> listAll();
    
    List<DealAmount> search(PageIndex pageIndex,DealAmount dealAmount);

    void deleteAll(List<DealAmount> list);
}
