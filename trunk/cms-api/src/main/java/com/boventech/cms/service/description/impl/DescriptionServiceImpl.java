package com.boventech.cms.service.description.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.description.DescriptionDao;
import com.boventech.cms.module.description.Description;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.description.DescriptionService;

@Service
@Transactional
public class DescriptionServiceImpl implements DescriptionService {

	private DescriptionDao descriptionDao;

	public Description findById(Integer id) {
		return this.descriptionDao.findById(id);
	}
	
	public void update(Description des) {
		this.descriptionDao.update(des);
	}
	
	public void delById(Integer id) {
		this.descriptionDao.deleteById(id);
	}

	public void save(Description description) {
		this.descriptionDao.save(description);
	}

	public List<Description> list(boolean cacheEnable) {
		return this.descriptionDao.list(cacheEnable);
	}

	public List<Description> list(PageIndex pageIndex) {
		return this.descriptionDao.list(pageIndex);
	}

	public void setDescriptionDao(DescriptionDao descriptionDao) {
		this.descriptionDao = descriptionDao;
	}

	public DescriptionDao getDescriptionDao() {
		return descriptionDao;
	}

	public Description findByAlias(String name) {
		return this.descriptionDao.findByAlias(name);
	}

}
