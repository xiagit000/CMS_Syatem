package com.boventech.cms.service.node;

import java.util.List;

import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.EntryCriteria;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;

public interface EntryService extends BasicService<Entry>{

	void moveToNode(Entry e, Node node);

	List<Entry> list(Node node);
	
	List<Entry> list(int size, Node node);
	
	List<Entry> list(Integer nodeId);

	void delete(Integer id);

	List<Entry> list(Integer nodeId, PageIndex pageIndex);
	
	List<Entry> listLatestEntrys(int number);
	
	List<Entry> listPicEntrys(int number);

	void updateHits(Entry entry);

	List<Entry> listPublished(Integer nodeId, PageIndex pageIndex);

	List<Entry> listLatestPublishedEntrys(int number);

	List<Entry> listAllPublished(Integer nodeId, PageIndex pageIndex);

	List<Entry> listAllByNodeId(Integer nodeId, PageIndex pageIndex);

	List<Entry> listPublished(int size, Node node);
	
	List<Entry> openSearch(String keyword, PageIndex pageIndex);
	
	List<Entry> innerSearch(String keyword, PageIndex pageIndex);

	List<Entry> listAllPublished();
	
	List<Entry> list(EntryCriteria criteria);
	
	List<Entry> list(EntryCriteria criteria, Node belonged);

	List<Entry> listByNode(Node node, PageIndex pageIndex);

	List<Entry> listByNode(Node node);

	void shiftUp(int integerId, Integer nodeId, int position);

	void shiftDown(int integerId, Integer nodeId, int position);

	void cleanPosition(int nodeId, int position);

	int countByNode(Node node);

	void initPosition(Integer id);

	List<Entry> listPublishedByNode(int size, Node node);

	List<Entry> listPublishedByNode(Node node, PageIndex pageIndex);

	List<Entry> listFeed(int i);

}
