package com.boventech.cms.action.open.register;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.boventech.cms.action.OpenAction;
import com.boventech.cms.module.Image;
import com.boventech.cms.module.register.Experience;
import com.boventech.cms.module.register.Family;
import com.boventech.cms.module.register.FamilyMember;
import com.boventech.cms.module.register.Register;
import com.boventech.cms.module.register.Resume;
import com.boventech.cms.module.register.SchoolInfo;
import com.boventech.cms.module.register.Sex;
import com.boventech.cms.module.register.StudyInfo;
import com.boventech.cms.module.register.StudyInfo.StudyLevel;
import com.boventech.cms.module.register.StudyInfo.StudyType;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.ImageService;
import com.boventech.cms.service.register.RegisterService;

@Namespace(value = "/open")
@Results ({
	@Result(name = "preview", location = "register-prev.jsp", type = "dispatcher"),
	@Result(name = "index", location = "register.jsp", type = "dispatcher")
})
public class RegisterAction extends OpenAction  {

	private static final int REG_PIC_HEIGHT = 200;
	private static final int REG_PIC_WIDTH = 150;
	private RegisterService registerService;
	private ImageService imageService;
	
	private SchoolInfo schoolInfo;
	private List<Experience> experiences;
	private List<FamilyMember> familyMembers;
	private StudyType studyType;
	private StudyLevel studyLevel;
	private File image;
	private Image imageObj;
	private boolean regPreview;
	
	public RegisterAction() {
		this.schoolInfo = new SchoolInfo();
	}

	private static final long serialVersionUID = -6230994831564272677L;

	public HttpHeaders index() {
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	public HttpHeaders create() {
		final Resume resume = new Resume();
		resume.addAllExperiences(this.experiences);
		
		final Family family = new Family();
		family.addAllFamilyMembers(this.familyMembers);

		final StudyInfo studyInfo = new StudyInfo();
		studyInfo.setStudyLevel(this.studyLevel);
		studyInfo.setStudyType(this.studyType);
		final SchoolInfo schoolInfo2 = this.schoolInfo;
		
		if (this.image != null ) 
		{
			String imageFileName = this.image.getName();
			User user = getAnonymousUser();
			Image imageObj1 = this.imageService.saveImage(this.image,
					imageFileName, 
					user, 
					REG_PIC_WIDTH,
					REG_PIC_HEIGHT);
			this.imageObj = imageObj1;
		}
		
		if (!isRegPreview())
		{
		
			Register register = new Register();
			register.setFamily(family);
			register.setImage(this.imageObj);
			register.setResume(resume);
			register.setSchoolInfo(schoolInfo2);
			register.setStudyInfo(studyInfo);
			this.getRegisterService().register(register);
		}
		
		return new DefaultHttpHeaders("preview").disableCaching();
	}
	
	public void setSchoolInfo(SchoolInfo schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	public SchoolInfo getSchoolInfo() {
		return schoolInfo;
	}
	
	public Sex[] getSexs() {
		return Sex.values();
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public StudyType[] getStudyTypes() {
		return StudyType.values();
	}
	
	public StudyLevel[] getStudyLevels() {
		return StudyLevel.values();
	}

	public void setStudyType(StudyType studyType) {
		this.studyType = studyType;
	}

	public StudyType getStudyType() {
		return studyType;
	}

	public void setStudyLevel(StudyLevel studyLevel) {
		this.studyLevel = studyLevel;
	}

	public StudyLevel getStudyLevel() {
		return studyLevel;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getImage() {
		return image;
	}

	public void setImageObj(Image imageObj) {
		this.imageObj = imageObj;
	}

	public Image getImageObj() {
		return imageObj;
	}

	@Override
	public String destroy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders editNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders show() {
		Long id = Long.valueOf(getId());
		Register register = this.registerService.find(id);
		
		this.experiences = new ArrayList<Experience>(register.getResume().getExperiences());
		this.familyMembers = new ArrayList<FamilyMember>(register.getFamily().getMenbers());
		this.schoolInfo = register.getSchoolInfo();
		
		StudyInfo studyInfo = register.getStudyInfo();
		if (studyInfo != null) {
			this.studyLevel = studyInfo.getStudyLevel();
			this.studyType = studyInfo.getStudyType();
		}
		this.imageObj = register.getImage();
		return new DefaultHttpHeaders("preview").disableCaching();
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRegPreview(boolean regPreview) {
		this.regPreview = regPreview;
	}

	public boolean isRegPreview() {
		return regPreview;
	}
	
}
