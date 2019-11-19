package com.perscholas.models;

public class Vehicle {
	private int vid;
	private String make, model;
	private String[] colors;
	
	
	
	public Vehicle() {}

	public Vehicle(int vid, String make, String model, String[] colors) {
		this();
		this.vid = vid;
		this.make = make;
		this.model = model;
		this.colors = colors;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}
	
}
