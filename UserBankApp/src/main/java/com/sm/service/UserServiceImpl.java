package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.LoginDaoImpl;
import com.sm.entity.User;
import com.sm.repository.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	UserRepository repository;

	public void signUpUser(User user) {

		loginDaoImpl.signUpUser(user);

	}

	public boolean signInUser(String userEmail, String userPassword) {
		return loginDaoImpl.signInUser(userEmail, userPassword);
	}
	
	public List<User> getUsers(){
		List<User> users=repository.findAll();
		return users;
	}

	public User getUserbyId(long id) {
	  User user=repository.getById(id);
		return user;
	}

}
