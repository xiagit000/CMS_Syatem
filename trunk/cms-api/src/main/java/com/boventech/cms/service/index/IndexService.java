package com.boventech.cms.service.index;

import java.util.List;

import com.boventech.cms.module.index.Block;
import com.boventech.cms.module.node.Entry;

public interface IndexService {

	Block findBlock(Long id);
	
	Block newBlock(Integer nodeId, int size);
	
	int nextIndex();
	
	void removeBlock(Block block);
	
	void removeBlock(Long id);
	
	List<Entry> listBlockEntry(final Long blockId);

	List<Block> listBlocks();

	Block updateBlock(Long blockId, int selNodeId, int nodeSize);
	
}
