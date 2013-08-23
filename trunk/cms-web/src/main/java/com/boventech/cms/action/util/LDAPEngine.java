package com.boventech.cms.action.util;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.CommunicationException;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;

import com.boventech.cms.module.user.LdapSetting;

/**
 * the LDAP engine used to connect LDAP and validate LDAP users.
 * @author junxue.rao
 *
 */
public final class LDAPEngine {


	private static LdapTemplate ldapTemplate;
	
	private static LdapSetting ldapSetting = new LdapSetting();
	
	private static boolean started = false;

	private static final String URL = "ldap://{0}:{1}";
	
	private static final String DN = "{0}={1}";
	
	private static final String FULL_DN = "{0}={1},{2}";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LDAPEngine.class);
	
	private LDAPEngine(){
		
	}
	
	/**
	 * start the ldap engine
	 * @param setting
	 */
	public static void start(LdapSetting setting){
		if(setting == null){
			LOGGER.error("The LDAP is not configured, configure it before start the LDAP Engine.");
			return;
		}
		if(ldapTemplate == null){
			ldapSetting = setting;
			String url = MessageFormat.format(URL, setting.getHost(),
					String.valueOf(setting.getPort()));
			LdapContextSource contextSource = new LdapContextSource();
			contextSource.setUrl(url);
			contextSource.setBase(setting.getBaseDN());
			contextSource.setUserDn(MessageFormat.format(DN, setting.getLoginName(),
					setting.getAdmin()));
			contextSource.setPassword(setting.getPassword());
			try {
				contextSource.afterPropertiesSet();
			} catch (Exception e) {
				LOGGER.error("The LDAP engine to LDAP server("+url+") falis to start!");
			}
			ldapTemplate = new LdapTemplate(contextSource);
			started = test();
			if(!started){
				LOGGER.error("The LDAP Engine failed to start!" +
						" Check the LDAP setting before start it!");
			}
		}else{
			LOGGER.info("The LDAP engine is already running!");
		}
	}
	
	public static boolean test() {
		try{
			isExist("test");
		}
		catch (CommunicationException e) {
			return false;
		}
		return true;
	}

	/**
	 * stop the ldap engine
	 */
	public static void stop(){
		ldapTemplate = null;
		LOGGER.info("The LDAP engine is stoped!");
	}
	
	/**
	 * validate the username and password is in the LDAP server.
	 * @param username	the LDAP CN
	 * @param password	the LDAP password
	 * @return	true if the CN & password is in the LDAP server,otherwise false.
	 */
	public static boolean validate(String username, String password) {
		if(!started){
			LOGGER.info("The LDAP engine is not running, start it first.");
			return false;
		}
		boolean success = false;
		try{
			String dn = MessageFormat.format(FULL_DN, ldapSetting.getLoginName(),
					username, ldapSetting.getBaseDN());
			ldapTemplate.getContextSource().getContext(dn, password);
			success = true;
		}catch (AuthenticationException e) {
			success = false;
		}catch (CommunicationException e) {
			LOGGER.error("The LDAP setting is not right configured!");
		}
		return success;
	}
	
	/**
	 * to check is the uid is in the LDAP server
	 * @param uid	the uid to check
	 * @return		true is the uid is exist in the LDAP server,otherwise false.
	 */
	public static boolean isExist(String uid) {
		if(!started){
			LOGGER.info("The LDAP engine is not running, start it first.");
			return false;
		}
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
	
	/**
	 * whether the LDAP engine is started.
	 * @return	true if the LDAP engine is started, otherwise false.
	 */
	public static boolean isStarted() {
		return started;
	}
	
}
