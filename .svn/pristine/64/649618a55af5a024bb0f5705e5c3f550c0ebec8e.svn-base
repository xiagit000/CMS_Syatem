package com.boventech.cms.service.node;

import java.util.List;

import com.boventech.cms.module.node.Comment;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;

public interface CommentService extends BasicService<Comment>{

	List<Comment> listByEntry(Entry entry);

	List<Comment> listByEntry(Entry entry, PageIndex pageIndex);

	int count(Entry entry);

	int countByEntryId(int entryId);
}
