package com.boventech.cms.action.util;

import org.apache.struts2.ServletActionContext;

import com.boventech.cms.module.web.PageIndex;
import com.boventech.util.action.ActionUtil;

/**
 * common action utility for action layer.
 * 
 * @author dony.xie
 * 
 */
public final class WebUtil {

    private static final int TEN = 10;

	private WebUtil(){
        
    }
    
    //private static Log log = LogFactory.getFactory().getInstance(WebUtil.class);

    /**
     * create one new PageIndex object according information from HttpRequest.
     * It will be stored into HttpRequest's attribute if the parameter is True,
     * otherwise just return without storing.
     * 
     * @param storable
     *            whether store pageIndex to HttpRequest's attribute.
     * @return created PageIndex object
     */
    public static PageIndex createPageIndex(int pageSize) {
        PageIndex index = new PageIndex("", ServletActionContext.getRequest().getServletPath(),
                pageSize);
        index.setCurrentPage(getCurrentPageNumber());
        ActionUtil.setAttribute(WebConstants.ATTR_KEY_PAGEINDEX, index);
        return index;
    }

    public static PageIndex createPageIndex() {
        return createPageIndex(TEN);
    }

    private static int getCurrentPageNumber() {
        String pageNum = ActionUtil.getRequestParameter(PageIndex.PAGE_NUM);
        if ((pageNum != null) && (!"".equals(pageNum))) {
            return Integer.parseInt(pageNum);
        }
        return 1;
    }
}
