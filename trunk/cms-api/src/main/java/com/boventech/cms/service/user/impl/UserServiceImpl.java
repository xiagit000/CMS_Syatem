package com.boventech.cms.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.user.UserDao;
import com.boventech.cms.module.email.EmailTemplate;
import com.boventech.cms.module.user.User;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.EmailService;
import com.boventech.util.user.UserRight;
import com.boventech.cms.service.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1829778529280241162L;
	
	private EmailService emailService;
	
	private UserDao userDao;
	
	private static final String ANONYMOUS = "anonymous";
	
	public void delete(User user) {
		this.userDao.delete(user);
	}

	public void save(User user) {
		this.userDao.save(user);
	}

	public void update(User user) {
		this.userDao.update(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getByName(String username) {
		
		if("admin".equals(username)){
			this.checkAdminUser();
		}
		
		List<User> users = this.userDao.findByUsername(username);
		User user = (users!=null&&users.size()>0)?users.get(0):null;
		
		return user;
	}
	
	

	private void checkAdminUser() {
		List<User> users = this.userDao.findByUsername("admin");
		User user = (users!=null&&users.size()>0)?users.get(0):null;
		if(user == null){
			user = new User();
			user.setUsername("admin");
	    	user.setUserRight(UserRight.SUPERADMIN);
	    	this.save(user);	
		}
		
	}

	public List<User> list(PageIndex pageIndex) {
		return this.userDao.list(pageIndex);
	}

	public User findById(Integer userId) {
		if(9999 == userId){
			User user = new User();
        	user.setId(9999);
        	user.setUserRight(UserRight.SUPERADMIN);
        	return user;
		}
		return this.userDao.findById(userId);
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void registerSuccess(User user, String subject, String content) {
		this.userDao.save(user);
		this.emailService.sendEmail(user.getEmail(), subject, content);
	}

	public void findPasswordBack(User user, EmailTemplate template) {
		this.userDao.update(user);
		this.emailService.sendEmail(user.getEmail(), template.getSubject(), template.getContent());
	}

	public void findPasswordBack(User user, String subject, String content) {
		this.userDao.update(user);
		this.emailService.sendEmail(user.getEmail(), subject, content);
	}

	public void registerSuccess(User user, EmailTemplate template) {
		this.userDao.save(user);
		this.emailService.sendEmail(user.getEmail(), template.getSubject(), template.getContent());
	}

	public User getByEmail(String email) {
		List<User> users = this.userDao.findByEmail(email);
		return (users!=null&&users.size()>0)?users.get(0):null;
	}

	public User getAnonymousUser() {
		List<User> users = this.userDao.findByUsername(ANONYMOUS);
		return (users!=null&&users.size()>0)?users.get(0):null;
	}
}
