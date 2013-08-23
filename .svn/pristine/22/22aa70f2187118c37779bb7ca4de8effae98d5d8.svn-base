package com.boventech.cms.service.node.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.node.EntryDao;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.EntryCriteria;
import com.boventech.cms.module.node.EntryOrderType;
import com.boventech.cms.module.node.EntryRestrictionType;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.node.Order;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.node.EntryService;

@Service
@Transactional
public class EntryServiceImpl implements EntryService{

	private EntryDao entryDao;
	
	public void moveToNode(Entry e, Node node) {
		e.setBelonged(node);
		this.entryDao.update(e);
	}

	public void delete(Entry t) {
		this.entryDao.delete(t);
	}

	public Entry findById(Integer id) {
		return this.entryDao.findById(id);
	}

	public void save(Entry t) {
		this.entryDao.save(t);
	}

	public void update(Entry t) {
		this.entryDao.update(t);
	}

	public List<Entry> list(Integer nodeId) {
		return this.entryDao.listByNodeId(nodeId);
	}
	
	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}

	public void delete(Integer id) {
		this.entryDao.deleteById(id);
	}

	public List<Entry> list(Node node) {
		return this.entryDao.listByNodeId(node.getId());
	}
	
	public List<Entry> list(int size, Node node) {
		return this.entryDao.list(size, node);
	}

	public List<Entry> list(Integer nodeId, PageIndex pageIndex) {
		return this.entryDao.listByNodeId(nodeId, pageIndex);
	}
	
	public List<Entry> listLatestEntrys(int number) {
		return this.entryDao.listEntrys(number);
	}

	public List<Entry> listPicEntrys(int number) {
//		EntryCriteria entryCriteria = new EntryCriteria();
//		entryCriteria.addNotNull(EntryNullType.IMAGE);
//		entryCriteria.addRestriction(EntryRestrictionType.PUBLISHED, true);
//		entryCriteria.addOrder(EntryOrderType.PUBLISHEDDATE, true);
//		return this.entryDao.list(entryCriteria, number);
	    return this.entryDao.listPicEntrys(number);
	}

	public void updateHits(Entry entry) {
		this.entryDao.updateHits(entry);
	}

	public List<Entry> listLatestPublishedEntrys(int number) {
		return this.entryDao.listPubishedEntrys(number);
	}

	public List<Entry> listPublished(Integer nodeId, PageIndex pageIndex) {
		return this.entryDao.listPubishedByNodeId(nodeId, pageIndex);
	}

	public List<Entry> listAllPublished(Integer nodeId, PageIndex pageIndex) {
		return this.entryDao.listAllByNodeId(nodeId, pageIndex, true);
	}
	
	public List<Entry> listAllByNodeId(Integer nodeId, PageIndex pageIndex) {
		return this.entryDao.listAllByNodeId(nodeId, pageIndex, false);
	}
	
	public List<Entry> listPublished(int size, Node node) {
		return this.entryDao.listPublished(size, node);
	}

	public List<Entry> innerSearch(String keyword, PageIndex pageIndex) {
		return this.entryDao.search(keyword, pageIndex, false);
	}

	public List<Entry> openSearch(String keyword, PageIndex pageIndex) {
		return this.entryDao.search(keyword, pageIndex, true);
	}

	public List<Entry> listAllPublished() {
		return this.entryDao.listAllPublished();
	}
	
	public List<Entry> list(EntryCriteria criteria) {
		return this.entryDao.list(criteria);
	}

	public List<Entry> list(EntryCriteria criteria, Node belonged) {
		criteria.addRestriction(EntryRestrictionType.BELONGED, belonged);
		return this.entryDao.list(criteria);
	}
	
	public List<Entry> listByNode(Node node, PageIndex pageIndex) {
		EntryCriteria entryCriteria = getCriteriaByNode(node);
		return this.entryDao.list(entryCriteria, pageIndex);
	}

	private EntryCriteria getCriteriaByNode(Node node) {
		EntryCriteria entryCriteria = new EntryCriteria();
		entryCriteria.addRestriction(EntryRestrictionType.BELONGED, node);
		if(Order.MANUAL.equals(node.getOrders())){
			entryCriteria.addOrder(EntryOrderType.POSITION, false);
		}else{
			entryCriteria.addOrder(EntryOrderType.PUBLISHEDDATE, true);
		}
		return entryCriteria;
	}

	public List<Entry> listByNode(Node node) {
		EntryCriteria entryCriteria = getCriteriaByNode(node);
		return this.entryDao.list(entryCriteria);
	}
	
	public void shiftUp(int entryId, Integer nodeId, int position) {
		if(position != 1)
			this.entryDao.changePosition(entryId, nodeId, position, position - 1);
	}
	
	public void shiftDown(int entryId, Integer nodeId, int position) {
		int size = this.entryDao.countByNodeId(nodeId);
		if(position < size)
			this.entryDao.changePosition(entryId, nodeId, position, position + 1);
	}
	
	public void cleanPosition(int nodeId, int position) {
		this.entryDao.cleanPosition(nodeId, position);
	}
	
	public int countByNode(Node node) {
		return this.entryDao.countByNodeId(node.getId());
	}
	
	public void initPosition(Integer nodeId) {
		this.entryDao.initPositionByNodeId(nodeId);
	}
	
	public List<Entry> listPublishedByNode(int size, Node node) {
		EntryCriteria entryCriteria = getOpenCriteriaByNode(node);
		return this.entryDao.list(entryCriteria, size);
	}

	private EntryCriteria getOpenCriteriaByNode(Node node) {
		EntryCriteria entryCriteria = getCriteriaByNode(node);
		//entryCriteria.setCacheable(true);
		entryCriteria.addRestriction(EntryRestrictionType.PUBLISHED, true);
		return entryCriteria;
	}
	
	public List<Entry> listPublishedByNode(Node node, PageIndex pageIndex) {
		EntryCriteria entryCriteria = getOpenCriteriaByNode(node);
		return this.entryDao.list(entryCriteria, pageIndex);
	}

	public List<Entry> listFeed(int number) {
		EntryCriteria criteria = new EntryCriteria();
		criteria.addRestriction(EntryRestrictionType.PUBLISHED, true);
		criteria.addOrder(EntryOrderType.PUBLISHEDDATE, true);
		return this.entryDao.list(criteria, number);
	}

}
