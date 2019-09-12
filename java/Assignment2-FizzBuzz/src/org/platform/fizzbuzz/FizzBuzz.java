package org.platform.fizzbuzz;
import static java.lang.System.out;
import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {
		out.println(fizzBuzz().toString());
	}
	
	public static ArrayList<String> fizzBuzz(){
		ArrayList<String> mant = new ArrayList<String>();
		
		for(int i = 1; i <= 100; ++i){
			String tmp = "";
			
			boolean multipleof3 = (i % 3 == 0);
			boolean multipleof5 = (i % 5 == 0);
			
			if(multipleof3) {
				tmp += "Fizz";
			}
			
			if(multipleof5) {
				tmp += "Buzz";
			}
			
			if(tmp == ""){
				tmp += Integer.toString(i);
			}
			
			mant.add(tmp);
		}
		
		return mant;
	}

}
