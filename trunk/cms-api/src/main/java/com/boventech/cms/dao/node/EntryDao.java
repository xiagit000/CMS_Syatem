package com.boventech.cms.dao.node;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.web.PageIndex;

public interface EntryDao extends AbstractDao<Entry, Integer>, EntryQuery{

	List<Entry> listByNodeId(Integer nodeId);

	List<Entry> list(int size, Node node);

	List<Entry> listByNodeId(Integer nodeId, PageIndex pageIndex);

	List<Entry> listEntrys(int number);

	List<Entry> listPicEntrys(int number);

	void updateHits(Entry entry);

	List<Entry> listPubishedEntrys(int number);

	List<Entry> listPubishedByNodeId(Integer nodeId, PageIndex pageIndex);

	List<Entry> listAllByNodeId(Integer nodeId, PageIndex pageIndex, boolean needPublished);

	List<Entry> listPublished(int size, Node node);

	List<Entry> search(String keyword, PageIndex pageIndex, boolean published);

	List<Entry> listAllPublished();

	void changePosition(int integerId, Integer nodeId, int position, int i);

	int countByNodeId(Integer nodeId);

	void cleanPosition(int nodeId, int position);

	void initPositionByNodeId(Integer nodeId);

}
