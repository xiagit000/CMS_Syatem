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
public class Family implements Serializable {

	private static final long serialVersionUID = -1540209168451616560L;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FAMILY_ID")
	private Set<FamilyMember> menbers = new HashSet<FamilyMember>(5);

	public void setMenbers(Set<FamilyMember> menbers) {
		this.menbers = menbers;
	}

	public Set<FamilyMember> getMenbers() {
		return menbers;
	}

	public boolean addAllFamilyMembers(Collection<FamilyMember> familyMembers) {
		Validate.notEmpty(familyMembers, "Collection of familyMembers should not be null or empty!");
		return this.menbers.addAll(familyMembers);
	}
	
	public boolean addFamilyMenber(FamilyMember familyMember) {
		Validate.notNull(familyMember, "FamilyMember should not be null!");
		return this.menbers.add(familyMember);
	}
	
	public boolean removeFamilyMember(FamilyMember familyMember) {
		return this.menbers.remove(familyMember);
	}

}
