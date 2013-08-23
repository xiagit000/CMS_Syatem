/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.sacwh.service;

import java.util.List;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;
import com.boventech.sacwh.module.Vote;

public interface VoteService extends BasicService<Vote>{
    
    List<Vote> listAll(PageIndex pageIndex);

    /**
     * 列出最新的一个投票
     * @return
     */
    Vote findByCreateTimeDesc();

}
