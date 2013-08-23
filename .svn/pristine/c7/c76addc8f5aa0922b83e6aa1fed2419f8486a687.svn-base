package com.boventech.cms.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.util.MessageFlashable;
import com.boventech.cms.action.util.OneTimeConsumeHashMap;
import com.boventech.cms.module.user.User;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.user.UserService;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.math.Util;
import com.opensymphony.xwork2.ActionSupport;

@Results({
    @Result(name = "success", type = "dispatcher", location = "/templates/default/success.jsp"),
    @Result(name = "noright", type = "dispatcher", location = "/templates/default/errorOperation.jsp"),
    @Result(name = "errorPassword", type = "dispatcher", location = "/templates/default/errorPassword.jsp"),
    @Result(name = "building", type = "dispatcher", location = "/templates/default/building.jsp"),
    @Result(name = "input", type = "dispatcher", location = "/fileUploadError.jsp"),
    @Result(name = "404", type="httpheader", params = {"error","404"}),
    @Result(name = "505", type="httpheader", params = {"error","505"})
})
public abstract class AbstractAction extends ActionSupport implements MessageFlashable{

	private static final long serialVersionUID = 1306865438576513518L;

	private String id;
	
	private String previousUrl;
	
	private String currentUrl;
	
	private String currentURI;
	
	protected static final String LIST = "list";
	
	protected static final String INDEX = "index";
	
	protected static final String SHOW = "show";
	
	protected static final String CREATE = "create";
	
	protected static final String NEW = "new";
	
	protected static final String EDIT = "edit";
	
	protected static final String UPDATE = "update";
	
	protected static final String DESTROY = "destroy";
	
	protected static final String SUCCESS = "success";
	
	protected static final String EDITNEW = "editNew";
	
	protected static final String NO_RIGHT = "noRight";
	
	protected static final String TO_INDEX = "toIndex";
	
	protected static final int SMALL_NUMBER = 5;
    
	protected static final int MEDIUM_NUMBER = 10;
    
	protected static final int LARGE_NUMBER = 15;
	
	protected static final int SUPER_LARGE_NUMBER = 25;
	
	protected static final String SELECTED = "selected";
	
	protected static final String NOT_FOUND = "not_found";

	public abstract HttpHeaders index();

	public abstract HttpHeaders show();

	public abstract HttpHeaders create();

	public abstract HttpHeaders editNew();

	public abstract String update();

	public abstract String edit();

	public abstract String destroy();
	
	private UserService userService;
	
	private String continueURL;
	
	private int page = 1;
	
	private int size = MEDIUM_NUMBER;
	
	private PageIndex pageIndex;
	
	private String redirectUrl;
	
	@Resource
	private Boolean commentEnabled;
	
	@Resource
	private Boolean ldapEnabled;
	
	//存储本次action调用中需要被保存的信息,此消息将在用户的下一次请求中消费,且只消费一次
	private Map<String, Object> msgs = new OneTimeConsumeHashMap<String, Object>();
	
	public static final String KEY_FLASH = "flash";

	protected static final String PRE_URL_ID = "pre";

	protected static final String PRE_ENTRY_KEY = "pre_entry";
	
	/**
	 * 一次Action调用完成之后需要暂时保存的消息，以供消费
	 */
	public Map<String, Object> messagesToStore() {
		return msgs;
	}
	
	/**
	 * 添加一条flash消息, 此消息默认的key为"flash"
	 * @param value
	 */
	protected void addFlashMessage(Object value){
		if(value != null)
			this.msgs.put(KEY_FLASH, value);
	}
	
	
	/**
	 * 添加一条消息
	 * @param key
	 * @param value
	 */
	protected void addMessage(String key, Object value){
		if(key != null && value != null)
			this.msgs.put(key, value);
	}
	
	/**
	 * 将由服务器保存的消息重新设置回此Action中
	 */
	public void restoreMessages(Map<String, Object> messages) {
		this.msgs = messages;
	}
	
	/**
	 * 返回action当前需要可以flash给客户端的所有消息
	 * 
	 * @return
	 */
	public Map<String, Object> getMsgs() {
		return this.msgs;
	}
	
	public PageIndex getPageIndex(){
		if(this.pageIndex == null){
			this.pageIndex = new PageIndex();
			this.pageIndex.setPageSize(this.size);
			this.pageIndex.setCurrentPage(this.page);
		}
		return this.pageIndex;
	}
	
	public User getCurrentUser(){
		if(ActionUtil.getCurrentUserId() != null)
			return this.userService.findById((Integer)ActionUtil.getCurrentUserId());
		return null;
	}
	
	public User getAnonymousUser(){
		return this.userService.getAnonymousUser();
	}

	protected int getIntegerId() {
		if (this.id != null && Util.isNumeric(this.id))
			return Integer.valueOf(this.id);
		return -1;
	}
	
	protected int getSecondIntegerId() {
        if (this.id != null && this.id.length() > 1 && Util.isNumeric(this.id.substring(1)))
            return Integer.valueOf(this.id.substring(1));
        return -1;
    }
	
	protected String getIdPrefix() {
        if (this.id != null && this.id.length() > 1)
            return this.id.substring(0,1);
        return null;
    }
	
	public Date getCurrentDate(){
		return new Date();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getApplicationValue(String key){
		return (T) ServletActionContext.getContext().getApplication().get(key);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getPreviousUrl() {
        if(this.previousUrl == null)
            this.previousUrl = ActionUtil.getHttpRequest().getHeader("Referer");
        return previousUrl;
    }

    public void setPreviousUrl(String previousUrl) {
        this.previousUrl = previousUrl;
    }
    
    protected String redirect(){
    	ActionUtil.redirect(this.redirectUrl != null ?
    			this.redirectUrl : this.getPreviousUrl());
        return null;
    }
    
    protected String redirectTo(String url){
        ActionUtil.redirect(url);
        return null;
    }
    
    protected String forwardError(){
        ActionUtil.redirect("/404");
        return null;
    }

    public String getCurrentUrl() {
        if(this.currentUrl == null){
            this.currentUrl = ActionUtil.getHttpRequest().getRequestURL().toString();
        }
        return this.currentUrl;
    }
    
    public String getCurrentURI(){
    	if(this.currentURI == null){
    		this.currentURI = ActionUtil.getHttpRequest().getRequestURI();
    	}
    	return this.currentURI;
    }

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getContinueURL() {
		return continueURL;
	}

	public void setContinueURL(String continueURL) {
		this.continueURL = continueURL;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getCurrentTemplate() {
		return (String) ActionUtil.getHttpRequest().getAttribute("template");
	}
	
	public void setCommentEnabled(Boolean commentEnabled) {
		this.commentEnabled = commentEnabled;
	}
	
	public void setLdapEnabled(Boolean ldapEnabled) {
		this.ldapEnabled = ldapEnabled;
	}
	
	public Boolean getCommentEnabled() {
		return commentEnabled;
	}
	
	public Boolean getLdapEnabled() {
		return ldapEnabled;
	}

}
