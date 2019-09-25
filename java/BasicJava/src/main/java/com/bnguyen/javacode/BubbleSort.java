package com.bnguyen.javacode;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {9,7,3,6,2};
		int[] sortedArr = bubbleSort(arr);
		for(int i : sortedArr)
			System.out.print(i + " ");
	}
	
	
	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		
		// Bubble sort algorithm: O(n^2)
		// iterate through array twice,
		// swapping values to sort in ascending order
		for (int i = 1; i < n; ++i) {
			for(int j = n-1; j >= i; --j) {
				
				if(arr[j] < arr[j-1]) {
					// Store value for replacement
					int tmp = arr[j];
					
					// Swap values
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
		
		return arr;
	}
}
 