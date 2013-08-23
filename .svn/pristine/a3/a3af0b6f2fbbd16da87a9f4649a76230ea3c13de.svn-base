package com.boventech.cms.dao.node;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.node.Comment;
import com.boventech.cms.module.web.PageIndex;

public interface CommentDao extends AbstractDao<Comment, Integer>{

	List<Comment> listByEntryId(Integer entryId);

	List<Comment> listByEntryId(PageIndex pageIndex, Integer entryId);

	int countByEntryId(Integer id);

}
