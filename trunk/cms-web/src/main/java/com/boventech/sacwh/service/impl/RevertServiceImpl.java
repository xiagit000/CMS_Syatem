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

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.RevertDao;
import com.boventech.sacwh.module.News;
import com.boventech.sacwh.module.Revert;
import com.boventech.sacwh.service.RevertService;


@Service
@Transactional
public class RevertServiceImpl implements RevertService {

    private RevertDao revertDao;
    
    public void setRevertDao(RevertDao revertDao) {
        this.revertDao = revertDao;
    }

    public void save(Revert t) {
        this.revertDao.save(t);
    }

    public void delete(Revert t) {
        this.revertDao.delete(t);
    }

    public void update(Revert t) {
        this.revertDao.update(t);
    }

    public Revert findById(Integer id) {
        return this.revertDao.findById(id);
    }

    public List<Revert> listAll(PageIndex pageIndex) {
        return this.revertDao.list(pageIndex);
    }

    public List<Revert> listAllByNews(PageIndex pageIndex, News news) {
        return this.revertDao.listAllByNews(pageIndex, news);
    }

    public Revert findByUserAndNews(Integer userId, Integer newsId) {
        return this.revertDao.findByUserAndNews(userId, newsId);
    }
    
}
