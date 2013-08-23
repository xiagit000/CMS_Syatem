package com.boventech.cms.action.open;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.action.util.ApplicationConstants;
import com.boventech.cms.module.download.Attachment;
import com.boventech.cms.module.node.Comment;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.user.User;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.download.AttachmentService;
import com.boventech.cms.service.node.CommentService;
import com.boventech.sacwh.service.EntryCommentService;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.Before;
import com.boventech.web.annotation.RequireLogin;

@Results({ 
    @Result(name = "show", type = "dispatcher", location = "comment-show.jsp"),
    @Result(name = "no", type = "dispatcher", location = "noCommenters.jsp")
    })
public class CommentAction extends OpenAction {

    private static final long serialVersionUID = 4033204504851831629L;

    private CommentService commentService;
    
    private EntryCommentService entryCommentService;
    
    private AttachmentService attachmentService;
    
    private Integer entryId;

    private List<Comment> comments;

    private String content;

    private Entry entry;
    
    private List<User> users;

    private File[] attachments;

    private String[] attachmentFileNames;

    private String[] attachmentContentTypes;
    
    private File attachment;

    private String attachmentFileName;

    private String attachmentContentType;
    
    
    @Override
    public HttpHeaders create() {
        if (isAllowComment()) {
            Comment comment = new Comment();
            comment.setContent(this.content);
            comment.setAddTime(new Date());
            User currentUser = getCurrentUser();
            comment.setUsername(currentUser.getUsername());
            comment.setUser(currentUser);
            comment.setEntryId(this.entryId);
            comment.setIp(ActionUtil.getIpAddress());
            if(this.attachment != null){
                this.attachments = new File[]{this.attachment};
                this.attachmentFileNames = new String[]{this.attachmentFileName};
                this.attachmentContentTypes = new String[]{this.attachmentContentType};
                Attachment attachment = 
                        attachmentService.save(attachments, attachmentFileNames, attachmentContentTypes, currentUser).get(0);
                comment.setAttachment(attachment);
            }
            this.commentService.save(comment);
            addFlashMessage(getText("publishSuccess"));
            redirect();
        } else {
            return new DefaultHttpHeaders("404").disableCaching();
        }
        return null;
    }

    @RequireLogin
    public void vote() {
        if (isAllowComment()) {
            Comment comment = this.commentService.findById(getIntegerId());
            if (comment != null) {
                int number = comment.getVote() + 1;
                comment.setVote(number);
                this.commentService.update(comment);
                ActionUtil.writeResponse(String.valueOf(number));
            }
        }
    }

    @Before(include = { SHOW, CREATE })
    public void prepare() {
        super.index();
        this.entryId = getIntegerId();
    }

    @Override
    public HttpHeaders show() {
        if (isAllowComment()) {
            PageIndex pageIndex = getPageIndex();
            this.entry = this.getEntryService().findById(this.entryId);
            if (this.entry != null) {
                this.comments = this.commentService.listByEntry(this.entry, pageIndex);
                this.setId(String.valueOf(this.entryId));
                this.setMenu(getMenuById(this.entry.getBelonged().getId()));
                locateParentMenu();
                return new DefaultHttpHeaders(SHOW).disableCaching();
            }
        }
        return new DefaultHttpHeaders("404").disableCaching();
    }
    
    public String delete() {
        UserRight userRight = (UserRight) ActionUtil.getSession("right");
        if(userRight.getRight() >= UserRight.ADMIN.getRight()){
            Comment comment = this.commentService.findById(getIntegerId());
            this.commentService.delete(comment); 
        }
        return redirect();
    }

    private Boolean isAllowComment() {
        Boolean allowComment = Boolean.FALSE;
        ServletContext context = ServletActionContext.getServletContext();
        allowComment = (Boolean) context.getAttribute(ApplicationConstants.SYSTEM_ALLOW_COMMENT);
        if (allowComment == null) {
            return Boolean.FALSE;
        }
        return allowComment;
    }
    
    /**
     * 没有回复的用户
     * @return
     */
    public HttpHeaders noComment() {
        UserRight userRight = (UserRight) ActionUtil.getSession("right");
        if(userRight.getRight() >= UserRight.ADMIN.getRight()){
            this.entry = this.getEntryService().findById(getIntegerId());
            this.setMenu(getMenuById(this.entry.getBelonged().getId()));
            locateParentMenu();
            this.setUsers(this.entryCommentService.getNoCommenter(getIntegerId()));
            return new DefaultHttpHeaders("no").disableCaching(); 
        }
        return null;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public EntryCommentService getEntryCommentService() {
        return entryCommentService;
    }

    public void setEntryCommentService(EntryCommentService entryCommentService) {
        this.entryCommentService = entryCommentService;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public File[] getAttachments() {
        return attachments;
    }

    public void setAttachments(File[] attachments) {
        this.attachments = attachments;
    }

    public String[] getAttachmentFileNames() {
        return attachmentFileNames;
    }

    public void setAttachmentFileNames(String[] attachmentFileNames) {
        this.attachmentFileNames = attachmentFileNames;
    }

    public String[] getAttachmentContentTypes() {
        return attachmentContentTypes;
    }

    public void setAttachmentContentTypes(String[] attachmentContentTypes) {
        this.attachmentContentTypes = attachmentContentTypes;
    }

    public void setAttachmentService(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
    }

    public String getAttachmentContentType() {
        return attachmentContentType;
    }

    public void setAttachmentContentType(String attachmentContentType) {
        this.attachmentContentType = attachmentContentType;
    }

    
}
