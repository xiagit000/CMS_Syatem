package com.boventech.cms.service.description;

import java.util.List;

import com.boventech.cms.module.description.Description;
import com.boventech.cms.module.web.PageIndex;

public interface DescriptionService {
	
	List<Description> list(boolean cacheEnable);
	
	List<Description> list(PageIndex pageIndex);

	void save(Description description);

	void delById(Integer id);

	Description findById(Integer id);

	void update(Description des);

	Description findByAlias(String name);

}
