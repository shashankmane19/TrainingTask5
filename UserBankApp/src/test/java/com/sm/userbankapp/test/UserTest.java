package com.sm.userbankapp.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sm.entity.User;
import com.sm.repository.UserRepository;
import com.sm.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	UserServiceImpl userServiceImpl;

	@MockBean
	UserRepository userRepository;

	@org.junit.jupiter.api.Test
	public void getUserTest() {
		when(userRepository.findAll()).thenReturn(Stream
				.of(new User(12345L, "Gopal", "Mane", "g.m@gmail.com", "ggggg", 9999999999L),
						new User(234567L, "Sandip", "Mane", "s.m@gmail.com", "sssss", 8888888888L))
				.collect(Collectors.toList()));
		assertEquals(2, userServiceImpl.getUsers().size());
	}

	@org.junit.jupiter.api.Test
	public void getUserbyIdTest() {
		long id = 1L;
		when(userRepository.getById(id))
				.thenReturn((User) Stream.of(new User(12345L, "Gopal", "Mane", "g.m@gmail.com", "ggggg", 9999999999L)));
		assertEquals(1, userServiceImpl.getUserbyId(id));
	}

}
