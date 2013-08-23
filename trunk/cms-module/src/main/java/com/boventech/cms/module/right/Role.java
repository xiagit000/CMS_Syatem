package com.boventech.cms.module.right;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 42635628011503799L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private int position;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
	private List<Privilege> privileges = new ArrayList<Privilege>();
	
	public boolean check(Integer nodeId, Operation opt){
		for(Privilege plg:this.privileges){
			if(plg.getNode().getId().equals(nodeId) && plg.getOperation().equals(opt))
				return true;
		}
		return false;
	}
	
	public boolean hasPrivilege(Privilege plg) {
		for(Privilege privilege:this.privileges){
			if(privilege.equals(plg))
				return true;
		}
		return false;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	public void replacePrivileges(List<Privilege> privileges){
		this.privileges.clear();
		this.privileges.addAll(privileges);
	}
	
	public void removePrivileges(){
		this.privileges.clear();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Role)
			return this.getId().equals(((Role)obj).getId());
		return false;
	}
	
	@Override
	public int hashCode() {
		if(this.getId() != null)
			return this.getId().hashCode();
		return this.getName().hashCode() * 24;
	}

}
