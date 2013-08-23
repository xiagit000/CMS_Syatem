package com.boventech.cms.service;

import java.io.File;
import java.util.List;

import com.boventech.cms.module.Image;
import com.boventech.cms.module.user.User;
import com.boventech.cms.module.web.PageIndex;


public interface ImageService extends BasicService<Image>{

	Image saveImage(File image, String imageFileName, User currentuser);
	
	Image saveImage(File imageFile, String imageFileName, User user, int iconWidth, int iconHeight);

	File getImageFile(Integer id);
	
	List<Image> list(PageIndex pageIndex);

	File getIconFile(Integer id);

	List<Image> list();

}
