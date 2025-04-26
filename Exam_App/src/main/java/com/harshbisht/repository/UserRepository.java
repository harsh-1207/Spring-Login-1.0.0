package com.harshbisht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshbisht.model.UserDtls;

// UserDtls -> user input database class, Integer -> primary key is id which is int

public interface UserRepository extends JpaRepository<UserDtls, Integer>{
	
	public boolean existsByEmail(String email);		// to check during register whether exists already
	
	public UserDtls findByEmail(String email);		// for checking whether email is correct or not
}
