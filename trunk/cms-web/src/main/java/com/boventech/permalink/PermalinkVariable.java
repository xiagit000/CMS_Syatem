package com.boventech.permalink;


/**
 * 
 * supported permalink variables for one type
 * <br/><strong>example:</strong><br /> if you have one Entry class, you can define 
 *  "%{entry_id}", "%{entry_name}" as the supported variables when generate permalink.
 *  <br /><strong>note:</strong> It's suggested using special format for the variable expression
 *  like "%{...}", "#{...}" and so on.
 * 
 * @author xiedongming
 *
 * @param <T>
 */
public interface PermalinkVariable<T> {

	/**
	 * get Reguar Expression pattern for this variable. 
	 * <br /><strong>Example:</strong><br /> if you want to use "%{entry_year}" represent one 
	 * entry's integer year. you can use "(\\d{4})" as the pattern for variable "%{entry_year}"
	 * <br /><strong>Note:</strong><br /> you should use the pattern which can extract value
	 * when do reguar matching, it means most time you need to put your reguar patter inside 
	 * "()", like  "(\\d{4})" not "\\d{4}" 
	 * 
	 * @return
	 */
	String pattern();

	/**
	 * get one object's exact permalink value for this permalink variable
	 * @param obj
	 * @return
	 */
	String encode(T obj);

	/**
	 * get permalink variable expression. Like "%{entry_id}"
	 * <br /><strong>note:</strong> It's suggested using special format for the variable 
	 * expression like "%{...}", "#{...}" and so on.
	 * 
	 * @return
	 */
	String getVariable();

}
