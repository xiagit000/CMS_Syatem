package com.boventech.permalink;


/**
 * represent permalink definition for one object type. Generally this definition must contains
 * correct {@link  PermalinkVariable} that can be supported by this type. <br />
 * <strong>example:</strong><br />
 *  if you have one class Entry and support variables "%{entry_id}", "%{entry_name}"; then you 
 *  can define the permalink as "/entry/%{entry_id}"
 * 
 * @author xiedongming
 *
 */
public interface PermalinkDefinition {

	/**
	 * type for this permalink definition
	 * @return
	 */
	Class<?> getType();

	/**
	 * definition expression for this permalink
	 * 
	 * @return
	 */
	String getDefinition();
	
	/**
	 * generate  permalink for the given object
	 * @param obj
	 * @return
	 */
	String generatePermalink(Object obj);
	
	/**
	 * get supported permalink variables for this type.
	 * 
	 * @return
	 */
	PermalinkVariable[] supportedVariables();

}
