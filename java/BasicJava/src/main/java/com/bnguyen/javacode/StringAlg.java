package com.bnguyen.javacode;

import java.util.ArrayList;
import java.util.Arrays;

public class StringAlg {
	public static void main(String[] args) {
//		Exercise 1
		String str1 = "Hello 2019 QE02!";
		
		System.out.println("Exercise 1: ");
		System.out.println(str1.substring(2,9));
		
//		Exercise 2
		String str2 = "red,green,blue;square,triangle,circle;dog,cat,bird";
		System.out.println("\n\nExercise 2: ");
		System.out.println("Method 1: ");
		System.out.println(doThis(str2).toString());
		System.out.println("\nMethod 2: ");
		doThat(str2);
		
	}
	
	public static ArrayList<String> doThis(String s) {
		ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(s.split(";")));
		
		return arrList;
	}
	
	public static void doThat(String s){
		ArrayList<String[]> arrList = new ArrayList<String[]>();
		String[] tmp = s.split(";");
		
		for(int i = 0; i < tmp.length; ++i) {
			String[] tmp2 = tmp[i].split(",");
			arrList.add(tmp2);
		}
		
		for(String[] strArr : arrList) {
			System.out.println(Arrays.toString(strArr));
		}
	}

}
