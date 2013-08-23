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

package com.boventech.sacwh.dao;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.sacwh.module.Adword;

public interface AdwordDao extends AbstractDao<Adword, Integer>{
        List<Adword> listOrderBy();
        List<Adword> listOrderBy(PageIndex pageIndex,String property);
}
