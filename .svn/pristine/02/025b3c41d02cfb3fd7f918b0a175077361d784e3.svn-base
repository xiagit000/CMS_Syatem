package com.boventech.cms.action.open;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.util.StringUtil;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.sql.SQLFilter;

@Results({
	@Result(name = "show", type = "dispatcher", location = "search-show.jsp"),
	@Result(name = "illagal", type = "dispatcher", location = "search-illagal.jsp")
})
public class SearchAction extends OpenAction{

	private static final int MAX_LENGTH = 100;

	private static final String OMIT = "...";

	/**
     * 
     */
    private static final long serialVersionUID = 3860136121751885408L;
    
    private static final String ILLAGAL = "illagal";

    private List<Entry> entrys;
    
    private String keyword;
    
    /*@Before(include = {"create", "show"})
    public void prepare(){
    	super.index();
    }*/
    
    @Override
    public HttpHeaders create() {
        if(!SQLFilter.isIllagal(this.keyword)){
        	String url;
        	try {
        		url = getCurrentUrl() + "/" +URLEncoder.encode(this.keyword, "UTF-8");
        		ActionUtil.redirect(url);
        	} catch (UnsupportedEncodingException e) {
        		e.printStackTrace();
        	}
        	return null;
        }else
        	return new DefaultHttpHeaders(ILLAGAL).disableCaching();
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
        return null;
    }

    @Override
    public HttpHeaders show() {
        this.keyword = this.getId();
        try {
			this.keyword = URLDecoder.decode(this.keyword, "UTF-8");
			if(!SQLFilter.isIllagal(this.keyword)){
				PageIndex pageIndex = getPageIndex();
				this.entrys = this.getEntryService().openSearch(this.keyword, pageIndex);
			}else{
				return new DefaultHttpHeaders(ILLAGAL).disableCaching();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new DefaultHttpHeaders(SHOW).disableCaching();
    }

    @Override
    public String update() {
        return null;
    }
    
    public String highlight(String info){
    	if(info != null && info.length() > 0)
    		return info.replaceAll(this.keyword, "<font style='color:red'>"+this.keyword+"</font>");
    	return info;
    }
    
    public String snapshot(String info){
    	int position = info.indexOf(this.keyword);
    	int start = 0;
    	int end = 0;
    	if(position != -1){
    		start = StringUtil.getLastStop(info, position) + 1;
    		if(position - start >= MAX_LENGTH)
    			start = position - MAX_LENGTH/2;
    		end = start + MAX_LENGTH > info.length() ? info.length() : start + MAX_LENGTH;
    	}else{
    		start = 0;
    		end = MAX_LENGTH > info.length() ? info.length() : MAX_LENGTH;
    	}
    	return highlight(info.substring(start, end)) + OMIT;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public List<Entry> getEntrys() {
		return entrys;
	}

}
