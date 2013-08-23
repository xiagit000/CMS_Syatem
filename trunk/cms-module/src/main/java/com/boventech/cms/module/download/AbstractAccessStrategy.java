package com.boventech.cms.module.download;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "StrategyType")
public abstract class AbstractAccessStrategy implements AttachAccessStrategy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6391602310113195925L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private AccessStrategyTag tag;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setTag(AccessStrategyTag tag) {
		this.tag = tag;
	}
	
	public AccessStrategyTag getTag() {
		return tag;
	}
	
}
