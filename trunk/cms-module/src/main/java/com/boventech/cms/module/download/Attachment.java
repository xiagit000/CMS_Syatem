package com.boventech.cms.module.download;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.user.User;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Attachment implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 177507387950941233L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String filepath;

    @ManyToOne
    private Entry entry;

    @OneToOne(targetEntity = AbstractAccessStrategy.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private AttachAccessStrategy accessStrategy;

    private String fileName;

    private String orginalName;

    private String contentType;

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public AttachAccessStrategy getAccessStrategy() {
        return accessStrategy;
    }

    public void setAccessStrategy(AttachAccessStrategy accessStrategy) {
        this.accessStrategy = accessStrategy;
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

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getOrginalName() {
        return this.orginalName;
    }

    public void setOrginalName(String orginalName) {
        this.orginalName = orginalName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean canBeAccessBy(User user) {
        return this.accessStrategy != null && this.accessStrategy.canBeAccessBy(user);
    }
}
