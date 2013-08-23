package com.boventech.cms.action.open;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.module.download.AttachAccessStrategy;
import com.boventech.cms.module.node.Entry;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.node.CommentService;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.user.UserRight;

@Results({ 
    @Result(name = "show", type = "dispatcher", location = "entry-show.jsp"),
    @Result(name = "login", type = "redirect", location = "/login")
})
public class EntryAction extends OpenAction {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7354748428525264260L;

    private Entry entry;

    private boolean accessable;

    private int commentCount;

    private CommentService commentService;

    private String page;
    
    private int totalPage;
    
    private int currentPage;
    
    private String content;
    
    private String title;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private static boolean isNumeric(String str){   
        Pattern pattern = Pattern.compile("[0-9]*");   
        return pattern.matcher(str).matches();      
    }
    
    @Override
    public HttpHeaders show() {
        super.setLinks();
        this.entry = this.getEntryService().findById(getIntegerId());
        String nextpage = "<hr style=\"page-break-after:always;\" class=\"ke-pagebreak\" />";
        
        this.content = this.entry.getContent();
        String[] contents = content.split(nextpage);
        this.totalPage = contents.length;
        if(page == null)
            page = "1";
        this.currentPage = isNumeric(page) ? Integer.parseInt(page) : 1;
        
        if(this.currentPage > this.totalPage )
            this.currentPage = this.totalPage;
        this.content = contents[currentPage-1];

        //检查新闻访问权限
        if(noRight())
            return new DefaultHttpHeaders("login").disableCaching();
        
        this.commentCount = this.commentService.count(this.entry);
        if (isPreview()) {
            this.entry = (Entry) ActionUtil.getSession(PRE_ENTRY_KEY);
            ActionUtil.removeSession(PRE_ENTRY_KEY);
        }
        if (isVisiable(this.entry)) {
            this.setMenu(getMenuById(this.entry.getBelonged().getId()));
            locateParentMenu();
            if (!isPreview()) {
                this.getEntryService().updateHits(this.entry);
            }
            this.accessable = checkAttachAccessable(this.entry, getCurrentUser());
            return new DefaultHttpHeaders(SHOW).disableCaching();
        } else {
            return new DefaultHttpHeaders("404").disableCaching();
        }
    }

    
    private boolean noRight() {
        UserRight userRight = (UserRight) ActionUtil.getSession("right");
        final int accessRight = this.entry.getAccessRight();
        final boolean userCannotReadNews = (accessRight == 1 && mustLogin(userRight, UserRight.NORMAL.getRight())) || 
                (accessRight == 2 && mustLogin(userRight, UserRight.ADMIN.getRight()));
        return userCannotReadNews;
    }

    
    


    public void downFile() throws MalformedURLException {

        HttpServletResponse response = ActionUtil.getHttpResponse();
        try {
            // path是指欲下载的文件的路径。
            /*File file = new File(path);
            String path = file.getPath();
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));*/
            InputStream fis = ServletActionContext.getServletContext().getResourceAsStream(this.content);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(this.title.getBytes("GBK"),"ISO-8859-1"));
            //response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 没有相应的阅读权限就返回登录页
     * @param userRight
     * @param right
     * @return
     */
    private boolean mustLogin(UserRight userRight, int right) {
        return userRight == null || right > userRight.getRight();
    }

    private boolean isVisiable(Entry e) {
        if (e != null) {
            return (e.isPublished() && !e.getBelonged().isLink()) || isPreview();
        }
        return false;
    }

    private boolean checkAttachAccessable(Entry e, User user) {
        AttachAccessStrategy strategy = e.getAttachmentStrategy();
        if (strategy != null)
            return strategy.canBeAccessBy(user);
        return false;
    }

    public void comment() {
        this.commentCount = this.commentService.countByEntryId(getIntegerId());
        ActionUtil.writeResponse(String.valueOf(this.commentCount));
    }

    public void hits() {
        int readCount = 0;
        Entry entry = this.getEntryService().findById(getIntegerId());
        if (entry != null)
            readCount = entry.getHits();
        ActionUtil.writeResponse(String.valueOf(readCount));
    }

    private boolean isPreview() {
        return PRE_URL_ID.equals(getId());
    }

    public Entry getEntry() {
        return entry;
    }

    public boolean isAccessable() {
        return accessable;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public String getPage() {
        return page;
    }


    public void setPage(String page) {
        this.page = page;
    }


    public int getTotalPage() {
        return totalPage;
    }


    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
