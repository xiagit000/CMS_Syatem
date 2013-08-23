package com.boventech.cms.dao;

import java.util.List;

import com.boventech.cms.module.DataType;
import com.boventech.cms.module.web.PageIndex;

public interface DataTypeDao<T extends DataType> extends AbstractDao<T, Integer>{

    List<T> listByPosition(boolean desc);

    List<T> listByPosition(PageIndex pageIndex, boolean desc);

	List<T> findByName(String name);

	List<T> findByPosition(int position);
}
