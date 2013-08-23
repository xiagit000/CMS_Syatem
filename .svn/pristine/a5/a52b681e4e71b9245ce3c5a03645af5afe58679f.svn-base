package com.boventech.cms.service.register.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.register.RegisterDao;
import com.boventech.cms.module.register.Register;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.register.RegisterService;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	private static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	@Resource
	private RegisterDao registerDao;

	public Register register(final Register register) {
		this.registerDao.save(register);
		logger.info("register a new student with name " + register.getSchoolInfo().getName());
		return register;
	}
	
	public List<Register> list(final PageIndex pageIndex) {
		List<Register> registers = this.registerDao.list(pageIndex);
		return Collections.unmodifiableList(registers);
	}

	public void removeRegister(Long id) {
		Register register = this.registerDao.findById(id);
		// Could not direct use delete(id) here, because the delete(id) method use
		// SQL: 'delete from TABLE where id = ?'.
		this.registerDao.delete(register); 
	}
	
	public Register find(Long id) {
		return this.registerDao.findById(id);
	}
	
	
}
