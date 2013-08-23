package com.boventech.cms.module.register;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.boventech.cms.module.Image;
import com.boventech.cms.module.register.share.DomainObjectUtils;

@javax.persistence.Entity
@Access(AccessType.FIELD)
public class Register implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private SchoolInfo schoolInfo;

	@Embedded
	private Resume resume;
	
	@Embedded
	private Family family;
	
	@Embedded
	private StudyInfo studyInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Image image;
	
	public boolean sameIdentityAs(Register other) {
		return other != null && id.equals(other.getId());
	}

	public Long getId() {
		return id;
	}

	public SchoolInfo getSchoolInfo() {
		return schoolInfo;
	}
	
	public Family getFamily() {
		return family;
	}

	public Resume getResume() {
		return DomainObjectUtils.nullSafe(this.resume, Resume.EMPTY_RESUME);
	}
	
	public StudyInfo getStudyInfo() {
		return studyInfo;
	}
	
	public Image getImage() {
		return image;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSchoolInfo(SchoolInfo schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public void setStudyInfo(StudyInfo studyInfo) {
		this.studyInfo = studyInfo;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	private static final long serialVersionUID = 1021046106107018476L;
	
}
