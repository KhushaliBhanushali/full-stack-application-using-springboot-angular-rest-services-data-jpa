package com.springboot.admin.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springboot.admin.dao.RoleDao;
import com.springboot.admin.dao.UserDao;
import com.springboot.admin.entity.Role;
import com.springboot.admin.entity.User;
import com.springboot.admin.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	private RoleDao roleDao;

	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		super();
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	@Override
	public User loadUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User createUser(String email, String password) {
		return userDao.save(new User(email, password));
	}

	@Override
	public void assignRoleToUser(String email, String roleName) {
		User user = loadUserByEmail(email);
		Role role = roleDao.findByName(roleName);
		user.assignRoleToUser(role);
	}

}
