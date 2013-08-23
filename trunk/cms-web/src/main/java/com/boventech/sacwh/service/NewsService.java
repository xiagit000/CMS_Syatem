/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 104 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-10-11 16:45:37 +0800 (星期四, 11 十月 2012) $
 *
 */

package com.boventech.sacwh.service;

import java.util.List;

import com.boventech.cms.module.user.User;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;
import com.boventech.sacwh.module.News;

public interface NewsService extends BasicService<News>{

    List<News> listAll(PageIndex pageIndex);
    
    List<User> getNoReverter(Integer newsId);

    void deleteByNews(int newsId);
}
