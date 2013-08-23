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

/**
 * 投票项
 * @author liang.zhou
 */
@Results({
    @Result(name="create",type = "redirect",location = "/admin/vote/${voteId}/show"),
    @Result(name="cancelOhter",type = "redirect",location = "/admin/vote/${voteId}/show"),
    @Result(name="otherSet", type = "redirect", location = "/admin/vote/${voteId}/show")
})
@RequireLogin
@RequireRight(right = UserRight.ADMIN)
public class TicketAction extends AdminAction{

    private static final long serialVersionUID = 180504864444710977L;
    
    private Ticket ticket;
    
    private List<Ticket> tickets;
    
    private int voteId;
    
    private VoteService voteService;
    
    private TicketService ticketService;

    @Override
    public HttpHeaders index() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HttpHeaders show() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HttpHeaders create() {
        Vote vote = this.voteService.findById(voteId);
        this.tickets = this.ticketService.listByVoteAndCreateTimeDesc(voteId, getPageIndex());
        //判断投票项数量是否大于3个
        if(this.tickets != null && this.tickets.size() > 3){
            String msg = getText("vote.ticket.limit");
            addFlashMessage(msg);
        }else{
            this.ticket.setVote(vote);
            this.ticketService.save(this.ticket);
        }
        return new DefaultHttpHeaders(CREATE).disableCaching();
    }

    @Override
    public HttpHeaders editNew() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String edit() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String destroy() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String delete() {
        Ticket ticket = this.ticketService.findById(getIntegerId());
        this.ticketService.delete(ticket);
        return redirect();
    }
    
    public DefaultHttpHeaders otherSet(){
        Ticket oldTicket = this.ticketService.findById(getIntegerId());
        oldTicket.setOther(true);
        this.ticketService.update(oldTicket);
        this.setVoteId(oldTicket.getVote().getId());
        return new DefaultHttpHeaders("otherSet").disableCaching();
    }
    
    public DefaultHttpHeaders cancelOhter(){
        Ticket oldTicket = this.ticketService.findById(getIntegerId());
        this.tickets = this.ticketService.listByVoteAndCreateTimeDesc(oldTicket.getVote().getId(), getPageIndex());
        //判断投票项数量是否大于3个
        if(this.tickets != null && this.tickets.size() > 3){ 
            String msg = getText("vote.ticket.limit");
            addFlashMessage(msg);
        }else{
            oldTicket.setOther(false);
            this.ticketService.update(oldTicket);
        }
        this.setVoteId(oldTicket.getVote().getId());
        return new DefaultHttpHeaders("cancelOhter").disableCaching();
    }

    public VoteService getVoteService() {
        return voteService;
    }

    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
