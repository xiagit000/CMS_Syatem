package com.boventech.cms.service.user;

import java.util.List;

import com.boventech.cms.module.email.EmailTemplate;
import com.boventech.cms.module.user.User;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;

public interface UserService extends BasicService<User>{

	User getByName(String username);

	List<User> list(PageIndex pageIndex);
	
	void findPasswordBack(User user, String subject, String content);

	void findPasswordBack(User user, EmailTemplate template);

	void registerSuccess(User user, String subject, String content);

	void registerSuccess(User user, EmailTemplate template);

	User getByEmail(String email);
	
	User getAnonymousUser();

}
