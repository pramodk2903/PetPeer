package com.petstore.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.petstore.dao.PetDAO;
import com.petstore.dao.UserDAO;
import com.petstore.exception.PetStoreCustomException;
import com.petstore.model.Pet;
import com.petstore.model.User;

@Service
public class PetServiceImpl implements PetService {
	
	Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
	
	@Autowired
	PetDAO petDAO;
	
	@Autowired
	UserDAO userDAO;

	@Override
	public Pet findById(long id) {
		Pet pet = petDAO.findById(id).orElse(null);
		if (pet == null)
			throw new PetStoreCustomException("Pet not found", HttpStatus.NOT_FOUND);
		return pet;
	}

	@Override
	public Pet savePet(Pet pet) {
		return petDAO.save(pet);
	}

	@Override
	public List<Pet> getPets() {
		return (List<Pet>)petDAO.findAll();
	}

	@Override
	public Set<Pet> getPetsByUser(String username){
		User user = userDAO.findByUsername(username);
		if (user == null)
			throw new PetStoreCustomException("Invalid User details", HttpStatus.NOT_FOUND);
		return petDAO.findByUser(user);
	}
	
	@Override
	public Pet buy(long petId, String username) {
		User user = userDAO.findByUsername(username);
		logger.info("user : "+ user);
		if (user == null)
			throw new PetStoreCustomException("Invalid User details", HttpStatus.NOT_FOUND);
		
		Pet pet = petDAO.findById(petId).get();
		logger.info("pet : "+ pet);
		if (pet == null)
			throw new PetStoreCustomException("Invalid Pet details", HttpStatus.NOT_FOUND);

		if(pet.getUser() != null) {
			throw new PetStoreCustomException("Requested pet already sold", HttpStatus.CONFLICT);
		}
		
		pet.setUser(user);
		return petDAO.save(pet);
	}

	@Override
	public List<Pet> getPet(String name) {
		logger.info("name : " + name);
		return petDAO.findPetsWithPartOfName(name);
	}

}
