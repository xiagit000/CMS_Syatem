package com.boventech.cms.service.node;

import java.util.List;

import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.user.User;

public interface MenuService {

	List<Menu> listOpenMenus();
	
	List<Menu> listAdminMenus();
	
	List<Menu> listUserVisiableMenus(User user, Integer parentId);
}
