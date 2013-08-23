package com.boventech.cms.dao.download;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.download.Attachment;

public interface AttachmentDao extends AbstractDao<Attachment, Integer>{

	List<Attachment> findByName(String name);

	List<Attachment> listByIds(Integer[] removedIds);

	List<Attachment> findByFilepath(String filePath);

}
