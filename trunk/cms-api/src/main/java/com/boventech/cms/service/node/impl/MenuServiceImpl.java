package com.boventech.cms.service.node.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.node.NodeDao;
import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.right.Operation;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.node.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{

	private NodeDao nodeDao;
	
	private static NodeComparator comparator = new NodeComparator();
	
	public List<Menu> listAdminMenus() {
		List<Node> nodes = this.nodeDao.findByParentId(null, false);
		return cleanResults(nodes, 0);
	}

	public List<Menu> listOpenMenus() {
		List<Node> nodes = this.nodeDao.findByParentId(null, true);
		return cleanResults(nodes, 0);
	}
	
	private List<Menu> cleanResults(List<Node> nodes, int level) {
		int menuLevel = level + 1;
		List<Menu> menus = new ArrayList<Menu>();
		Collections.sort(nodes, comparator);
		for(Node node:nodes){
			Menu menu = Menu.getInstance(node);
			menu.setLevel(menuLevel);
			menus.add(menu);
			if(node.getChildren().size() > 0){
				menu.changeChildren(cleanResults(node.getChildren(), menuLevel));
			}
		}
		return menus;
	}
	
	private static class NodeComparator implements Comparator<Node>{

		public int compare(Node o1, Node o2) {
			return o1.getPosition() - o2.getPosition();
		}
		
	}

	public List<Menu> listUserVisiableMenus(User user, Integer parentId) {
		List<Node> nodes = this.nodeDao.findByParentId(parentId, false);
		return cleanVisiableMenus(user, nodes, 1);
	}
	
	private List<Menu> cleanVisiableMenus(User user, List<Node> nodes, int level) {
		List<Menu> menus = new ArrayList<Menu>();
		for(Node node:nodes){
			boolean right = node.isAuthrized(user, Operation.EDIT_NODE);
			if(right){
				menus.add(convert(node, level, right));
			}else{
				List<Node> children = node.getChildren();
				menus.addAll(cleanVisiableMenus(user, children, level+1));
			}
		}
		return menus;
	}

	private Menu convert(Node node,int level,boolean right){
		Menu menu = Menu.getInstance(node);
		menu.setLevel(level);
		menu.setRight(right);
		return menu;
	}
	
	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}


}
