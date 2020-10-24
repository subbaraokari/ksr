package org.hcl.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.hcl.dao.UsersDao;
import org.hcl.dao.UsersDaoImpl;
import org.hcl.entities.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceImplTest {
	@Mock
	UsersDao dao;
	@InjectMocks
	UserService service;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this.getClass());
	}
	@Test
	void testInsertUser() {
		when(dao.insert(any(Users.class))).thenReturn(true);
		verify(dao,times(1)).insert(any(Users.class));
	}

}
