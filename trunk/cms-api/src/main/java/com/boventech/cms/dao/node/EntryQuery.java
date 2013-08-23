package com.boventech.cms.dao.node;

import java.util.List;

import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.EntryCriteria;
import com.boventech.cms.module.web.PageIndex;

public interface EntryQuery {

	List<Entry> list(EntryCriteria criteria);
	
	List<Entry> list(EntryCriteria criteria, int number);
	
	List<Entry> list(EntryCriteria criteria, PageIndex pageIndex);
}
