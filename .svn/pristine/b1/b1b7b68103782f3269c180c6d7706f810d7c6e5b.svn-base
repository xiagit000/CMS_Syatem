package com.boventech.cms.module.index;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.boventech.cms.module.node.Node;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Block implements Serializable {

	private static final long serialVersionUID = -6958587384020889810L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "NODE_ID")
	private Node node;
	
	@Column(name = "BLOCK_SIZE")
	private int size;
	
	@Column(name = "BLOCK_INDEX", unique = true)
	private int index;
	
	public Block(Node node, int size, int index) {
		this.node = node;
		this.size = size;
		this.index = index;
	}
	
	public void changeNode(Node newNode) {
		this.node = newNode;
	}
	
	public void changeSize(int size) {
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public Node getNode() {
		return node;
	}
	
	public String getName() {
		if (node == null) { return null; }
		return node.getName();
	}

	public int getSize() {
		return size;
	}

	Block() {
		// for hibernate
	}

	public int getIndex() {
		return index;
	}
}
