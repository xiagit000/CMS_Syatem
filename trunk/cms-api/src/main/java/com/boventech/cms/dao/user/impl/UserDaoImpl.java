package com.boventech.cms.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.cms.dao.impl.AbstractDaoImpl;
import com.boventech.cms.dao.user.UserDao;
import com.boventech.cms.module.user.User;
import com.boventech.util.user.UserRight;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, Integer> implements UserDao {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7237234254569244718L;

    private static final String USERNAME = "username";

    private static final String EMAIL = "email";

    public List<User> findByEmail(String email) {
        return listByProperty(EMAIL, email);
    }

    public List<User> findByUsername(String username) {
        return listByProperty(USERNAME, username);
    }

    public List<User> listByRight(UserRight right) {
        return listByProperty("userRight", right);
    }

}
