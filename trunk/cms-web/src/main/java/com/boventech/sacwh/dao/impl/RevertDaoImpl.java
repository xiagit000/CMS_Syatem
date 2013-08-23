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

package com.boventech.sacwh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.RevertDao;
import com.boventech.sacwh.module.News;
import com.boventech.sacwh.module.Revert;

@Repository
public class RevertDaoImpl extends AbstractDaoImpl<Revert, Integer> implements RevertDao {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    public List<Revert> listAllByNews(PageIndex pageIndex, News news) {
        return (List<Revert>) executeListWithPaging("from Revert where news = ?",pageIndex, news);
    }

    @SuppressWarnings("unchecked")
    public Revert findByUserAndNews(Integer userId, Integer newsId) {
        List<Revert> revert = (List<Revert>) executeListWithPaging("from Revert where revertUser.id = ? AND news.id=?", null, userId,newsId);
        return revert.isEmpty() ? null : revert.get(0);
    }

    
}
