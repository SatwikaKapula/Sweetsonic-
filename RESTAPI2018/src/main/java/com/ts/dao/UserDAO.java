package com.ts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Musicians;
import com.rest.dto.User;
import com.ts.db.HibernateTemplate;

public class UserDAO {
	private SessionFactory factory = null;
	
	
	
	
	public int register(User user) {		
		return HibernateTemplate.addObject(user);
	}

	public User getUser(int userId) {
		return (User)HibernateTemplate.getObject(User.class,userId);
	}


	

	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return (User)HibernateTemplate.getUserByUserPass(email, password);
		//return user ;
	}
	public List<User> getAllUser() {
		List<User> users =(List)HibernateTemplate.getObjectListByQuery("From User");
		System.out.println("Inside All Musicians ..."+users);
		return users;	
	}
	
	
	
}