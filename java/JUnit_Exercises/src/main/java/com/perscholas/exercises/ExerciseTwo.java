package com.perscholas.exercises;

import java.util.ArrayList;

public class ExerciseTwo {
	private double x, y;
	private static ArrayList<Double> dblList;
	
	public ExerciseTwo(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		dblList = new ArrayList<Double>();
	}
	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public double methodOne() {
		double result = x + y * x;
		dblList.add(result);
		return result;
	}
	
	public double methodTwo() {
		double result = x * x - y;
		dblList.add(result);
		return result;
	}
	
	public double methodThree() {
		double result = x * y - x;
		dblList.add(result);
		return result;
	}
	
	public double methodFour() {
		double result = x + y / y;
		dblList.add(result);
		return result;
	}
	
	public double methodFive() {
		double result = x * x * x;
		dblList.add(result);
		return result;
	}
	
	public ArrayList<Double> getList(){
		return dblList;
	}
}
