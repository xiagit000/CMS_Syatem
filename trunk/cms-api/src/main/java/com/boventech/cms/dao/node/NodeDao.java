package com.boventech.cms.dao.node;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.node.Node;

public interface NodeDao extends AbstractDao<Node, Integer>{

	List<Node> findByParentId(Integer id);

	int count(Integer parentId);

	void changePosition(Integer id, Integer parentId,  int oldPosition, int newPosition);

	void changePosition(Integer parentId, int position);

	List<Node> findByParentId(Integer parentId, boolean display);
	
	List<Object[]> listTree(boolean display);

	List<Object[]> listTree(boolean display, Integer parentId);
	
	Node findByName(String name);

}
