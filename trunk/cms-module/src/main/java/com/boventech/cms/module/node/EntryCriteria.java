package com.boventech.cms.module.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * criteria for query a collection of entry.
 * @author junxue.rao
 *
 */
public class EntryCriteria {

	private Map<EntryOrderType, Boolean> orders = new HashMap<EntryOrderType, Boolean>();
	
	private Map<EntryRestrictionType, Object> restrictions = new HashMap<EntryRestrictionType, Object>();
	
	private List<EntryNullType> nulls = new ArrayList<EntryNullType>();
	
	private List<EntryNullType> notNulls = new ArrayList<EntryNullType>();
	
	private List<EntryEmptyType> emptys = new ArrayList<EntryEmptyType>();
	
	private List<EntryEmptyType> notEmptys = new ArrayList<EntryEmptyType>();
	
	private boolean cacheable;
	
	/**
	 * add order by orderType desc if the second parameter is true,asc if not.
	 * @param orderType		the type order by
	 * @param desc			if the order is desc or asc.
	 */
	public void addOrder(EntryOrderType orderType, boolean desc){
		this.orders.put(orderType, desc);
	}
	
	/**
	 * remove 	the order by orderType
	 * @param 	type
	 * @return	the order mode responding to the type in the query criteria.
	 */
	public Boolean removeOrder(EntryOrderType type){
		return this.orders.remove(type);
	}
	
	/**
	 * add restriction of query entry list.
	 * @param restrictionType		the restriction type to add in the query
	 * @param restrictionValue		the responding restriction value
	 */
	public void addRestriction(EntryRestrictionType restrictionType, Object restrictionValue){
		this.restrictions.put(restrictionType, restrictionValue);
	}
	
	/**
	 * remove restriction of query entry list.
	 * @param restrictionType		the restriction type to remove
	 * @return	the restriction value responding to the type in the query criteria.
	 */
	public Object removeRestriction(EntryRestrictionType restrictionType){
		return this.restrictions.remove(restrictionType);
	}
	
	/**
	 * add null restriction of query entry list.
	 * @param type	the type need to be null.
	 */
	public void addNull(EntryNullType type){
		this.nulls.add(type);
	}
	
	/**
	 * remove null restriction of query entry list.
	 * @param type	the null type need to be removed.
	 */
	public void removeNull(EntryNullType type){
		this.nulls.remove(type);
	}
	
	/**
	 * add not null restriction of query entry list.
	 * @param type	the type need to be not null.
	 */
	public void addNotNull(EntryNullType type){
		this.notNulls.add(type);
	}
	
	/**
	 * remove not null restriction of query entry list.
	 * @param type	the not null type need to be removed.
	 */
	public void removeNotNull(EntryNullType type){
		this.notNulls.remove(type);
	}
	
	/**
	 * add empty restriction of query entry list.
	 * @param type	the type need to be empty.
	 */
	public void addEmpty(EntryEmptyType type){
		this.emptys.add(type);
	}
	
	/**
	 * remove empty restriction of query entry list.
	 * @param type	the empty type need to be removed.
	 */
	public void removeEmpty(EntryEmptyType type){
		this.emptys.remove(type);
	}
	
	/**
	 * add not empty restriction of query entry list.
	 * @param type	the type need to be not empty.
	 */
	public void addNotEmpty(EntryEmptyType type){
		this.notEmptys.add(type);
	}
	
	/**
	 * remove not empty restriction of query entry list.
	 * @param type	the not empty type need to be removed.
	 */
	public void removeNotEmpty(EntryEmptyType type){
		this.notEmptys.remove(type);
	}
	
	/**
	 * the map contains the information of order in the criteria.
	 * @return	the map contains the information of order in the criteria.
	 */
	public Map<EntryOrderType, Boolean> getOrders() {
		return orders;
	}
	
	/**
	 * the map contains the information of restriction in the criteria.
	 * @return	the map contains the information of restriction in the criteria.
	 */
	public Map<EntryRestrictionType, Object> getRestrictions() {
		return restrictions;
	}
	
	/**
	 * the list contains the information of restriction null in the criteria.
	 * @return	the list contains the information of restriction null in the criteria.
	 */
	public List<EntryNullType> getNulls() {
		return nulls;
	}
	
	/**
	 * the list contains the information of restriction not null in the criteria.
	 * @return	the list contains the information of restriction not null in the criteria.
	 */
	public List<EntryNullType> getNotNulls() {
		return notNulls;
	}
	
	/**
	 * the list contains the information of restriction empty in the criteria.
	 * @return	the list contains the information of restriction empty in the criteria.
	 */
	public List<EntryEmptyType> getEmptys() {
		return emptys;
	}
	
	/**
	 * the list contains the information of restriction not empty in the criteria.
	 * @return	the list contains the information of restriction not empty in the criteria.
	 */
	public List<EntryEmptyType> getNotEmptys() {
		return notEmptys;
	}

	public boolean isCacheable() {
		return cacheable;
	}

	public void setCacheable(boolean cacheable) {
		this.cacheable = cacheable;
	}
}
