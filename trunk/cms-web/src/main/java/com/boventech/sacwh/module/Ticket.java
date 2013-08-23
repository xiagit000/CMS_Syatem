/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 107 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-10-12 10:17:06 +0800 (星期五, 12 十月 2012) $
 *
 */

package com.boventech.sacwh.module;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sacwh_ticket")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    
    private int voteCount = 0;

    @ManyToOne
    private Vote vote;

    private boolean other; //是否其他选项，默认为是
    
    private Date createTime = new Date();
    
    private Date updateTime;
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

   
    
}
