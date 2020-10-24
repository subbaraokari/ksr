package org.hcl.dao;

import org.hcl.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	SessionFactory factory;
	@Override
	public boolean insert(Users user) {
		boolean b=false;
		Session session=factory.openSession();
		Integer i=(Integer)session.save(user);
		if(i==user.getUid())
			b=true;
		session.close();
		return b;
	}

}
