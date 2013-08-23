package com.boventech.cms.dao.user;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.user.User;
import com.boventech.util.user.UserRight;


public interface UserDao extends AbstractDao<User, Integer>{

	List<User> findByUsername(String username);

	List<User> findByEmail(String email);
	
	List<User> listByRight(UserRight right);
}
