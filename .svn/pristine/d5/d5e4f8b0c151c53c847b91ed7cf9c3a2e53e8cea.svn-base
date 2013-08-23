package com.boventech.cms.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.DataTypeDao;
import com.boventech.cms.module.DataType;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.DataTypeService;
import com.boventech.util.math.Util;

@Transactional
@SuppressWarnings("unchecked")
public abstract class DataTypeServiceImpl<T extends DataType> implements DataTypeService<T>{

    private DataTypeDao dataTypeDao;
    
    public void delete(T t) {
        this.dataTypeDao.delete(t);
    }

    public T findById(Integer id) {
        return (T) this.dataTypeDao.findById(id);
    }

    public void save(T t) {
        this.dataTypeDao.save(t);
    }

    public void update(T t) {
        this.dataTypeDao.update(t);
    }

    protected void initDataTypeDao(DataTypeDao dataTypeDao) {
        this.dataTypeDao = dataTypeDao;
    }

    public void cleanPositon() {
        List<T> ts = this.dataTypeDao.listByPosition(false);
        int i = 0;
        for(T t:ts){
            i++;
            if(t != null && t.getPosition() != i){
                t.setPosition(i);
                this.dataTypeDao.update(t);
            }
        }
    }

    public List<T> listByPosition(boolean desc) {
        return (List<T>) this.dataTypeDao.listByPosition(desc);
    }

    public void cleanPosition() {
        List<T> types = (List<T>) this.dataTypeDao.listByPosition(false);
        int i = 0;
        for(T t:types){
            i++;
            if(t != null && t.getPosition() != i){
                t.setPosition(i);
                this.dataTypeDao.update(t);
            }
        }
    }
    
    public void deleteSelected(String[] ids) {
        for(String id:ids){
            if(Util.isNumeric(id)){
                Integer typeId = Integer.valueOf(id);
                T t = (T) this.dataTypeDao.findById(typeId);
                if(t != null){
                    this.dataTypeDao.delete(t);
                }
            }
        }
    }
    
    public int count() {
        return this.dataTypeDao.count();
    }
    
    public List<T> listByPosition(PageIndex pageIndex, boolean desc) {
        return (List<T>) this.dataTypeDao.listByPosition(pageIndex, desc);
    }

    public T getByName(String name) {
        List<T> types= (List<T>) this.dataTypeDao.findByName(name);
        return types != null && types.size() > 0 ? types.get(0) : null;
    }

    public T getByPosition(int position) {
        List<T> types= (List<T>) this.dataTypeDao.findByPosition(position);
        return types != null && types.size() > 0 ? types.get(0) : null;
    }

    public List<T> list() {
        return this.dataTypeDao.list();
    }

}
