package com.boventech.cms.module.email;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520062150354354647L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String subject;
	
	private String content;
	
	public EmailTemplate(String subject, String content){
		this.subject = subject;
		this.content = content;
	}

	public EmailTemplate() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
