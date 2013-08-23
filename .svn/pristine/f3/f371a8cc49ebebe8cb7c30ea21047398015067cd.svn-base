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

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.VoteDao;
import com.boventech.sacwh.module.Vote;
import com.boventech.sacwh.service.VoteService;

@Service
@Transactional
public class VoteServiceImpl implements VoteService{
    
    private VoteDao voteDao;

    public void save(Vote t) {
        voteDao.save(t);
    }

    public void delete(Vote t) {
        voteDao.delete(t);
    }

    public void update(Vote t) {
        voteDao.update(t);
    }

    public Vote findById(Integer id) {
        return voteDao.findById(id);
    }

    public List<Vote> listAll(PageIndex pageIndex) {
        return this.voteDao.list(pageIndex);
    }

    public VoteDao getVoteDao() {
        return voteDao;
    }

    public void setVoteDao(VoteDao voteDao) {
        this.voteDao = voteDao;
    }

    public Vote findByCreateTimeDesc() {
        return voteDao.findByCreateTimeDesc();
    }

}
