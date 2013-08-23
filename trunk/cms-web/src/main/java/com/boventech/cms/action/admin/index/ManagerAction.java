package com.boventech.cms.action.admin.index;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.index.Block;
import com.boventech.cms.module.node.Menu;
import com.boventech.cms.service.index.IndexService;
import com.boventech.cms.service.node.NodeService;
import com.boventech.web.annotation.Before;

@Result(name="success", type = "redirect", location = "/admin/index/manager")
public class ManagerAction extends AdminAction {

	@Resource
	private IndexService indexService;
	
	@Resource
	private NodeService nodeService;
	
	private List<Block> blocks;
	
	private List<Menu> menus;
	
	private int selNodeId;
	private int nodeSize;
	private int blockIndex; 
	
	public HttpHeaders create() {
		Block block = this.indexService.newBlock(this.selNodeId, this.nodeSize);
		doBroadCast(EventType.ADD_BLOCK, block.getId());
		return new DefaultHttpHeaders("success").disableCaching();
	}

	public String destroy() {
		Long id = Long.valueOf(getId());
		this.indexService.removeBlock(id);
		doBroadCast(EventType.REMOVE_BLOCK, id);
		return "success";
	}

	@Before(include = {"edit"})
	public void prepareMenusForEdit() {
		initializeMenus();
	}

	@Before(include = {"editNew"})
	public void prepareMenusForEditNew() {
		initializeMenus();
		this.blockIndex = this.indexService.nextIndex();
	}
	
	

	private void initializeMenus() {
		List<Menu> menus2 = this.nodeService.listMenu(false);
		setMenus(menus2);
	}

	public String edit() {
		Long id = Long.valueOf(getId());
		Block block = this.indexService.findBlock(id);
		setBlockIndex(block.getIndex());
		setNodeSize(block.getSize());
		setSelNodeId(block.getNode().getId());
		return EDIT;
	}

	public HttpHeaders editNew() {
		return new DefaultHttpHeaders(NEW).disableCaching();
	}

	public HttpHeaders index() {
		List<Block> blocks2 = this.indexService.listBlocks();
		setBlocks(blocks2);
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	public HttpHeaders show() {
		return null;
	}

	public String update() {
		Long id = Long.valueOf(getId());
		this.indexService.updateBlock(id, this.selNodeId, this.nodeSize);
		doBroadCast(EventType.UPDATE_BLOCK, id);
		return "success";
	}
	
	 /**
	 * broadcast block operation events.
	 * @param type		EventType
	 * @param blockId	the id of block
	 */
	private void doBroadCast(EventType type, Long blockId){
		Event event = new Event(getCurrentUser().getUsername(),
				type, blockId, Block.class);
		EventManager.getManager().broadcastEvent(event);
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public List<Block> getBlocks() {
		return blocks;
	}


	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public int getSelNodeId() {
		return selNodeId;
	}
	
	public void setSelNodeId(int selNodeId) {
		this.selNodeId = selNodeId;
	}

	public void setNodeSize(int nodeSize) {
		this.nodeSize = nodeSize;
	}

	public int getNodeSize() {
		return nodeSize;
	}

	public void setBlockIndex(int blockIndex) {
		this.blockIndex = blockIndex;
	}

	public int getBlockIndex() {
		return blockIndex;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3334998909059267602L;


}
