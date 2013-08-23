package com.boventech.cms.module.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HighlightInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6711810466807060726L;

	@Column(name = "SYSTEMINFO_HIGHLIGHT")
	private Boolean highlight;

	@Column(name = "SYSTEMINFO_HIGHLIGHTDAYS")
	private Integer highlightDays;

	public Boolean getHighlight() {
		return highlight;
	}

	public Integer getHighlightDays() {
		return highlightDays;
	}

	public void setHighlight(Boolean highlight) {
		this.highlight = highlight;
	}

	public void setHighlightDays(Integer highlightDays) {
		this.highlightDays = highlightDays;
	}

}
