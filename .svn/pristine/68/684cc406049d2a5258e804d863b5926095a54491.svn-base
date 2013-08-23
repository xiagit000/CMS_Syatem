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

package com.boventech.sacwh.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.sacwh.module.Ticket;
import com.boventech.sacwh.module.Vote;
import com.boventech.sacwh.service.TicketService;
import com.boventech.sacwh.service.VoteService;
import com.google.common.base.Strings;

/**
 * 投票前台控制器
 * @author liang.zhou
 */
@Results({
    @Result(name = "show", type = "dispatcher", location = "sacwh/ticket/show.jsp"),
    @Result(name = "index", type = "dispatcher", location = "sacwh/ticket/index.jsp"),
    @Result(name = "create", type = "redirect", location = "/open")
})
public class TicketAction extends OpenAction{

    private static final long serialVersionUID = -4754789699263530300L;
    
    private VoteService voteService;
    
    private TicketService ticketService;
    
    private List<Ticket> tickets;
    
    private Ticket ticket;
    
    private List<Vote> votes;
    
    private int voteId;
    
    private Vote vote;
    
    public HttpHeaders index() {
        this.votes = this.voteService.listAll(getPageIndex());
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }
    
    /**
     * 投票
     * @return
     */
    public DefaultHttpHeaders create() {
        if (this.ticket.getId() == 0){
            Ticket oldTicket = this.ticketService.findByTitle(this.ticket.getTitle(),this.voteId);
          //判断是否已经存在该名称的投票项，存在则该投票项+1，不存在则新建投票项并设置结果为1
            if(oldTicket != null){
                int newCount = oldTicket.getVoteCount() + 1;
                oldTicket.setVoteCount(newCount);
                this.ticketService.update(oldTicket);
            }else{
                if(!Strings.isNullOrEmpty(this.ticket.getTitle())){ //判断投票项标题是否为空
                    Vote vote = this.voteService.findById(voteId);
                    this.ticket.setVote(vote);
                    this.ticket.setOther(true);
                    this.ticket.setId(null);
                    this.ticket.setVoteCount(1);
                    this.ticketService.save(this.ticket);
                }
                this.setVoteId(voteId);
            }
        }else{
            if(this.ticket.getId() != null){
                Ticket oldTicket = this.ticketService.findById(this.ticket.getId());
                int newCount = oldTicket.getVoteCount() + 1;
                oldTicket.setVoteCount(newCount);
                this.ticketService.update(oldTicket);
            }
        }
        return new DefaultHttpHeaders("create").disableCaching();
    }
    
    public HttpHeaders show() {
        this.vote = this.voteService.findById(getIntegerId());
        this.tickets = this.ticketService.listByVoteOrderByCount(getIntegerId(), getPageIndex());
        return new DefaultHttpHeaders(SHOW).disableCaching();
    }
    
    public VoteService getVoteService() {
        return voteService;
    }

    public void setVoteService(VoteService voteService) {
        this.voteService = voteService;
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

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
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

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

}
