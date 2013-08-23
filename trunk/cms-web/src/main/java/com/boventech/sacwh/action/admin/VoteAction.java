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

package com.boventech.sacwh.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.sacwh.module.Ticket;
import com.boventech.sacwh.module.Vote;
import com.boventech.sacwh.service.TicketService;
import com.boventech.sacwh.service.VoteService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireLogin;
import com.boventech.web.annotation.RequireRight;

@Results({
    @Result(name = "new", type = "dispatcher", location = "vote/new.jsp"),
    @Result(name = "edit", type = "dispatcher", location = "vote/edit.jsp"),
    @Result(name = "ticketNew", type = "dispatcher", location = "vote/ticketNew.jsp"),
    @Result(name = "list", type = "redirect", location = "/admin/vote"),
    @Result(name = "show", type = "dispatcher", location = "vote/show.jsp"),
    @Result(name = "create", type = "redirect", location = "/admin/vote")
})
@RequireLogin
@RequireRight(right = UserRight.ADMIN)
public class VoteAction extends AdminAction{

    /**
     * 投票管理
     */
    private static final long serialVersionUID = -1514467239301409747L;
    
    private Vote vote;
    
    private List<Vote> votes;
    
    private VoteService voteService;
    
    private Ticket ticket;
    
    private List<Ticket> tickets;
    
    private TicketService ticketService;
    
    private boolean sizeLimit;

    @Override
    public HttpHeaders index() {
        this.votes = this.voteService.listAll(getPageIndex());
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        this.vote = this.voteService.findById(getIntegerId());
        int voteId = this.vote.getId();
        this.tickets = this.ticketService.listByVoteAndCreateTimeDesc(voteId, getPageIndex());
        if(this.tickets != null){
            //判断投票项数量是否大于3个
            if(this.tickets.size() > 3){
                this.sizeLimit = true;
            }  
        }
        this.tickets = this.ticketService.listByVote(voteId, getPageIndex());
        return new DefaultHttpHeaders(SHOW).disableCaching();
    }

    @Override
    public HttpHeaders create() {
        this.voteService.save(vote);
        return new DefaultHttpHeaders(CREATE).disableCaching();
    }

    @Override
    public HttpHeaders editNew() {
        return new DefaultHttpHeaders(NEW).disableCaching();
    }

    @Override
    public String update() {
        Vote oldVote = this.voteService.findById(getIntegerId());
        oldVote.setTitle(this.vote.getTitle());
        oldVote.setContent(this.vote.getContent());
        this.voteService.update(oldVote);
        return LIST;
    }

    @Override
    public String edit() {
        this.vote = this.voteService.findById(getIntegerId());
        return EDIT;
    }
    
    /**
     * 增加投票项
     * @return
     */
    public DefaultHttpHeaders ticketNew() {
        this.vote = this.voteService.findById(getIntegerId());
        this.tickets = this.ticketService.listByVoteAndCreateTimeDesc(this.vote.getId(), getPageIndex());
        return new DefaultHttpHeaders("ticketNew").disableCaching();
    }

    @Override
    public String destroy() {
        return null;
    }
    
    public String delete() {
        Vote vote = this.voteService.findById(getIntegerId());
        this.voteService.delete(vote);
        return redirect();
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public VoteService getVoteService() {
        return voteService;
    }

    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public boolean isSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(boolean sizeLimit) {
        this.sizeLimit = sizeLimit;
    }
   
}
