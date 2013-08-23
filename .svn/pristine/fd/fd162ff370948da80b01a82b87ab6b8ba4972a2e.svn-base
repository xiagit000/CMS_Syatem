package com.boventech.cms.service;

import java.util.List;

import com.boventech.cms.module.DataType;
import com.boventech.cms.module.web.PageIndex;

public interface DataTypeService<T extends DataType> extends BasicService<T>{

    List<T> listByPosition(boolean desc);
    
    void cleanPosition();
    
    void deleteSelected(String[] ids);
    
    List<T> listByPosition(PageIndex pageIndex, boolean desc);
    
    T getByName(String name);
    
    T getByPosition(int position);
    
    int count();
    
    void cleanPositon();
    
    List<T> list();
}
