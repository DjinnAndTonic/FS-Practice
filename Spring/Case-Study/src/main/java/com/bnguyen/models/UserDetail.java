package com.bnguyen.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserDetail {
	@Id
	@GeneratedValue
	private Integer userId;
	
	private String firstName, lastName, middleName;
	private String preferredName;
}
