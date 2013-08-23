package com.boventech.cms.service.log;

import java.util.List;

import com.boventech.cms.module.log.AppLog;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;

public interface LogService extends BasicService<AppLog>{

	List<AppLog> list(PageIndex pageIndex);

}
