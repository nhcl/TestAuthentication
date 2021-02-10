package com.hcl.testAuthentication.repo;

import com.hcl.testAuthentication.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);

}
