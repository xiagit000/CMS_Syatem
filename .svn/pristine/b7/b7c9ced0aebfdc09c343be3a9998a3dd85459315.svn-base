package com.boventech.cms.dao.node.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.node.CommentDao;
import com.boventech.cms.module.node.Comment;
import com.boventech.cms.module.web.PageIndex;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Comment, Integer> implements CommentDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6906525736149703695L;

	private static final String ENTRY_ID = "entryId";
	
	public List<Comment> listByEntryId(Integer entryId) {
		return listByProperty(ENTRY_ID, entryId);
	}

	public List<Comment> listByEntryId(PageIndex pageIndex, Integer entryId) {
		return listByProperty(pageIndex, ENTRY_ID, entryId);
	}

	public int countByEntryId(Integer entryId) {
		return countByProperty(ENTRY_ID, entryId);
	}

}
