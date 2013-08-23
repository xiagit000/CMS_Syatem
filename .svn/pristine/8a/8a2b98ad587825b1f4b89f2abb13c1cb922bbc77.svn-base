package com.boventech.cms.module.right;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.boventech.cms.module.node.Node;

@Entity
public class Privilege implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 279707339824878464L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@OneToOne
	private Node node;
	
	@Enumerated(EnumType.STRING)
	private Operation operation;
	
	private int position;

	public Privilege(){
		
	}
	
	public Privilege(Node node, Operation operation) {
		this.node = node;
		this.operation = operation;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Privilege){
			Privilege comparaed = (Privilege)obj; 
			return comparaed.getNode().equals(this.node) &&
				comparaed.getOperation().equals(this.operation);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.node.hashCode() * 24 + this.operation.hashCode();
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

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
