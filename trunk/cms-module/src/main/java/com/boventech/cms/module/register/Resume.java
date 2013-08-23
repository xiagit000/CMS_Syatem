package com.boventech.cms.module.register;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.commons.lang.Validate;

@Embeddable
@Access(AccessType.FIELD)
public class Resume implements Serializable {

	private static final long serialVersionUID = 6219971792610917002L;
	static final Resume EMPTY_RESUME = new Resume();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="RESUME_ID")
	private Set<Experience> experiences = new HashSet<Experience>(5);
	
	public boolean addExperiences(Experience experience) {
		Validate.notNull(experience, "Experience should not be null!");
		return this.experiences.add(experience);
	}

	public boolean addAllExperiences(Collection<Experience> experiences) {
		Validate.notEmpty(experiences, "Collection of experiences should not be null or empty!");
		return this.experiences.addAll(experiences);
	}
	
	public boolean removeExperience(Experience experience) {
		return this.experiences.remove(experience);
	}

	public Set<Experience> getExperiences() {
		return experiences;
	}
	
}
