package com.perscholas.hibernate_validation_repository.repository;

import com.perscholas.hibernate_validation_repository.models.User;

public interface UserRepository {
	void addUser(User u);
	User getUser(String username);
}
