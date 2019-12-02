package com.bnguyen.respository;

import com.bnguyen.models.User;

public interface UserRepository {
	void addUser(User u);
	User getUser(String username);
}
