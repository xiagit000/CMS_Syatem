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
import com.boventech.sacwh.dao.TicketDao;
import com.boventech.sacwh.module.Ticket;
import com.boventech.sacwh.service.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{
    
    private TicketDao ticketDao;

    public void save(Ticket t) {
        ticketDao.save(t);
    }

    public void delete(Ticket t) {
        ticketDao.delete(t);
    }

    public void update(Ticket t) {
        ticketDao.update(t);
    }

    public Ticket findById(Integer id) {
        return ticketDao.findById(id);
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public List<Ticket> listByVote(int voteId, PageIndex pageIndex) {
        return ticketDao.listByVote(voteId, pageIndex);
    }

    public List<Ticket> listByVoteAndCreateTimeDesc(Integer id, PageIndex pageIndex) {
        return ticketDao.listByVoteAndCreateTimeDesc(id, pageIndex);
    }

    public Ticket findByTitle(String title, int voteId) {
        return ticketDao.findByTitle(title, voteId);
    }

    public List<Ticket> listByVoteOrderByCount(int voteId, PageIndex pageIndex) {
        return ticketDao.listByVoteOrderByCount(voteId, pageIndex);
    }

}
