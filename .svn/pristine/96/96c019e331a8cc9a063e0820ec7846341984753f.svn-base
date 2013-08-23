package com.boventech.cms.module.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Menu implements Serializable{

	private static final String REGEX_ADDR = "^/";
	private static final String HTTP_FLAG = "http";

	/**
	 * 
	 */
	private static final long serialVersionUID = -8615739872181749093L;

	private Integer nodeId;

	private String name;
	
	private int level;
	
	private Integer parentId;
	
	private List<Menu> children = new ArrayList<Menu>();
	
	private Menu parent;
	
	private boolean link;
	
	private String address;
	
	private boolean blank;
	
	private int position;
	
	private boolean right;
	
	private Order orders;
	
	public void addSubMenu(Menu sub){
		sub.setParent(this);
		this.children.add(sub);
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public boolean isLink() {
		return link;
	}

	public void setLink(boolean link) {
		this.link = link;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		if (this.address != null && !isStartWithHttp()) {
			this.address = this.address.replaceAll(REGEX_ADDR, "");
		}
	}

	public boolean isBlank() {
		return blank;
	}

	public void setBlank(boolean blank) {
		this.blank = blank;
	}

	public void changeChildren(List<Menu> children) {
		for(Menu m : children){
			m.setParent(this);
		}
		this.children = children;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isStartWithHttp() {
		if (this.address == null) { return false; } 
		return this.address.toLowerCase(Locale.getDefault()).startsWith(HTTP_FLAG);
	}
	
	public static Menu getInstance(Node node){
		Menu menu = new Menu();
		if(node != null){
			menu.setNodeId(node.getId());
			menu.setName(node.getName());
			menu.setPosition(node.getPosition());
			menu.setLink(node.isLink());
			menu.setAddress(node.getAddress());
			menu.setBlank(node.isBlank());
			menu.setOrders(node.getOrders());
			menu.setParentId(node.getParent() != null ? node.getParent().getId() : null);
		}
		return menu;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}
	
}
