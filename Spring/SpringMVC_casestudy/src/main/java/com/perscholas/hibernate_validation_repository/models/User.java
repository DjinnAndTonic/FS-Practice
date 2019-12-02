package com.perscholas.hibernate_validation_repository.models;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	@Size(min=2, max=50,  message="Username must be between 2 and 50 characters long.")
	@NotBlank(message="Username is required.")
	private String username;
	
	@Size(min=2, max=50,  message="Password must be between 2 and 50 characters long.")
	@NotBlank(message="Password is required.")
	private String password;

	public User() {
		
	}
	
	public User(Integer userId,
			@Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters long.") @NotBlank(message = "Username is required.") String username,
			@Size(min = 2, max = 50, message = "Password must be between 2 and 50 characters long.") @NotBlank(message = "Password is required.") String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
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
	
	

}

