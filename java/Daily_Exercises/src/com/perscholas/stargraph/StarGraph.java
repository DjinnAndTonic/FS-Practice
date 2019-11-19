package com.perscholas.stargraph;

import java.util.Arrays;
import java.util.Collections;

// 11-7-2019
public class StarGraph {
	public static void main(String[] args) {
		Integer[] mant = {1,7,2,4,3,2,2,2,3,4};
		
		printGraph(mant);
	}
	
	public static void printGraph(Integer[] arr) {
		int length = arr.length;
		int max = Collections.max(Arrays.asList(arr));
		
		for(int r = 0; r < length; ++r) {
			
			// prevents extra empty rows to be added to the top of the output
			if(length - r > max)
				continue;
			
			for(int c = 0; c < length; ++c) {
				// compare current position in the row (column index) with the length
				// of the array.
				// if the length - value at index 'c' is greater than or equal to the
				// current row number, print a '*'
				
				// otherwise, print a space ' '
				if(r >= length - arr[c])
					System.out.print("*");
				else
					System.out.print(" ");
				
				// added spacing in between characters for aesthetic purposes
				System.out.print(" ");
			}
			
			System.out.println();
		}
		
	}
}
