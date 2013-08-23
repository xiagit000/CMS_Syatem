package com.boventech.cms.service.user.impl;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.service.user.LdapService;

@Service
@Transactional
public class LdapServiceImpl implements LdapService{

	private LdapTemplate ldapTemplate;
	
	public boolean validate(String username, String password) {
		boolean success = false;
		try{
			String dn = MessageFormat.format("cn={0},dc=applerao,dc=com", username);
			ldapTemplate.getContextSource().getContext(dn, password);
			success = true;
		}catch (AuthenticationException e) {
			success = false;
		}
		return success;
	}
	
	public boolean isExist(String uid) {
		Filter filter = new EqualsFilter("cn", uid);
		List<?> results = ldapTemplate.search(DistinguishedName.EMPTY_PATH, filter.toString(), 
				new AbstractContextMapper() {
					@Override
					protected Object doMapFromContext(DirContextOperations ctx) {
						return ctx.getNameInNamespace();
					}
				});
		if(results.size() != 1){
			return false;
		}
		return true;
	}

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}
}
