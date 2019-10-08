package com.perscholas.file;

import java.util.Arrays;

public class Question {
	private String question;
	private String[] ans;
	
	public Question() {
		question = "";
		ans = new String[4];
	}
	
	public Question(String q, String[] a) {
		question = q;
		ans = a;
	}
	
	public String toString() {
		return question + "\n" +
				ans[0] + "\n" +
				ans[1] + "\n" +
				ans[2] + "\n" +
				ans[3] + "\n";
	}
	
}
