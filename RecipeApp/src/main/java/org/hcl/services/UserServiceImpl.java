package org.hcl.services;

import javax.transaction.Transactional;

import org.hcl.dao.UsersDao;
import org.hcl.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UsersDao dao;
	@Override
	@Transactional
	public boolean insertUser(Users user) {
		boolean b=dao.insert(user);
		return b;
	}
}
