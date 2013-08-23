/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 96 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-10-10 14:32:32 +0800 (星期三, 10 十月 2012) $
 *
 */

package com.boventech.sacwh.service;

import java.util.List;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;
import com.boventech.sacwh.module.News;
import com.boventech.sacwh.module.Revert;

public interface RevertService extends BasicService<Revert>{

    List<Revert> listAll(PageIndex pageIndex);
    
    List<Revert> listAllByNews(PageIndex pageIndex, News news);

    /**
     * 根据用户id和新闻id查找回复
     * @param userId
     * @param newsId
     * @return
     */
    Revert findByUserAndNews(Integer userId, Integer newsId);
}
