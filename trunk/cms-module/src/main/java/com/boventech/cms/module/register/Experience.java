package com.boventech.cms.module.register;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class Experience implements Serializable {

	@Column(name = "ex_period")
	private String period; // 起止年月

	@Column(name = "ex_unit")
	private String unit; // 所在单位
	
	@Column(name = "ex_career")
	private String career; // 职业
	
	public Long getId() {
		return id;
	}


	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}


	private static final long serialVersionUID = -3301635515258537509L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
}
