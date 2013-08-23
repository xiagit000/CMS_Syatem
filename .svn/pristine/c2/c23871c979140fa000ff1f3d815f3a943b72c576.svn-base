package com.boventech.cms.action.open;

import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.action.util.WebUtil;
import com.boventech.cms.module.download.Attachment;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.download.AttachmentService;

public class DownloadAction extends OpenAction{

    /**
     * 
     */
    private static final long serialVersionUID = -1806154884533692670L;

    private AttachmentService attachmentService;
    
    private List<Attachment> attachments;
    
    @Override
    public HttpHeaders index() {
        PageIndex pageIndex = WebUtil.createPageIndex(LARGE_NUMBER);
        this.attachments = this.attachmentService.list(pageIndex);
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    public void setAttachmentService(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

}
