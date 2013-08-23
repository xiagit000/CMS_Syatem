package com.boventech.cms.service.right.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.right.RoleDao;
import com.boventech.cms.module.right.Role;
import com.boventech.cms.service.right.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;
	
	public List<Role> list() {
		return this.roleDao.list();
	}

	public void delete(Role t) {
		this.roleDao.delete(t);
	}

	public Role findById(Integer id) {
		return this.roleDao.findById(id);
	}

	public void save(Role t) {
		this.roleDao.save(t);
	}

	public void update(Role t) {
		this.roleDao.update(t);
	}
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void delete(Integer id) {
		Role role = this.roleDao.findById(id);
		delete(role);
	}

}
