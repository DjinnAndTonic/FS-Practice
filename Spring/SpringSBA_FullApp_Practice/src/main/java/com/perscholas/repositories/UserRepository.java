package com.perscholas.repositories;

import java.util.List;

import com.perscholas.model.User;

public interface UserRepository {
	Integer createUser(User user);
	User getGetUserById(Integer id);
	List<User> getAllUser();
	Boolean updateUser(User user);
	Boolean deleteUser(Integer id);
	
}
