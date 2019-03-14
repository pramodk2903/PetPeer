package com.petstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petstore.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
}
