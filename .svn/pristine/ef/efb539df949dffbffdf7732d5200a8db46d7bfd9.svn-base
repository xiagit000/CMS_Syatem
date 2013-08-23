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

package com.boventech.sacwh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.sacwh.dao.VoteDao;
import com.boventech.sacwh.module.Vote;

@Repository
public class VoteDaoImpl extends AbstractDaoImpl<Vote, Integer> implements VoteDao {

    /**
     * 
     */
    private static final long serialVersionUID = -819756240566868989L;

    @SuppressWarnings("unchecked")
    public Vote findByCreateTimeDesc() {
        List<Vote> votes = (List<Vote>) executeListWithPaging("from Vote order by createTime Desc", null);
        return votes.isEmpty() ? null : votes.get(0);
    }

}
