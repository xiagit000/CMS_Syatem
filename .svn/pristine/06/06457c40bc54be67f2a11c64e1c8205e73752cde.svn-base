package com.boventech.cms.dao.download.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.download.AttachmentDao;
import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.module.download.Attachment;

@Repository
public class AttachmentDaoImpl extends AbstractDaoImpl<Attachment, Integer> implements AttachmentDao{

    /**
     * 
     */
    private static final long serialVersionUID = -5488698067286276650L;
    
    private static final String NAME = "name";
    
    private static final String FILEPATH = "filepath";

	public List<Attachment> findByName(String name) {
		return listByProperty(NAME, name);
	}
	
	public List<Attachment> listByIds(Integer[] ids) {
		return super.listByIds(ids);
	}
	
	public List<Attachment> findByFilepath(String filePath) {
		return listByProperty(FILEPATH, filePath);
	}

}
