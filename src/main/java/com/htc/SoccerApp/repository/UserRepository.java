package com.htc.SoccerApp.repository;
import org.springframework.data.repository.CrudRepository;

import com.htc.SoccerApp.model.User;


public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUserName(String username);
}
