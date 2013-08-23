package com.boventech.cms.action.admin;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.ApplicationUtils;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.node.Node;
import com.boventech.cms.module.node.Order;
import com.boventech.cms.module.right.Operation;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.node.EntryService;
import com.boventech.cms.service.node.MenuService;
import com.boventech.cms.service.node.NodeService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.Before;

@Results({
	@Result(name = "list", type = "redirect", location = "/admin/node")
})
public class NodeAction extends AdminAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8919561682900826783L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NodeAction.class);

	private NodeService nodeService;
	
	private MenuService menuService;
	
	private EntryService entryService;
	
	private Integer parentId = null;
	
	private String name;
	
	private List<Node> nodes;
	
	private List<Menu> menus;
	
	private String redirectURL;
	
	private Node node;

	private int position;

	private boolean display;
	
	private boolean link;
	
	private boolean blank;

	private String address;
	
	private Node parent;
	
	private List<Order> orders;
	
	private Order order;
	
	@Before(include = {"edit","editNew"})
	public void prepare(){
		this.orders = Arrays.asList(Order.values());
	}
	
	/**
	 * update menus after the nodes are modifyed.
	 */
	public void after(){
		ServletContext context = ServletActionContext.getServletContext();
		ApplicationUtils.updateMenus(context, menuService);
	}
	
	@Override
	public HttpHeaders create() {
		Node node = new Node();
		node.setName(this.name);
		node.setLink(this.link);
		node.setDisplay(this.display);
		node.setOrders(this.order);
		if(node.isLink()){
			node.setAddress(this.address);
			node.setBlank(this.blank);
		}
		node.setPosition(this.nodeService.getPosition(this.parentId) + 1);
		if(this.parentId == null){
			this.nodeService.save(node);
		}else{
			Node parent = this.nodeService.findById(this.parentId);
			parent.addChild(node);
			this.nodeService.update(parent);
		}
		after();
		doBroadCast(EventType.ADD_NODE, node.getId());
		redirectTo(this.redirectURL);
		return null;
	}
	
	public String destroy() {
		try{
			this.nodeService.delete(getIntegerId());
			after();
			doBroadCast(EventType.DELETE_NODE, getIntegerId());
		}catch (Exception e) {
			LOGGER.info(e.getMessage());
			addFlashMessage(getText(FlashMessageConstants.BATCH_DELETE_FAILURE));
		}
		redirect();
		return null;
	}

	@Override
	public String edit() {
		this.redirectURL = getPreviousUrl();
		this.node = this.nodeService.findById(getIntegerId());
		return "edit";
	}

	@Override
	public HttpHeaders editNew() {
		this.redirectURL = getPreviousUrl();
		return new DefaultHttpHeaders(NEW).disableCaching();
	}

	@Override
	public HttpHeaders index() {
		if(this.parentId != null)
			this.parent = this.nodeService.findById(this.parentId);
		this.nodes = this.nodeService.listNodes(this.parentId);
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	@Override
	public HttpHeaders show() {
		this.node = this.nodeService.findById(getIntegerId());
		return new DefaultHttpHeaders(SHOW).disableCaching();
	}

	@Override
	public String update() {
		this.node = this.nodeService.findById(getIntegerId());
		if(this.node != null){
			this.node.setName(this.name);
			this.node.setDisplay(this.display);
			this.node.setLink(this.link);
			if(needInitPosition(this.node.getOrders(), this.order))
				this.entryService.initPosition(this.node.getId());
			this.node.setOrders(this.order);
			if(this.node.isLink()){
				this.node.setAddress(this.address);
				this.node.setBlank(this.blank);
			}
			this.nodeService.update(this.node);
			after();
			doBroadCast(EventType.UPDATE_NODE, node.getId());
			redirectTo(this.redirectURL);
		}
		return null;
	}
	
	private boolean needInitPosition(Order oldOrder, Order newOrder) {
		return !Order.MANUAL.equals(oldOrder) && Order.MANUAL.equals(newOrder);
	}

	public void up(){
		this.nodeService.shiftUp(getIntegerId(), this.parentId, this.position);
		after();
		doBroadCast(EventType.SHIFT_UP_NODE, getIntegerId());
		redirect();
		return;
	}
	
	public void down(){
		this.nodeService.shiftDown(getIntegerId(), this.parentId, this.position);
		after();
		doBroadCast(EventType.SHIFT_DOWN_NODE, getIntegerId());
		redirect();
		return;
	}
	
	public boolean isAddable(Integer parentId){
		User user = getCurrentUser();
		if(user.getUserRight().equals(UserRight.SUPERADMIN))
			return true;
		else{
			Node parent = this.nodeService.findById(parentId);
			return parent != null && parent.isAuthrized(user, Operation.EDIT_NODE);
		}
	}
	
	/**
	 * broadcast node operation events.
	 * @param type		EventType
	 * @param nodeId	the id of node
	 */
	private void doBroadCast(EventType type, Integer nodeId){
		Event event = new Event(getCurrentUser().getUsername(),
				type, nodeId, Node.class);
		EventManager.getManager().broadcastEvent(event);
	}
	
	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}
	
	public String getRedirectURL() {
		return redirectURL;
	}
	
	public Node getNode() {
		return node;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setDisplay(boolean display) {
		this.display = display;
	}
	
	public void setLink(boolean link) {
		this.link = link;
	}
	
	public void setBlank(boolean blank) {
		this.blank = blank;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Menu> getMenus() {
		return menus;
	}
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Integer getParentNodeId(){
		return this.parentId;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}
	
}
