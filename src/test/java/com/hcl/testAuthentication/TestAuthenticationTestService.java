package com.hcl.testAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.testAuthentication.model.User;
import com.hcl.testAuthentication.repo.UserRepository;
import com.hcl.testAuthentication.service.LoginService;

//@RunWith(SpringRunner.class)
public class TestAuthenticationTestService {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public LoginService userService() {
			return new LoginService();
		}
	}

	@Autowired
	private LoginService loginService;

	@MockBean
	private UserRepository userRepository;

	@BeforeEach
	public void setUp() {
		User dummyUser = new User();
		dummyUser.setName("Dummy");
		dummyUser.setEmail("test@test.com");
		dummyUser.setPassword("password");

		Mockito.when(userRepository.findByName(dummyUser.getName())).thenReturn(dummyUser);
	}

	// Testing LoginService method GetUserByName
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "Dummy";
		User found = loginService.getUserByName(name);

		assertEquals(found.getName(), name);
	}

	// Testing LoginService method AddUser

	@Test
	public void whenAdded_thenShouldBeFound() {
		User dummyUser = new User();
		dummyUser.setName("Dummy");
		dummyUser.setEmail("test@test.com");
		dummyUser.setPassword("password");
		loginService.addUser(dummyUser);

		User found = loginService.getUserByName(dummyUser.getName());

		assertEquals(found.getName(), dummyUser.getName());
	}

}
