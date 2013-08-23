package com.boventech.cms.action.admin.my;

import java.io.File;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.action.util.SessionParameters;
import com.boventech.cms.event.Event;
import com.boventech.cms.event.EventManager;
import com.boventech.cms.event.EventType;
import com.boventech.cms.module.Image;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.ImageService;
import com.boventech.util.action.ActionUtil;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.Before;
import com.boventech.web.annotation.RequireRight;

@Result(name = "noChange", type = "redirect", location = "/admin/my/info")
@RequireRight(right = UserRight.NORMAL)
public class InfoAction extends AdminAction {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7919729485504148603L;

    private ImageService imageService;

    private User user;

    private String address;

    private String email;

    private String phone;

    private String appendix;

    private File image;

    private String imageFileName;

    private static final String CHANGE = "change";

    private static final String NO_CHANGE = "noChange";

    @Before(include = { INDEX, CHANGE })
    public void prepare() {
        this.user = getCurrentUser();
    }

    @Override
    public HttpHeaders create() {
        User current = getCurrentUser();
        current.setAddress(this.address);
        current.setEmail(this.email);
        current.setPhone(this.phone);
        current.setAppendix(this.appendix);
        if (this.image != null) {
            Image portrait = this.imageService.saveImage(image, imageFileName, current);
            current.setPortrait(portrait);
        }
        this.getUserService().update(current);
        addFlashMessage(getText(FlashMessageConstants.UPDATE_SUCCESS));
        doBroadCast(EventType.UPDATE_INFO, current.getId());
        redirect();
        return null;
    }

    public String change() {
        Image img = (Image) ActionUtil.getSession(SessionParameters.CURRENT_PORTRAINT);
        this.user.setPortrait(img);
        this.getUserService().update(this.user);
        return INDEX;
    }

    public String noChange() {
        Image img = (Image) ActionUtil.getSession(SessionParameters.CURRENT_PORTRAINT);
        ActionUtil.removeSession(SessionParameters.CURRENT_PORTRAINT);
        this.imageService.delete(img);
        return NO_CHANGE;
    }

    /**
     * broadcast user operation events.
     * 
     * @param type
     *            EventType
     * @param userId
     *            the id of user
     */
    private void doBroadCast(EventType type, Integer userId) {
        Event event = new Event(getCurrentUser().getUsername(), type, userId, User.class);
        EventManager.getManager().broadcastEvent(event);
    }

    @Override
    public String destroy() {
        return null;
    }

    @Override
    public String edit() {
        return EDIT;
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
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

}
