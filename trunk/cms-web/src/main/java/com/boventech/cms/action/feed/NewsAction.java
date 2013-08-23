package com.boventech.cms.action.feed;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;
import com.boventech.cms.action.util.ApplicationConstants;
import com.boventech.cms.action.util.ApplicationUtils;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.service.node.EntryService;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.file.XMLUtil;

public class NewsAction extends AbstractAction{

	private static final int DESC_SIZE = 300;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7128483920836404476L;
	
	private String link = "/open/entry/{0}";

	private EntryService entryService;
	
	private final String declareBegin = getText("declare_begin");
	
	private final String declareEnd = getText("declare_end");
	
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

	@SuppressWarnings("deprecation")
	@Override
	public HttpHeaders index() {
		String name = ApplicationUtils.get(ApplicationConstants.SYSTEM_NAME);
		String hostname = ApplicationUtils.get(ApplicationConstants.SYSTEM_HOSTNAME);
		String begin = declareBegin;
		if(hostname != null){
			this.link = hostname + this.link;
			begin = MessageFormat.format(begin, name, hostname);
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append(begin);
		List<Entry> entrys = this.entryService.listFeed(20);
		for(Entry entry:entrys){
			String title = entry.getTitle();
			String url = MessageFormat.format(link, String.valueOf(entry.getId()));
			String date = entry.getTimeline().toGMTString();
			String description = getDescription(entry.getPlainText(), title);
			String item = getText("rss_item",new String[]{title,url,url,date,description});
			buffer.append(item);
		}
		buffer.append(declareEnd);
		HttpServletResponse response = ActionUtil.getHttpResponse();
		response.setContentType("text/xml;charset=UTF-8");  
		try {
			response.getWriter().write(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getDescription(String plainText,String title) {
		if(plainText != null && plainText.length() > 0){
			String result = plainText.replaceAll(" ", "");
			result = result.length()> DESC_SIZE ? result.substring(0,DESC_SIZE) + "..." : result;
			return result.length() > 0 ? XMLUtil.replaceXMLReserved(result) : title;
		}
		return title;
	}

	@Override
	public HttpHeaders show() {
		return null;
	}

	@Override
	public String update() {
		return null;
	}

	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

}
