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

package com.boventech.sacwh.dao;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.sacwh.module.Vote;

public interface VoteDao extends AbstractDao<Vote, Integer>{
    
    /**
     * 列出最新的一个投票
     * @return
     */
    Vote findByCreateTimeDesc();

}
