package com.perscholas.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.perscholas.model.User;
import com.perscholas.repositories.UserRepository;

@Repository("mariaDbUserRepository")
public class MariaDbUserRepository implements UserRepository{
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public Integer createUser(User user) {
		Integer id = -1;
		return id;
	}

	@Override
	public User getGetUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
