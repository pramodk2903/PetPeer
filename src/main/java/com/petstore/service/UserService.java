package com.petstore.service;

import java.util.Set;

import com.petstore.model.Pet;
import com.petstore.model.User;

public interface UserService {

	User save(User user);
	
	User findByUsername(String username);
	
	User isAuthenticatedUser(User user);
	
//	Set<Pet> getPets(String username);
	
//	User buy(long petId, String username);
	
}
