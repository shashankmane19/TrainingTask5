package com.sm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sm.entity.User;
import com.sm.repository.UserRepository;

@Component
public class LoginDaoImpl {
	@Autowired
	UserRepository userRepositoryImpl;

	public void signUpUser(User user) {
		userRepositoryImpl.save(user);

	}

	public boolean signInUser(String userEmail, String userPassword) {
		boolean flag = false;

		List<User> userList = userRepositoryImpl.findAll();
		for (User user : userList) {
			if (user.getEmailId().equals(userEmail) && user.getPassword().equals(userPassword)) {
				flag = true;
			}
		}

		return flag;

	}

}
