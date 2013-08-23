/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 208 $
 * $Author: peng.xia $
 * $LastChangedDate: 2012-11-30 10:45:36 +0800 (星期五, 30 十一月 2012) $
 *
 */

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.dao.AdwordDao;
import com.boventech.sacwh.module.Adword;
import com.boventech.sacwh.service.AdwordService;

@Service
@Transactional
public class AdwordServiceImpl implements AdwordService {

    private AdwordDao adwordDao;
    
    public void setAdwordDao(AdwordDao adwordDao) {
        this.adwordDao = adwordDao;
    }

    public void save(Adword t) {
        this.adwordDao.save(t);
    }

    public void delete(Adword t) {
        this.adwordDao.delete(t);
    }

    public void update(Adword t) {
        this.adwordDao.update(t);
    }

    public Adword findById(Integer id) {
        return this.adwordDao.findById(id);
    }

    public List<Adword> listAll(PageIndex pageIndex) {
        return this.adwordDao.listOrderBy(pageIndex,"orderby");
    }

    /* (non-Javadoc)
     * @see com.boventech.sacwh.service.AdwordService#listAll()
     */
    public List<Adword> listAll() {
        // TODO Auto-generated method stub
        return this.adwordDao.listOrderBy();
    }


    
}
