package com.perscholas.capitalizewords;

public class CapitalizeWords {
	public static void main(String[] args) {
		String words = "my favorite color is red!";
				
		capitalize(words);
	}
	
	public static void capitalize(String words) {
		String[] mant = words.split("\\s");
		
		for(int i = 0; i < mant.length; ++i) {
			mant[i] = mant[i].substring(0,1).toUpperCase() + mant[i].substring(1);
		}
		
		System.out.println(String.join(" ", mant));
	}
}
