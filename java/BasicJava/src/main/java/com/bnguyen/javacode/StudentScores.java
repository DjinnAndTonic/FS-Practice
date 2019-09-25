package com.bnguyen.javacode;

import java.util.Scanner;
import java.util.Random;

public class StudentScores {
	// instantiate static int array with 24 indices
	private static int[] scores = new int[24];
	
	public static void main(String[] args) {
		
		userInput();
		display();
	}
	
	public static void userInput() {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		
		System.out.println("Enter 24 scores");
		
		int incr = 0;
		
		// try-catch block for "error checking"
		try {
			do {
//				System.out.print("Score " + (incr + 1) + ": ");
//				score = scan.nextInt();
				
//				 TESTING PURPOSES
				score = new Random().nextInt(100);
				
//				check input to see if valid
				while (score > 100 || score < 0) {
					System.out.println("\nPlease enter a valid score (integer between 0 and 100).\n");
					System.out.print("Score " + (incr + 1) + ": ");
					score = scan.nextInt();
				}
				
				scores[incr] = score; 
				incr++;
				
			} while(incr < scores.length);
			
		} catch (Exception e) {
//			display error message
			System.out.println("\n!Invalid input!\nError :: " + e);
		}
		
//		close Scanner object
		scan.close();		
	}	
	
	
//	calls static method which uses bubble sort
//	to sort arr.
//	sets scores = arr.
	private static void sort(int[] arr) {
		scores = BubbleSort.bubbleSort(arr);
	}
	
	
//	static method that displays various things:
//	(1) sorted array
//	(2) min/max score
	private static void display() {
		System.out.println("\nUnsorted List of Scores: ");
		
		for(int i : scores)
			System.out.print(i + " ");
		
		System.out.println("\n\nSorted List of Scores (Ascending):");
		
		sort(scores);
		for (int i : scores)
			System.out.print(i + " ");
		
		System.out.println("\n\n\nMax Score: " + scores[23]);
		System.out.println("Min Score: " + scores[0]);
	}

}
