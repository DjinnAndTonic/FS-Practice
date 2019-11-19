package com.perscholas.model;

public class Snack {
	private String name;
	
	public Snack() {}
	
	public Snack(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
