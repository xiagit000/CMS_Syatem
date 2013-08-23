package com.boventech.cms.action.open;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.node.Node;

@Results({ @Result(name = "show", type = "dispatcher", location = "menu-show.jsp") })
public class MenuAction extends OpenAction {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7053328199943869929L;

    private List<Entry> entrys;

    @Override
    public HttpHeaders show() {
        super.setLinks();
        this.setMenu(getMenuById(getIntegerId()));
        if (this.getMenu() != null) {
            if (this.getMenu().isLink()) {
                redirectTo(this.getMenu().getAddress());
            } else {
                Node node = this.getNodeService().findById(getIntegerId());
                // if(node.positionCanBeMoved()){
                this.entrys = this.getEntryService().listPublishedByNode(node, getPageIndex());
                // }else{
                // this.entrys =
                // this.getEntryService().listAllPublished(getIntegerId(),
                // getPageIndex());
                locateParentMenu();
            }
        }
        return new DefaultHttpHeaders(SHOW).disableCaching();
    }

    public List<Entry> getEntrys() {
        return entrys;
    }

}
