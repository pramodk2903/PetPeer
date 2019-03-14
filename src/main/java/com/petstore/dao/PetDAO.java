package com.petstore.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petstore.model.Pet;
import com.petstore.model.User;

@Repository
public interface PetDAO extends JpaRepository<Pet, Long> {

	Set<Pet> findByUser(User user);
	
	@Query("select p from Pet p where p.name LIKE :name")
	List<Pet> findPetsWithPartOfName(@Param("name") String name);
	
}
