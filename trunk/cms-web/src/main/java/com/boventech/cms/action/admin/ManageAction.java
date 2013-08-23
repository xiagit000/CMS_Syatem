package com.boventech.cms.action.admin;

import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.service.node.EntryService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireLogin;
import com.boventech.web.annotation.RequireRight;

@RequireLogin
@RequireRight(right = UserRight.NORMAL)
public class ManageAction extends AdminAction {

    /**
	 * 
	 */
    private static final long serialVersionUID = 437271553205996550L;

    private EntryService entryService;

    private List<Entry> latestNews;

    @Override
    public HttpHeaders create() {
        return null;
    }

    @Override
    public String destroy() {
        return null;
    }

    @Override
    public String edit() {
        return null;
    }

    @Override
    public HttpHeaders editNew() {
        return null;
    }

    @Override
    public HttpHeaders index() {
        this.latestNews = this.entryService.listLatestEntrys(LARGE_NUMBER);
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    public List<Entry> getLatestNews() {
        return latestNews;
    }

    public void setEntryService(EntryService entryService) {
        this.entryService = entryService;
    }
}
