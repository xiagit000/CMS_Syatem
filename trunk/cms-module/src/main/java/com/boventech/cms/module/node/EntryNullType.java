package com.boventech.cms.module.node;

/**
 * enumeration for entry null types.
 * @author junxue.rao
 *
 */
public enum EntryNullType {

	AUTHOR("author"),
	IMAGE("image"),
	BELONGED("belonged");
	
	EntryNullType(String field) {
		this.field = field; 
	}
	
	private String field;
	
	/**
	 * get the field name responding to the enumeration
	 * @return the field name responding to the enumeration.
	 */
	public String getField() {
		return field;
	}
}
