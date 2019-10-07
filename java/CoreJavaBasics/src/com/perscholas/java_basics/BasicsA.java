package com.perscholas.java_basics;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicsA {
	public static void main(String[] args) {
//		printVariableExcercise();
//		printStringExercise();
//		printBinaryExercise();
//		printFlowExercise();
//		printLoopExercise();
//		printStringExercise2();
//		printArrayExercise();
//		printRegexExercise();
	}
	
	public static void printVariableExcercise() {
		// Write a program that declares 2 integer variables, assigns an integer
				// to each and adds them together. Assign the sum to a variable. 
				// Print out the result.
				int intx = 6, inty = 3, intsum = intx + inty;
				System.out.println("sum of 2 ints (" + intx + ", " + inty +"): " + intsum);
				
				/*Write a program that declares 2 double variables, assigns a number
				 * to each and adds them together. Assign the sum to a variable. 
				 * Print out the result.*/
				double dblx = 3.2, dbly = 1.3, dblsum = dblx + dbly;
				System.out.println("sum of 2 doubles (" + dblx + ", " + dbly +"): " + dblsum);
				
				/*Write a program that declares 2 integer variables, assigns an integer
				 *to each and divides the larger number by the smaller number. Assign
				 *the result to a variable. Print out the result. Now change the larger 
				 *number to a decimal. What happens? What corrections are needed?*/
				int maxint = Math.max(intx, inty);
				int minint = Math.min(intx, inty);
				double quotient = maxint / minint;
				System.out.printf("Quotient (%d, %d): %.2f\n", maxint, minint, quotient);
				
				/*Write a program that declares 2 double variables, assigns a number to 
				 *each and divides the larger by the smaller. Assign the result to variable. 
				 *Print out the result. Now cast the result to an integer. 
				 *Print out the result again.*/
				double maxdbl = Math.max(dblx, dbly);
				double mindbl = Math.min(dblx, dbly);
				quotient = maxdbl / mindbl;
				System.out.printf("Quotient (%.2f, %.2f): %.2f\n", maxdbl, mindbl, quotient);
				System.out.println("Typecasted quotient (to int): " + (int)quotient);
				
				/*Write a program that declares 2 integer variables, x and y, and assign 5 
				 *to x and 6 to y. Declare a variable q and assign y/x to it and print q. 
				 *Now cast y to a double and assign to q. Print q again.*/
				intx = 5;
				inty = 6;
				double q = inty/intx;
				System.out.println(q);
				q = (double)inty/intx;
				System.out.println(q);
				
				/*Write a program that declares a named constant and uses it in a calculation.
				 *Print the result.*/
				final int CONST_INT = 0;
				System.out.println(inty * CONST_INT);
				
				/*Write a program where you create 3 variables that represent products at a cafe. 
				 *The products could be beverages like coffee, cappuccino, espresso, green tea, etc. 
				 *Assign prices to each product. Create 2 more variables called subtotal and totalSale 
				 *and complete an “order” for 3 items of the first product, 4 items of the second 
				 *product and 2 items of the third product. Add them all together to calculate the 
				 *subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to 
				 *obtain the totalSale amount. Be sure to format the results to 2 decimal places.*/
				double gtPrice = 3.75, cofPrice = 5.00, croisPrice = 2.75;
				double subtotal, totalSale;
				final double SALES_TAX = 0.0625;
				subtotal = 3*gtPrice + 4*cofPrice + 2*croisPrice;
				totalSale = subtotal + subtotal * SALES_TAX;
				System.out.printf("3 Green Tea: %.2f\n"
						+ "4 Coffee: %.2f\n"
						+ "2 Croissant: %.2f\n"
						+ "Subtotal: $%.2f\n"
						+ "Tax : %.2f\n"
						+ "Total Price: $%.2f", 3*gtPrice, 4*cofPrice, 2*croisPrice, subtotal, SALES_TAX*subtotal, totalSale);
	}
	
	public static void printStringExercise() {
		/*Write a program that declares 2 String variables to hold your first name 
		 *and last name. Concatenate them and print the result. Be sure to include
		 *a space between your first and last names. Use 2 different ways to 
		 *concatenate the 2 strings.*/
		String firstName = "John", lastName = "Doe";
		String fullName = firstName + " " + lastName;
		String fullName2 = firstName.concat(" " + lastName);
		System.out.println(fullName + "\n" + fullName2);
		
		/*Print out the length of your first name and your last name. Now print
		 *out the length of the 2 combined */
		System.out.printf("Length of first name: %d\n"
				+ "Length of last name: %d\n"
				+ "Length of full name (space included): %d\n",
				firstName.length(), lastName.length(), fullName.length());
		
		/*Declare 4 String variables: 1-“Hello”, 2-“Hello”, 3-“World”, 4-“world”. 
		 * Now use the String equals( ) method to test if string 1 is equal to 
		 * string 2 and if string 3 is equal to string 4. Now use the equalsIgnoreCase() 
		 * method to test if string 3 is equal to string 4. Print out the methods 
		 * and you will get true or false in the console.*/
		String s1 = "Hello", s2 = "Hello", s3 = "World", s4 = "world";
		System.out.printf("s1 == s2 :%b\n" +
						   "s1.equals(s2): %b\n" +
						   "s3 == s4 : %b \n" +
						   "s3.equalsIgnoreCase(s4): %b\n",
						   s1 == s2 , s1.equals(s2), s3 == s4, s3.equalsIgnoreCase(s4));
		
		/*Declare a String variable and assign the classic “Hello World!” 
		 * string to it. Print out the 7th character in the string using 
		 * the charAt() String method. Now use the substring( ) method to 
		 * print out the 7th character to the end of the string.*/
		String helloString = "Helo World!";
		System.out.println(helloString.charAt(7) + "\n" + helloString.substring(7));
		
		/*Write a program that utilizes the Scanner class to accept 2 integers
		 * from the user, assigns them to 2 variables, calculates the sum and 
		 * then prints it out.*/
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int x = scan.nextInt();
		System.out.print("Enter second number: ");
		int y = scan.nextInt();
		scan.close();
		System.out.println("\nSum = " + (x+y));
	}
	
	public static void printBinaryExercise() {
		/*Write the following integers in binary notation. Do not use any Java 
		 * functions or online conversion applications to calculate the answer 
		 * as this will hinder the learning process and your understanding of 
		 * the concept. However, you may check your answers using Java methods.
		 * 1, 8, 33, 78, 787, 33, 987*/
		System.out.println("Decimal to Binary\n1 : 1\n" +
				"8 : 100\n" +
				"33 : 10 0001\n" +
				"78 : 100 1110\n" +
				"787 : 11 0001 0011\n" +
				"33 : 10 0001\n" +
				"987 : 11 1101 1011\n");
		
		/*Convert the following binary numbers to decimal notation. Do not use 
		 * any Java functions or online conversion applications to calculate 
		 * the answer as this will hinder the learning process and your 
		 * understanding of the concept. However, you may check your answers 
		 * using Java methods.
		 * 0010, 1001, 0011 0100, 0111 0010, 0010 0001 1111, 0010 1100 0110 0111*/
		System.out.println("Binary to Decimal\n0010 : 2\n" +
				"1001 : 9\n" + 
				"0011 0100 : 52\n" +
				"0111 0010 : 114\n" +
				"0010 0001 1111 : 543\n" +
				"0010 1100 0110 0111 : 11367\n");
		
		/*Write a program that declares an integer a variable x and assigns 
		 * the value 2 to it and prints out the binary string version of the
		 * number ( Integer.toBinaryString(x) ). Now, use the left shift 
		 * operator (<<) to shift by 1 and assign the result to x. Before
		 * printing the results, write a comment with the predicted decimal 
		 * value and binary string. Now, print out x in decimal form and in 
		 * binary notation*/
		System.out.println("\nShift Left");
		int x = 2;
		System.out.println("2 to binary: " + Integer.toBinaryString(x));
		x = x << 1;
		// Predicted value : 4
		System.out.println("2 (shifted left once) to binary: " + Integer.toBinaryString(x) + " = " + x);
		
		x = 9;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x << 1;
		// Predicted value : 18
		System.out.println(x + " (shifted left once) to binary: " + Integer.toBinaryString(x) + " = " + x);
		
		x = 17;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x << 1;
		// Predicted value : 34
		System.out.println(x + " (shifted left once) to binary: " + Integer.toBinaryString(x) + " = " + x);
		
		x = 88;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x << 1;
		// Predicted value : 176
		System.out.println(x + " (shifted left once) to binary: " + Integer.toBinaryString(x) + " = " + x);
		
		/*Write a program that declares a variable x and assigns 150 
		 * to it and prints out the binary string version of the number. 
		 * Now use the right shift operator (>>) to shift by 2 and assign 
		 * the result to x. Write a comment indicating what you anticipate 
		 * the decimal and binary values to be. Now print the value of x 
		 * and the binary string.*/
		System.out.println("\nShift Right");
		x = 150;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x >> 2;
		// Predicted value : 37
		System.out.println(x + " (shifted right twice) to binary: " + Integer.toBinaryString(x) + " = " + x);
		
		x = 255;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x >> 2;
		// Predicted value : 63
		System.out.println(x + " (shifted right twice) to binary: " + Integer.toBinaryString(x) + " = " + x);
		
		x = 1555;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x >> 2;
		// Predicted value : 388
		System.out.println(x + " (shifted right twice) to binary: " + Integer.toBinaryString(x) + " = " + x);

		x = 32456;
		System.out.println(x +" to binary: " + Integer.toBinaryString(x));
		x = x >> 2;
		// Predicted value : 8114
		System.out.println(x + " (shifted right twice) to binary: " + Integer.toBinaryString(x) + " = " + x);

		/*Write a program that declares 3 int variables x, y, and z. 
		 * Assign 7 to x and 17 to y. Write comment that indicates 
		 * what you predict will be the result of the bitwise & 
		 * operation on x and y. Now use the bitwise & operator to 
		 * derive the decimal and binary values and assign the result to z.*/
		System.out.println("\nBitWise Operators");
		int y = 17, z;
		x = 7;
		z = x & y;
//		0001 0001
//		0000 0111
//		result : 1
		System.out.println(z);
		
		z = x | y;
//		result : 23
		System.out.println(z);
		
		/*Write a program that declares an integer variable, assigns a 
		 * number and uses a postfix increment operator to increase the 
		 * value. Print the value before and after the increment operator*/
		System.out.println("\nIncrementing");
		int tmp = 0;
		System.out.println(tmp + " " + tmp++ + " " + tmp);
		
		/*Write a program that demonstrates at least 3 ways to increment 
		 * a variable by 1 and does this multiple times. Assign a value 
		 * to an integer variable, print it, increment by 1, print it again, 
		 * increment by 1 and then print again.*/
		System.out.print(tmp + " ");
		tmp++;
		System.out.print(tmp + " ");
		tmp += 1;
		System.out.print(tmp + " ");
		++tmp;
		System.out.print(tmp + " ");
		
		/*Write a program that declares 2 integer variables, x and y, and 
		 * then assigns 5 to x and 8 to y. Create another variable sum and 
		 * assign the value of ++x added to y and print the result. Notice 
		 * the value of sum (should be 14). Now change the increment operator 
		 * to postfix (x++) and re-run the program. Notice what the value 
		 * of sum is. The first configuration incremented x and then calculated 
		 * the sum while the second configuration calculated the sum and then 
		 * incremented x.*/
		x = 5;
		y = 8;
		int sum = ++x + y;
		System.out.println("\nPrefix sum of ++5 and 8: "+ sum);
		sum = x++ + y;
		System.out.println("Postfix sum of 5++ and 8: "+ sum);
	}
	
	public static void printFlowExercise() {
		/*Write a program that declares 1 integer variable x, and then assigns 
		 * 7 to it. Write an if statement to print out “Less than 10” if x is 
		 * less than 10. Change x to equal 15 and notice the result (console 
		 * should not display anything).*/
		int x = 7;
		if(x < 10)
			System.out.println("Less than 10");
		
		System.out.println((x < 10)? "Less than 10":"Greater than 10");
		
		/*Write a program that declares 1 integer variable x, and then assigns 
		 * 15 to it. Write an “if-else-if” statement that prints out “Less 
		 * than 10” if x is less than 10, “Between 10 and 20” if x is greater 
		 * than 10 but less than 20 and “Greater than or equal to 20” if x is 
		 * greater than or equal to 20. Change x to 50 and notice the result.*/
		x = 15;
		if(x < 10)	
			System.out.println("Less than 10");
		else if (x <= 20)	
			System.out.println("Between 10 and 20");
		else
			System.out.println("Greater than or equal to 20");
		
		/*Write a program that declares 1 integer variable x, and then assigns 
		 * 15 to it. Write an if-else statement that prints “Out of range” if 
		 * the number is less than 10 or greater than 20 and prints “In range” 
		 * if between 10 and 20 (including equal to 10 or 20). Change x to 5 
		 * and notice the result.*/
		if(x < 10 || x >20)
			System.out.println("In range");
		else
			System.out.println("Out of range");
		
		System.out.println("\nLetter Grade");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a numerical grade (Between 0 and 100): ");
		int grade = scan.nextInt();
		scan.close();
		if(grade > 100 || grade < 0)
			System.out.println("Score out of range");
		else if(grade >= 90)
			System.out.println("A");
		else if(grade >= 80)
			System.out.println("B");
		else if(grade >= 70)
			System.out.println("C");
		else if(grade >= 60)
			System.out.println("D");
		else
			System.out.println("F");
		
	}
	
	public static void printLoopExercise() {
		/*Write a program that uses a for-loop to loop through 
		 * the numbers 1-10 and prints out each number.*/
		for(int i = 0; i < 11; ++i) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		/*Write a program that uses a while-loop to loop through 
		 * the numbers 0-100 in increments of 10 and prints out 
		 * each number.*/
		int count = 0;
		while(count <= 100) {
			System.out.print(count + " ");
			count += 10;
		}
		System.out.println();
		
		count = 0;
		do {
			System.out.print(count + " ");
			count++;
		} while(count < 11);
		System.out.println();
		
		/*Write a program that uses a for-loop to loop through 
		 * the numbers 1-100. Print out each number if is a multiple 
		 * of 5, but do not print out any numbers between 25 and 75. 
		 * Use the “continue” statement to accomplish this*/
		for(int i = 1; i <= 100; ++i) {
			if(i % 5 == 0)
				System.out.print(i + " ");
			else
				continue;
		}
		System.out.println();
		
		/*Write a program that uses a for-loop to loop through the 
		 * numbers 1-100. Print out each number if is a multiple of 5, 
		 * but do not print out any numbers greater than 50. Use the 
		 * “break” keyword to accomplish this.*/
		for(int i = 1; i <= 100; ++i) {
			if(i % 5 == 0)
				System.out.print(i + " ");
			if(i > 50)
				break;
		}
		System.out.println();
		
		System.out.println("\nNested Loop");
		for(int weekNum = 1; weekNum < 3; ++weekNum) {
			System.out.println("Week " + weekNum + ": ");
			for(int dayNum = 1; dayNum < 6; ++dayNum) {
				System.out.println("Day " + dayNum + ": ");
			}
		}
		
		/*Write a program that returns all the available palindromes 
		 * within 10 and 200. The following output will be produced*/
		for(int i = 10; i < 201; ++i) {
			StringBuilder revNum = new StringBuilder(Integer.toString(i)).reverse();
			if(Integer.toString(i).contentEquals(revNum))
				System.out.print(i + " ");
		}
		
		/*Write a program that prints the Fibonacci Sequence from 0 to 50. 
		 * The following output will be produced: 
		 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,*/
		System.out.println("\nFibonacci");
		for(int i = 0; i < 10; ++i) {
			System.out.print(fibo(i) + " ");
		}
		
		/*Write a program that nests a for-loop inside another. Print 
		 * out the inner and outer variable (e.g., i or j) in the inner 
		 * loop (e.g., System.out.println("Inner loop: i: " + i + ", j: " + j);)*/
		System.out.println("\n");
		for(int i = 1; i < 3; ++i) {
			for(int j = 1; j < 4; ++j)
				System.out.println("Inner loop: i: " + i + ", j: " + j);
		}
		
	}
	
	public static void printStringExercise2() {
		System.out.println("\nString Builder");
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		System.out.println(sb.append("World!"));
		System.out.println(sb.append("World"));
		System.out.println(sb.insert(5, "New"));
		System.out.println(sb.replace(5, 8, "Old"));
		System.out.println(sb.reverse());
		
		System.out.println("\nReversing a String");
		String revString = "Reverse This";
		for(int i = revString.length()-1; i >= 0; --i) {
			System.out.print(revString.charAt(i));
		}
		
		System.out.println("\nReverse Words in String");
		
		/*Write a program that uses loops without the reverse( )
		 * method to take a multi-word string and reverse each 
		 * word but keep the same word order in the string 
		 * (e.g., “Hello world!” would become “olleH !dlrow”).*/
		String[] wrds = revString.split(" ");
		for(String w : wrds) {
			for(int i = w.length()-1; i >= 0; --i) {
				System.out.print(w.charAt(i));
			}
			System.out.print(" ");
		}
	}
	
	public static void printArrayExercise() {
		int[] mant = {1,2,3};
		for(int i: mant)
			System.out.print(i + " ");
		
		/*Write a program that returns the middle element in an array. 
		 * Give the following values to the integer array: {13, 5, 7, 68, 2} 
		 * and produce the following output: 7*/
		mant = new int[] {13, 5, 7, 68, 2};
		System.out.println("\n" + mant[mant.length/2]);
		
		/*Write a program that creates an array of String type and initializes 
		 * it with the strings “red”, “green”, “blue” and “yellow”. Print out 
		 * the array length. Make a copy using the clone( ) method. Use the 
		 * Arrays.toString( ) method on the new array to verify that the original 
		 * array was copied.*/
		String[] arr = {"red", "green", "blue", "yellow"};
		System.out.println(arr.length);
		String[] arr2 = arr.clone();
		System.out.println(Arrays.toString(arr2));
		
		/*Write a program where you create an integer array with a length of 5. 
		 * Loop through the array and assign the value of the loop control 
		 * variable (e.g., i) to the corresponding index in the array.*/
		int[] intArr = new int[5];
		int[] intArr2 = new int[5];
		for(int i = 0; i < intArr.length; ++i) {
			intArr[i] = i;
			intArr2[i] = i*2;
		}
		
		for(int i = 0; i < intArr.length; ++i) {
			if(i == intArr.length/2)
				continue;
			else
				System.out.print(intArr[i] + " ");
		}
		
		System.out.println("\nSwapping Middle and First elements");
		System.out.println(Arrays.toString(intArr));
		int tmp = intArr[0];
		intArr[0] = intArr[intArr.length/2];
		intArr[intArr.length/2] = tmp;
		System.out.println(Arrays.toString(intArr));
		
		/*Write a program to sort the following int array in ascending 
		 * order: {4, 2, 9, 13, 1, 0}. Print the array in ascending 
		 * order, print the smallest and the largest element of the 
		 * array.*/
		
		int[] sortThis = {4, 2, 9, 13, 1, 0};
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < sortThis.length-1; ++i) {
				int tmp2;
				if(sortThis[i] > sortThis[i+1]) {
					tmp2 = sortThis[i];
					sortThis[i] = sortThis[i+1];
					sortThis[i+1] = tmp2;
					sorted = false;
				}
			}
		}
		System.out.println(Arrays.toString(sortThis));
		
		/*Create an array that includes an integer, 
		 * 3 strings, and 1 double. Print the array.*/
		Object[] objArr = {1, "a string", "b string", "c string", 4.9};
		System.out.println(Arrays.toString(objArr));
	}
	
	public static void printRegexExercise() {
		/*Write a program that creates a String variable and initializes it 
		 * with a phrase or series of words such as “Don’t repeat yourself”. 
		 * Use the String split( ) method to split the words into a String 
		 * array and loop through the array and print each word. Try 
		 * different characters as splitters such as 2 spaces, a comma, an 
		 * asterisk, etc.*/
		String splitMe = "Don't repeat yourself";
		for(String s : splitMe.split(" "))
			System.out.print(s + "-");
		
		String[] names = {"Doe,John", "Doe ,Jane", "Doe , James", "Doe, Joan" };
		for(String s : names) {
			String[] mant = s.replaceAll("\\s", "").split(",");
			System.out.println("First Name: " + mant[0]);
			System.out.println("Last Name : " + mant[1]);
		}
		
		/*Write a program that uses the Pattern and Matcher 
		 * classes along with a for loop to produce the following output*/
		System.out.println("\nPattern and Matcher");
		Pattern p = Pattern.compile("found");
		Matcher m;
		String[] searchFound = {"youhavefoundme", "youdidntfindme", "notinthisone", "itisfoundhere"};
		for(String s : searchFound) {
			m = p.matcher(s);
			if(m.find())
				System.out.println("I found it! " + s);
		}
		
		/*Write a program that returns the number of times the character 
		 * 'o' occurs in the string "Hello World". The following output 
		 * will be produced: 2*/
		String helloString = "Hello World";
		int oCount = 0;
		for(int i = 0; i < helloString.length(); ++i) {
			if(helloString.charAt(i) == 'o')
				oCount++;
		}
		System.out.println(oCount);
		
		/*Write a program that tests if a string represents a valid css 
		 * hexadecimal color such as “#2255aa” or “#253”*/
		String testCss = "";
		
//		System.out.println(()?);
	}
	
	static int fibo(int n) 
    { 
        int tmp = 0, x = 1, y; 
        if (n == 0) 
            return tmp; 
        for (int i = 2; i <= n; i++) 
        { 
            y = x + tmp; 
            tmp = x; 
            x = y; 
        } 
        return x; 
    } 
}
