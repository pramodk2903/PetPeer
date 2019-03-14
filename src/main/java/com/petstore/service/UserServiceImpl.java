package com.petstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.petstore.dao.PetDAO;
import com.petstore.dao.UserDAO;
import com.petstore.exception.PetStoreCustomException;
import com.petstore.exception.UserAuthenticationException;
import com.petstore.model.User;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	PetDAO petDao;
	
	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);
		if(user == null) {
			 throw new PetStoreCustomException("User not found with given criteria", HttpStatus.NOT_FOUND);
		}
		return user;
	}
	
	@Override
	public User isAuthenticatedUser(User user) {
		user = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(user == null) {
			 throw new UserAuthenticationException();
		}
		return user;
	}

//	@Override
//	public Set<Pet> getPets(String username) {
////		return userDao.findByUsername(username).getPets();
//		return null;
//	}

//	@Override
//	public User buy(long petId, String username) {
//		Pet pet = petDao.findById(petId).get();
//		logger.info("pet : "+ pet);
//		
//		User user = userDao.findByUsername(username);
//		logger.info("user : "+ user);
//		
//		user.getPets().add(pet);
//		return userDao.save(user);
//	}

}
