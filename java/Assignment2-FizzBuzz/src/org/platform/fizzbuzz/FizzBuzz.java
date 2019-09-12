package org.platform.fizzbuzz;
import static java.lang.System.out;
import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {
		out.println(fizzBuzz(100));
	}
	
	private static ArrayList<String> fizzBuzz(int upperLimit){
		// Initialize ArrayList
		ArrayList<String> mant = new ArrayList<String>();
		
		for(int i = 1; i <= upperLimit; ++i){
			String tmp = "";
			
			boolean multipleof3 = (i % 3 == 0);
			boolean multipleof5 = (i % 5 == 0);
			
			//Logic to append words to tmp
			if(multipleof3) {
				tmp += "Fizz";
			}
			
			if(multipleof5) {
				tmp += "Buzz";
			}
			
			if(tmp == ""){
				tmp += Integer.toString(i);
			}
			
			//Add tmp to the ArrayList to return
			mant.add(tmp);
		}
		
		return mant;
	}

}
