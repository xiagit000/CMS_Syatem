package com.boventech.cms.module.register;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudyInfo implements Serializable {

	private static final long serialVersionUID = 836699249632424982L;

	private StudyType studyType;
	
	private StudyLevel studyLevel;
	
	public StudyType getStudyType() {
		return studyType;
	}

	public void setStudyType(StudyType studyType) {
		this.studyType = studyType;
	}

	public StudyLevel getStudyLevel() {
		return studyLevel;
	}

	public void setStudyLevel(StudyLevel studyLevel) {
		this.studyLevel = studyLevel;
	}

	public enum StudyType {
		CORRESPONDENCE,// 函授
		AMATEUR;//业余
		
		public String getName() {
			return this.name();
		}
	}
	
	public enum StudyLevel {
		HIGH_TO_COLLEGE, // 高升专
		COLLEGE_TO_UNIVERSITY; // 专升本
		
		public String getName() {
			return this.name();
		}
	}
}
