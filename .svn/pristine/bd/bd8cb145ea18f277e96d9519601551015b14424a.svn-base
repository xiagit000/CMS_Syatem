package com.boventech.cms.service.index.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.index.BlockDao;
import com.boventech.cms.dao.node.NodeDao;
import com.boventech.cms.module.index.Block;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.service.index.IndexService;
import com.boventech.cms.service.node.EntryService;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {

	@Resource
	private BlockDao blockDao;
	
	@Resource
	private NodeDao nodeDao;
	
	@Resource
	private EntryService entryService;
	
	
	public Block updateBlock(final Long blockId, final int nodeId, final int nodeSize) {
		final Node node = this.nodeDao.findById(nodeId); 
		Block block = this.blockDao.findById(blockId);
		block.changeNode(node);
		block.changeSize(nodeSize);
		this.blockDao.save(block);
		return block;
	}

	public Block findBlock(Long id) {
		return this.blockDao.findById(id);
	}

	public synchronized Block newBlock(final Integer nodeId, final int size) {
		Node node = this.nodeDao.findById(nodeId);
		int index = this.blockDao.nextIndex();
		Block block = new Block(node, size, index);
		this.blockDao.save(block);
		return block;
	}
	
	public synchronized int nextIndex() {
		return this.blockDao.nextIndex();
	}

	
	public void removeBlock(final Block block) {
		final int index = block.getIndex();
		this.blockDao.delete(block);
		this.blockDao.updateIndex(index);
	}
	
	
	public void removeBlock(final Long id){
		Block block = this.findBlock(id);
		removeBlock(block);
	}

	public List<Entry> listBlockEntry(final Long blockId) {
		Block block = this.blockDao.findById(blockId);
		Node node = block.getNode();
		if (node == null) {
			return Collections.emptyList();
		}
		return this.entryService.list(block.getSize(), node);
	}
	
	public List<Block> listBlocks() {
		List<Block> blocks = this.blockDao.list();
		return Collections.unmodifiableList(blocks);
	}
	
}
