package com.boventech.cms.action.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AbstractAction;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.user.User;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.file.Md5Util;

@Results({ @Result(name = "toManage", location = "/admin/manage", type = "redirect"),
        @Result(name = "toMain", location = "/personal/info", type = "redirect"),
        @Result(name = "error", type = "dispatcher", location = "/templates/default/open.jsp")
})
public class LoginAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = -1747219030469392625L;

    private static final int NO_SUCH_USER = 100;

    private static final int ERROR_PASSWORD = 200;

    private static final int NOT_VALIDATED = 300;

    private static final int LOGIN_SUCCESS = 400;

    private static final int ERROR_VERIFYCODE = 500;

    private String username;

    private String password;

    private String verifyCode;

    private User user = new User();

    private int message = -1;

    private boolean noVerifyCode;

    public void setContinue(String continueURL) {
        this.setContinueURL(continueURL);
    }

    @Override
    public HttpHeaders create() {
        doLogin();
        if (LOGIN_SUCCESS == this.message){
            doBroadCast(EventType.USER_LOGIN, this.username);
        }
        if (NO_SUCH_USER == this.message){
            addFlashMessage(getText("100"));
        }
        if (ERROR_PASSWORD == this.message){
            addFlashMessage(getText("200"));
        }
        if (ERROR_VERIFYCODE == this.message){
            addFlashMessage(getText("500"));
        }
        redirect(); 
        return null;
       // return new DefaultHttpHeaders("error").disableCaching();
        /*
         * if(this.message == LOGIN_SUCCESS && !noVerifyCode){ result =
         * loginSuccessWithVerifyCode(); }else if(this.message == LOGIN_SUCCESS
         * && noVerifyCode){ redirect(); return null; }else{ result = INDEX;
         * if(this.getContinueURL() == null && noVerifyCode)
         * this.setContinueURL(getPreviousUrl()); }
         */
    }

    /**
     * broadcast user operation events.
     * 
     * @param type
     *            EventType
     * @param username
     *            the username of user
     */
    private void doBroadCast(EventType type, String username) {
        Event event = new Event(username, type, username, User.class);
        EventManager.getManager().broadcastEvent(event);
    }

    @SuppressWarnings("unused")
    private String loginSuccessWithVerifyCode() {
        if (hasContinue()) {
            redirectTo(this.getContinueURL());
            return null;
        } else {
            return toMainBoard();
        }
    }

    private String toMainBoard() {
        String result;
        switch (this.user.right()) {
        case ADMIN:
        case SUPERADMIN:
            result = "toManage";
            break;
        case NORMAL:
        default:
            result = "toMain";
            break;
        }
        return result;
    }

    private boolean hasContinue() {
        return this.getContinueURL() != null && this.getContinueURL().length() > 0;
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
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        String frame = this.getId();
        return new DefaultHttpHeaders(frame).disableCaching();
    }

    @Override
    public String update() {
        return null;
    }

    public void ajaxLogin() {
        doLogin();
        ActionUtil.writeResponse(String.valueOf(message));
    }

    public boolean isErrorCode() {
        return ERROR_VERIFYCODE == this.message;
    }

    public boolean isFailLogin() {
        return NO_SUCH_USER == this.message || ERROR_PASSWORD == this.message;
    }

    public boolean isNotValidate() {
        return NOT_VALIDATED == this.message;
    }

    private void doLogin() {
        String v = (String) ActionUtil.getSession("verifyCode");
        if(this.verifyCode == null || !this.verifyCode.equals(v)){
            message = ERROR_VERIFYCODE;
            return;
        }
        this.user = this.getUserService().getByName(this.username);
        if (this.user == null)
            message = NO_SUCH_USER;
        else if (!validatePassword())
            message = ERROR_PASSWORD;
        else if (!user.isActivated())
            message = NOT_VALIDATED;
        else {
            // if (user != null){
            message = LOGIN_SUCCESS;
            ActionUtil.storeCurrentUserID(this.user.getId());
            ActionUtil.storeCurrentUserRight(this.user.right());
        }
    }

    private boolean validatePassword() {
        // if(user.isLdapValidate()){
        // return LDAPEngine.validate(this.username, this.password);
        // }else{
        // return user.getPassword().equals(Md5Util.encodeByMd5(this.password));
        // }
        return user.getPassword().equals(Md5Util.encodeByMd5(this.password));
    }

    @Action("/user/toLogin")
    public String toLogin() {
        return "toLogin";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public boolean isNoVerifyCode() {
        return noVerifyCode;
    }

    public void setNoVerifyCode(boolean noVerifyCode) {
        this.noVerifyCode = noVerifyCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
