package com.perscholas.arraygroups;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayGroups {
	private static Integer[][] intArrays;
	private static Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numGroups;		
		
		System.out.println("Original Array: " + Arrays.toString(arr));
		shuffle();
		System.out.println("Shuffled Array: " + Arrays.toString(arr));
		
		try {
			System.out.print("\nEnter the size of the subarrays: ");
			numGroups = scan.nextInt();
			makeGroups(numGroups);
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			scan.close();
			return;
		}
		
		scan.close();
	}
	
	public static void shuffle() {
		List<Integer> tmpList = Arrays.asList(arr);
		Collections.shuffle(tmpList);
		arr = (Integer[]) tmpList.toArray();
	}
	
	public static void makeGroups(int size) {
		int numArrays = (int) Math.ceil(arr.length / (double) size);
		
//		System.out.println("number of subarrays: " + numArrays);
		
		intArrays = new Integer[numArrays][size];
		
		for(int r = 0; r < intArrays.length; ++r) {
			intArrays[r] = Arrays.copyOfRange(arr, r*size, (r+1)*size);
		}
		
		System.out.println(Arrays.deepToString(intArrays));
	}
}
