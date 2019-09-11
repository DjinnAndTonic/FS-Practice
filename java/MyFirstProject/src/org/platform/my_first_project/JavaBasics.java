package org.platform.my_first_project;
import static java.lang.System.out;

public class JavaBasics {
	public static void main(String[] args) {
		out.println("Hello world\n");
		
		out.printf("An integer: %d\n", 5);
		out.printf("A float (rounded 2 decimal spaces): %.2f\n", 3.14159269);
		out.printf("A string %s followed by an int %d.\n\n", "Hello", 5);
		
		//Even number
		out.print("Even numbers between 0 and 10 :: ");
		for(int i = 0; i <= 10; ++i) {
			System.out.print((i % 2 == 0)? i + " " : "");
		}
	}

}
