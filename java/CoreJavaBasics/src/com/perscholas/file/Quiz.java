package com.perscholas.file;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class Quiz {
	private static ArrayList<Question> quizList = new ArrayList<Question>();
	
	public static void main(String[] args) throws IOException {
		makeDir();
		createQuiz();
//		startQuiz();
	}
	
	public static void makeDir() {
		File file = new File(".\\quiz_answers");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        } else {
//        	System.out.println("Directory exists!");
        }
	}
	
	public static void createQuiz() {
		try {
			File file = new File("questions.txt");
			Scanner scan = new Scanner(file);
			
			String question = "";
			String[] ans = new String[4];
			
			String title = scan.nextLine();
			
			int count = 0;
			while(scan.hasNext()) {
				String tmp = scan.nextLine();
				
				if(!tmp.isEmpty()) {
					if(count == 0) {
						question = tmp;
						count++;
					}
					else if(count < 5) {
						ans[count-1] = tmp;
//						System.out.println(ans[count-1]);
						count++;
						if(count > 4) {
//							System.out.println("Array of answers: " + Arrays.toString(ans));
							count = 0;
							Question q = new Question(question, ans);
//							System.out.println("Question added:\n\"" + q + "\"");
							
							quizList.add(q);
//							System.out.println("Question to string" + q.toString());
//							System.out.println(quizList.size());
						}	
					}
				}
			}
			System.out.println("Quiz List: " + quizList.size());
			for(Question q: quizList)
				System.out.println(q);
			
			scan.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void startQuiz() throws IOException {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your name:: ");
		String name = scan.nextLine();
		
		String filename = "quiz_answers\\answers_"+name.toLowerCase()+".txt";
		String cwd = System.getProperty("user.dir");
		Path p = Paths.get(cwd + "\\" + filename);

		if(!Files.exists(p))
			Files.createFile(p);
		
		FileWriter fw = new FileWriter(".\\quiz_answers\\answers_"+name.toLowerCase()+".txt");
		
		for(int i = 0; i < quizList.size(); ++i) {
			System.out.println("Question " + (i+1) + "\n" +
						quizList.get(i));
			System.out.print("Answer choice :: ");
			String ans = scan.nextLine().trim();
			
			System.out.println();
			fw.write("Q" + (i+1) + ": " + ans + "\n");
		}
		fw.close();
		scan.close();
	}
}
