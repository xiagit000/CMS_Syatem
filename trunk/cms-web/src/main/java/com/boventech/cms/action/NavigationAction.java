package com.boventech.cms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

@Results({
	@Result(name = "index", type = "redirect", location = "/open")
})
public class NavigationAction extends AbstractAction {

    /**
	 * 
	 */
    private static final long serialVersionUID = 6392943781989541087L;

    private String param;
    
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

    @Actions( {
        @Action("/toLogin")
    })
    @Override
    public HttpHeaders index() {
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        String result = this.getId();
        return new DefaultHttpHeaders(result).disableCaching();
    }

    @Override
    public String update() {
        return null;
    }
    
    public String getParam() {
		return param;
	}

}
