package com.boventech.cms.action.admin.info;

import java.io.File;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.AdminAction;
import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.module.Image;
import com.boventech.cms.module.open.FriendlyLink;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.service.ImageService;
import com.boventech.cms.service.open.FriendlyLinkService;
import com.boventech.cms.service.open.FriendlyLinkTypeService;
import com.boventech.web.annotation.Before;

@Results({
	@Result(name = "list", type = "redirect", location = "/admin/info/friendly-link", params = {"typeId","${typeId}"})
})
public class FriendlyLinkAction extends AdminAction{

    /**
     * 
     */
    private static final long serialVersionUID = 6810909975097091544L;
    
    private FriendlyLinkService friendlyLinkService;
    
    private FriendlyLinkTypeService friendlyLinkTypeService;
    
    private List<FriendlyLink> links;
    
    private String linkName;
    
    private String linkHref;
    
    private Integer linkId;
    
    private String[] selectLink;
    
    private FriendlyLink currentLink;
    
    private Integer typeId;
    
	private File image;

    private String imageFileName;

    private ImageService imageService;
    
    private List<FriendlyLinkType> types;
    
    private static final int ICON_WIDTH = 100;
	
	private static final int ICON_HEIGHT = 50;
    
    public List<FriendlyLinkType> getTypes(){
    	return this.types;
    }
    
    @Before(include = {EDIT, UPDATE})
    public void prepare(){
        this.linkId = getIntegerId();
        this.currentLink = this.friendlyLinkService.findById(this.linkId);
        if(this.currentLink == null)
            forwardError();
    }
    
    @Before(include = {EDIT, EDITNEW, INDEX})
    public void initTypes(){
    	this.types = this.friendlyLinkTypeService.listByPosition(false);
    }
    
    public String delete(){
        this.linkId = getIntegerId();
        if(this.linkId < 0 && SELECTED.equals(this.getId())){
            this.friendlyLinkService.deleteSelected(selectLink);
        }else{
            FriendlyLink friendlyLink = this.friendlyLinkService.findById(this.linkId);
            this.friendlyLinkService.delete(friendlyLink);
            this.friendlyLinkService.cleanPosition(friendlyLink.getType());
        }
        return redirect();
    }
    
    public String shiftUp(){
        this.linkId = getIntegerId();
        FriendlyLink upLink = this.friendlyLinkService.findById(linkId);
        if(upLink != null){
            FriendlyLink downLink = this.friendlyLinkService.getByTypeAndPosition(upLink.getType(), upLink.getPosition() - 1);
            if(downLink != null){
                shift(downLink, upLink);
            }
        }
        return redirect();
    }
    
    public String shiftDown(){
        this.linkId = getIntegerId();
        FriendlyLink downLink = this.friendlyLinkService.findById(linkId);
        if(downLink != null){
            FriendlyLink upLink = this.friendlyLinkService.getByTypeAndPosition(downLink.getType(), downLink.getPosition() + 1);
            if(upLink != null){
                shift(downLink, upLink);
            }
        }
        return redirect();
    }

    private void shift(FriendlyLink downLink, FriendlyLink upLink) {
        downLink.setPosition(upLink.getPosition());
        this.friendlyLinkService.update(downLink);
        upLink.setPosition(upLink.getPosition() - 1);
        this.friendlyLinkService.update(upLink);
    }

    @Override
    public HttpHeaders create() {
    	FriendlyLinkType type = this.friendlyLinkTypeService.findById(this.typeId);
        FriendlyLink friendlyLink = new FriendlyLink();
        friendlyLink.setName(this.linkName);
        friendlyLink.setLink(this.linkHref);
        int count = this.friendlyLinkService.count(type);
        friendlyLink.setPosition(count + 1);
        friendlyLink.setType(type);
        if (this.image != null) {
            Image currentImage = this.imageService.saveImage(this.image, this.imageFileName, 
                    getCurrentUser(), ICON_WIDTH, ICON_HEIGHT);
            friendlyLink.setImage(currentImage);
        }
        this.friendlyLinkService.save(friendlyLink);
        return new DefaultHttpHeaders(LIST).disableCaching();
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
        return new DefaultHttpHeaders(NEW).disableCaching();
    }

    @Override
    public HttpHeaders index() {
    	FriendlyLinkType type = getDefaultType();
    	if(type != null){
    		this.links = this.friendlyLinkService.listByTypeAndPosition(type, false);
    	}else{
    		addFlashMessage(getText(FlashMessageConstants.NO_FRIENDY_TYPE));
    	}
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }

    @Override
    public HttpHeaders show() {
        return null;
    }

    @Override
    public String update() {
    	FriendlyLinkType type = this.friendlyLinkTypeService.findById(this.typeId);
        this.currentLink.setName(this.linkName);
        this.currentLink.setLink(this.linkHref);
        if(!type.equals(currentLink.getType())){
        	currentLink.setPosition(this.friendlyLinkService.count(type)+1);
        	currentLink.setType(type);
        }
        if (this.image != null) {
            Image currentImage = this.imageService.saveImage(this.image, this.imageFileName, 
                    getCurrentUser(), ICON_WIDTH, ICON_HEIGHT);
            this.currentLink.setImage(currentImage);
        }
        this.friendlyLinkService.update(this.currentLink);
        return LIST;
    }

    public List<FriendlyLink> getLinks() {
        return links;
    }

    public void setFriendlyLinkService(FriendlyLinkService friendlyLinkService) {
        this.friendlyLinkService = friendlyLinkService;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkHref() {
        return linkHref;
    }

    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
    }

    public void setSelectLink(String[] selectLink) {
        this.selectLink = selectLink;
    }

    public FriendlyLink getCurrentLink() {
        return currentLink;
    }

    public void setCurrentLink(FriendlyLink currentLink) {
        this.currentLink = currentLink;
    }
    
    public void setFriendlyLinkTypeService(
			FriendlyLinkTypeService friendlyLinkTypeService) {
		this.friendlyLinkTypeService = friendlyLinkTypeService;
	}
    
    public FriendlyLinkType getDefaultType() {
    	if(this.typeId == null){
    		List<FriendlyLinkType> types = this.friendlyLinkTypeService.listByPosition(false);
    		return types != null && types.size() > 0 ? types.get(0) : null;
    	}else
    		return this.friendlyLinkTypeService.findById(typeId);
	}
    
    public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
    
    public void setImage(File image) {
		this.image = image;
	}
    
    public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
    
    public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
    
    public Integer getTypeId() {
		return typeId;
	}

}
