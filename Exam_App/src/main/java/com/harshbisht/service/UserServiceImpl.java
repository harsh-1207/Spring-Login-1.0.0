package com.harshbisht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harshbisht.model.UserDtls;
import com.harshbisht.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;		// for encoding the user password
	

	@Override
	public UserDtls createUser(UserDtls user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		return userRepo.save(user);				// registering the user 
	}

	@Override
	public boolean checkEmail(String email) {


		return userRepo.existsByEmail(email);
	}

}
