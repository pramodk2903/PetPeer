package com.petstore.service;

import java.util.List;
import java.util.Set;

import com.petstore.model.Pet;

public interface PetService {

	Pet findById(long id);
	
	Pet savePet(Pet pet);
	
	List<Pet> getPets();
	
	Set<Pet> getPetsByUser(String username); 
	
	Pet buy(long petId, String username);
	
	
	List<Pet> getPet(String name);
}
