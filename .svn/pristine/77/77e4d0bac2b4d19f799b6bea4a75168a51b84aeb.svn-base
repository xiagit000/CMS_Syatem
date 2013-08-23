package com.boventech.cms.module;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * class for record the type of data
 * @author junxue.rao
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DATATYPE", discriminatorType = DiscriminatorType.STRING)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public abstract class DataType implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 3403703905057671403L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String name;
    
    private int position;
    
    @Override
    public boolean equals(Object obj) {
    	if(obj != null && obj instanceof DataType)
    		return this.id.equals(((DataType)obj).getId());
    	return false;
    }
    
    @Override
    public int hashCode() {
    	return this.id.hashCode() * 24 + this.name.hashCode() * 4 + this.position;
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
}
