package com.boventech.cms.dao;

import java.io.Serializable;
import java.util.List;

import com.boventech.cms.module.web.PageIndex;

public interface AbstractDao<T,ID extends Serializable> extends Serializable{

	void save(T t);
	
	void update(T t);
	
	void delete(T t);
	
	void saveOrUpdate(T t);
	
	T findById(ID id);
	
	T load(ID id);
	
	List<T> list();
	
	List<T> list(PageIndex pageIndex);
	
	int count();
	
	void deleteById(ID id);
}
