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
	private static int numCorrect = 0;
	
	public static void main(String[] args) throws IOException {
		makeDir();
		createQuiz();
		startQuiz();
		
		System.out.println("You got " + numCorrect + " out of 5.");
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

						count++;
						if(count > 4) {
							Question q = new Question(question, ans);
							quizList.add(q);
							count = 0;
							ans = new String[4];
						}	
					}
				}
			}
			
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
			Question currentQuestion = quizList.get(i);
			System.out.println("Question " + (i+1) + "\n" +
						currentQuestion.getQuestion() + "\n" +
						currentQuestion.getChoices());
			System.out.print("Answer choice :: ");
			String ans = scan.nextLine().trim();
			
			if(ans.charAt(0) == quizList.get(i).getCorrectAnswer())
				numCorrect++;
			
			System.out.println();
			fw.write("Q" + (i+1) + ": " + ans + "\n");
		}
		
		fw.append("Number correct: " + numCorrect);
		fw.close();
		scan.close();
	}
}
