package com.perscholas.model;

public class User {
	private String email, fname, password;
	
	public User() {}
	
	public User(String e, String f, String p) {
		email = e;
		fname = f;
		password = p;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", fname=" + fname + ", password=" + password + "]";
	}
	
}
