/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 18 $
 * $Author: zinan.liao $
 * $LastChangedDate: 2012-09-24 09:39:10 +0800 (星期一, 24 九月 2012) $
 *
 */

package com.boventech.sacwh.service;

import java.util.List;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;
import com.boventech.sacwh.module.Complaint;

public interface ComplaintService extends BasicService<Complaint>{

    List<Complaint> listAll(PageIndex pageIndex);
}
