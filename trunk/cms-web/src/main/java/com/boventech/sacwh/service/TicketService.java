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
import com.boventech.sacwh.module.Ticket;

public interface TicketService extends BasicService<Ticket>{

    /**
     * 根据投票ID列出当前页的投票选项
     * @param voteId 投票ID
     * @param pageIndex
     * @return
     */
    List<Ticket> listByVote(int voteId, PageIndex pageIndex);

    /**
     * 根据投票id和创建时间列出投票选项
     * @param id
     * @param pageIndex 
     * @return
     */
    List<Ticket> listByVoteAndCreateTimeDesc(Integer id, PageIndex pageIndex);

    /**
     * 根据名称查找投票项
     * @param title
     * @param voteId
     * @return
     */
    Ticket findByTitle(String title, int voteId);

    /**
     * 根据投票id和投票结果列出投票选项
     * @param voteId
     * @param pageIndex
     * @return
     */
    List<Ticket> listByVoteOrderByCount(int voteId, PageIndex pageIndex);

}
