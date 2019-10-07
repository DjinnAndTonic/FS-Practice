package com.perscholas.file;

public class ClubMember {
	// NAME**CITY**STATE**FAVORITE PROGRAMMING LANGUAGE
	private String name, city, state, lang;
	
	public ClubMember() {
		name = "";
		city = "";
		state = "";
		lang = "";
	}
	
	public ClubMember(String n, String c, String s, String l) {
		name = n;
		city = c;
		state = s;
		lang = l;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String toString() {
		return "Name: " + name +
				"\nLocation: " + city + ", " + state +
				"\nFavorite Language: " + lang;
	}
}
