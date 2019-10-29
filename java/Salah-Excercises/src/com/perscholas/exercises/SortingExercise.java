package com.perscholas.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortingExercise {
	private static List<Integer> intList = new ArrayList<Integer>();
	private static int greaterThanCount = 0;
	private static int lessThanCount = 0;
	
	public static int getDiff() {
		if(intList.size() > 0)
			return intList.get(intList.size()-1) - intList.get(0);
		return -1;
	}
	
	public static void generateList() {
		Random rand = new Random();
		for(int i = 0; i < 10; ++i) {
			intList.add(new Integer(rand.nextInt(850)));
		}
		
		System.out.println("Original List:\n" + intList);
	}
	
	public static void sortList() {
		Collections.sort(intList);
		System.out.println("\nSorted List:\n" + intList);
	}
	
	public static void countLessThan(Scanner scan) {
		System.out.print("Enter a score: ");
		int score = scan.nextInt();
		
		if(!isScoreValid(score))
			return;
		
		for(int i = 0; i < intList.size(); ++i) {
			if(intList.get(i) < score)
				lessThanCount++;
			else {
				break;
			}
		}
		
		System.out.println("Number of scores less than " + score + ": " + lessThanCount);
	}
	
	public static void countGreaterThan(Scanner scan) {
		System.out.print("Enter a score: ");
		int score = scan.nextInt();
		
		if(!isScoreValid(score))
			return;
		
		for(int i = 0; i < intList.size(); ++i) {
			if(intList.get(i) > score)
				greaterThanCount++;
		}
		
		System.out.println("Number of scores greater than " + score + ": " + greaterThanCount);
	}
	
	public static void containsScore(Scanner scan) {
		System.out.print("Enter a score: ");
		int score = scan.nextInt();
		
		if(!isScoreValid(score))
			return;
		
		if(Collections.binarySearch(intList, score) >= 0)
			System.out.println(score + " is in the list.");
		else
			System.out.println(score + " is not in the list.");
	}
	
	public static void printMenu() {
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		
		while(choice != 4) {
			System.out.println("1. Check if a score exists."
					+ "\n2. Count how many scores are greater than a number."
					+ "\n3. Count how many scores are less than a number."
					+ "\n4. Quit");
			System.out.print("Selection: ");
			choice = scan.nextInt();

			switch(choice) {
				case 1:
					System.out.println("\nThe list: " + intList);
					containsScore(scan);
					break;
				case 2:
					System.out.println("\nThe list: " + intList);
					countGreaterThan(scan);
					break;
				case 3:
					System.out.println("\nThe list: " + intList);
					countLessThan(scan);
					break;
				case 4:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Invalid choice.");
					break;
			}
			System.out.println();
		}		
		
		scan.close();
	}
	
	public static boolean isScoreValid(int score) {
		if(score < 0 || score > 850) {
			System.out.println("Invalid Score!");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		generateList();
		sortList();
		System.out.println("\nMin/Max Difference: " + getDiff() + "\n");
		printMenu();
	}
}

