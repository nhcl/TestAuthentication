package com.hcl.testAuthentication;


import com.hcl.testAuthentication.model.User;
import com.hcl.testAuthentication.repo.UserRepository;
import com.hcl.testAuthentication.service.LoginService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;


@DataJpaTest
public class TestAuthenticationTestsRepo {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public LoginService userService() {
			return new LoginService();
		}
	}

	@Autowired
	private LoginService loginService;

    @Autowired
    private UserRepository userRepository;

    //Testing UserRepository Method findByName
    @Test
    public void whenFindByName_thenReturnUser() {
        // given

        User dummyUser = new User();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");
        userRepository.save(dummyUser);

        // when
        User found = userRepository.findByName(dummyUser.getName());

        // then

        assertEquals(found.getName(), dummyUser.getName());
    }
    
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


    public void AddAndCheckUser() {

        User dummyUser = new User();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");

        loginService.addUser(dummyUser);

        boolean authenticated = loginService.authenticateUser(dummyUser, "password");

        assertEquals(authenticated, true);

    }

    
    


}
