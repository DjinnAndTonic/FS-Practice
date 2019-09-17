package com.bnguyen.javacode;


/*
 * Day 1 with Charlie:
 * Basic Java variables and info on data types.
 * How to print with System.out.println().
 * Recap on how to set up a Java project in eclipse.
 * Iterating through an array with a simple for loop.
 * 
 * */

public class Variables {
	public static void main(String[] args) {
		int[] mant = {1,2,3,4,5};
		
		for(int i = mant.length - 1; i >=0; i--) {
			System.out.print(mant[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < mant.length; i += 2) {
			System.out.print(mant[i] + " ");
		}
	}
}
