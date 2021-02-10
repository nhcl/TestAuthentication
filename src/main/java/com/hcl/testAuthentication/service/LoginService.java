package com.hcl.testAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.testAuthentication.model.User;
import com.hcl.testAuthentication.repo.UserRepository;

@Service
public class LoginService {
	@Autowired
    private UserRepository userRepository;

    public boolean addUser(User newUser) {
        if (newUser == null) return false;
        userRepository.save(newUser);
        return true;
    }

    public User getUserByName(String name) {
        Iterable<User> users = userRepository.findAll();

        for (User user : users) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public boolean authenticateUser(User user, String enteredPassword)
    {
        return (user.getPassword().equals(enteredPassword));
    }
}
