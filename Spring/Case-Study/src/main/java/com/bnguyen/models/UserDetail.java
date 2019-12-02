package com.bnguyen.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class UserDetail {
	@Id
	@GeneratedValue
	private Integer userId;
	
	@NotEmpty(message="Field is mandatory.")
	private String firstName, lastName, middleName, gender, 
				   address1, city, state;
	
	@Email(message="Must provide a valid email address.")
	@NotEmpty(message="Email cannot be empty.")
	private String email;
	
	private String preferredName, genderPronoun, address2;
	
	@PositiveOrZero(message="Invalid ZIP code.")
	private Integer zip;
	
//	@Past(message="Must be a date in the Past.")
//	private Date dob;
	
	public UserDetail() {}

	public UserDetail(Integer userId, 
			@NotEmpty(message = "Field is mandatory.") String firstName,
			@NotEmpty(message = "Field is mandatory.") String lastName,
			@NotEmpty(message = "Field is mandatory.") String middleName,
			@NotEmpty(message = "Field is mandatory.") String gender,
			@NotEmpty(message = "Field is mandatory.") String address1,
			@NotEmpty(message = "Field is mandatory.") String city,
			@NotEmpty(message = "Field is mandatory.") String state,
			@Email(message = "Must provide a valid email address.") @NotEmpty(message = "Email cannot be empty.") String email,
			String preferredName, String genderPronoun, String address2,
			@PositiveOrZero(message = "Invalid ZIP code.") @Size(min = 5, max = 5) Integer zip
			/*,@Past(message = "Must be a date in the Past.") Date dob*/) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.email = email;
		this.preferredName = preferredName;
		this.genderPronoun = genderPronoun;
		this.address2 = address2;
		this.zip = zip;
//		this.dob = dob;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getGenderPronoun() {
		return genderPronoun;
	}

	public void setGenderPronoun(String genderPronoun) {
		this.genderPronoun = genderPronoun;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", gender=" + gender + ", address1=" + address1 + ", city=" + city + ", state=" + state
				+ ", email=" + email + ", preferredName=" + preferredName + ", genderPronoun=" + genderPronoun
				+ ", address2=" + address2 + ", zip=" + zip +"] ";
	}
	
	
}
