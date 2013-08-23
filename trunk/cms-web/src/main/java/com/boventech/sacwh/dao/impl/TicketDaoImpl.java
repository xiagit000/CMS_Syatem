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
import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.TicketDao;
import com.boventech.sacwh.module.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDaoImpl<Ticket, Integer> implements TicketDao{

    private static final long serialVersionUID = 1415143383552541188L;

    @SuppressWarnings("unchecked")
    public List<Ticket> listByVote(int voteId, PageIndex pageIndex) {
        return (List<Ticket>) executeListWithPaging("from Ticket where vote.id = ?",pageIndex, voteId);
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> listByVoteAndCreateTimeDesc(Integer id, PageIndex pageIndex) {
        List<Ticket> tickets = (List<Ticket>) executeListWithPaging("from Ticket where vote.id = ? And other is false order by createTime", pageIndex, id);
        return tickets.isEmpty() ? null : tickets;
    }

    @SuppressWarnings("unchecked")
    public Ticket findByTitle(String title, int voteId) {
        PageIndex pageIndex = new PageIndex();
        List<Ticket> tickets = (List<Ticket>) executeListWithPaging("from Ticket where vote.id = ? AND title=?", pageIndex, voteId,title);
        return tickets.isEmpty() ? null : tickets.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> listByVoteOrderByCount(int voteId, PageIndex pageIndex) {
        List<Ticket> tickets = (List<Ticket>) executeListWithPaging("from Ticket where vote.id = ? order by voteCount Desc", pageIndex, voteId);
        return tickets.isEmpty() ? null : tickets;
    }

}
