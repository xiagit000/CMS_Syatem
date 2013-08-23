package com.boventech.cms.module.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.boventech.cms.module.right.AuthrizableEntity;
import com.boventech.cms.module.right.AuthrizationAware;
import com.boventech.cms.module.right.Operation;
import com.boventech.cms.module.right.Privilege;

/**
 * class represents a node of tree describe a type of items.
 * @author applerao
 *
 */
@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Node implements Serializable, AuthrizationAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7842616938647691662L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	private Node parent;
	
	private int position;
	
	private boolean display;
	
	private boolean link;
	
	private boolean blank;
	
	private String address;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "parent", orphanRemoval = true)
	private List<Node> children = new ArrayList<Node>();
	
	@Enumerated(EnumType.STRING)
	private Order orders = Order.PUBLISHEDTIME;
	
	public boolean isAuthrized(AuthrizableEntity entity, Operation operation) {
		Node currentNode = this;
		while(currentNode != null){
			boolean authrized =  entity.hasPrivilege(new Privilege(currentNode, operation));
			if(authrized)
				return true;
			else
				currentNode = currentNode.getParent();
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Node){
			return this.id != null && this.id.equals(((Node)obj).getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode() * 24 + this.name.hashCode() + this.position;
	}
	
	public boolean positionCanBeMoved() {
		return this != null && Order.MANUAL.equals(this.orders)
			&& this.children.isEmpty();
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
	public List<Node> getChildren() {
		return children;
	}
	
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public Integer getId() {
		return id;
	} 
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void addChild(Node child) {
		child.setParent(this);
		this.getChildren().add(child);
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public boolean isLink() {
		return link;
	}

	public void setLink(boolean link) {
		this.link = link;
	}
	
	public void setBlank(boolean blank) {
		this.blank = blank;
	}

	public boolean isBlank() {
		return blank;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setOrders(Order orders) {
		this.orders = orders;
	}
	
	public Order getOrders() {
		return orders;
	}

}
