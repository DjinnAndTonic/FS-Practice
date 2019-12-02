package com.perscholas.hibernate_validation_repository.repository;


import com.perscholas.hibernate_validation_repository.models.User;

public interface UserRepository {

	Integer addUser(User user);
	User findUserByUsername(User input);
	
}

