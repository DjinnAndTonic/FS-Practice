package com.bnguyen.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	
	@Email
	@Size(min=2, max=50, message="Username/email must be between 2 and 50 characters.")
	@NotBlank(message="Username/email is required.")
	private String username;
	
	@NotBlank(message="Password is required.")
	private String password;
	
	private Integer role;
	
	public User() {}

	public User(Integer userId,
			@Email @Size(min = 2, max = 50, message = "Username/email must be between 2 and 50 characters.") @NotBlank(message = "Username/email is required.") String username,
			@NotBlank(message = "Password is required.") String password, Integer role) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	};
	
	
}
