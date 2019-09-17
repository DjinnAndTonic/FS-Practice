package com.bnguyen.javacode;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {9,7,3,6,2};
		for(int i : bubbleSort(arr))
			System.out.print(i + " ");
	}
	
	
	public static int[] bubbleSort(int[] arr) {
		
		int n = arr.length;
		
		for (int i = 1; i < n; ++i) {
			for(int j = n-1; j >= i; --j) {
				
				if(arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
		
		return arr;
	}
}
 