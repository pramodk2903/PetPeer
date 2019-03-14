package com.petstore.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petstore.model.Pet;
import com.petstore.service.PetService;
import com.petstore.service.UserService;

@RestController
@RequestMapping(path = "/pets")
@CrossOrigin
public class PetController {

	Logger logger = LoggerFactory.getLogger(PetController.class);

	@Autowired
	private PetService petService;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Pet>> getPets()
	{
		logger.info("pets");
		return new ResponseEntity<List<Pet>>(petService.getPets(), HttpStatus.OK);
	}

	@GetMapping(path="/petDetail/{id}")
	public ResponseEntity<Pet> findById(@PathVariable long id){
		logger.info("pet id : " + id);
		return new ResponseEntity<Pet>(petService.findById(id), HttpStatus.FOUND);
	}

	@PostMapping(path="/addPet")
	public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
		pet = petService.savePet(pet);
		return new ResponseEntity<Pet>(pet, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/myPets")
	public ResponseEntity<Set<Pet>> getMyPets(@RequestParam("name") String username){
//		return userService.getPets(username);
		return new ResponseEntity<Set<Pet>>(petService.getPetsByUser(username), HttpStatus.OK);
	}

	
	@PostMapping(path="/buyPet/{petId}")
	public ResponseEntity<Pet> buyPet(@PathVariable long petId, @RequestParam("name") String username) {
		logger.info("petId : " + petId);
		logger.info("username : " + username);
		return new ResponseEntity<Pet>(petService.buy(petId, username), HttpStatus.OK);
	}
	
	@GetMapping("getPet/{name}")
	public ResponseEntity<List<Pet>> getPet(@PathVariable String name)
	{
		logger.info("pets : "+ name);
		return new ResponseEntity<List<Pet>>(petService.getPets(), HttpStatus.OK);
	}
}
