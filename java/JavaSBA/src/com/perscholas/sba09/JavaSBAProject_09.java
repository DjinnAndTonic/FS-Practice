package com.perscholas.sba09;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JavaSBAProject_09 {
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	
	public static void main(String[] args) throws IOException {
		makeDir();
		createStudentList();	
		setStudentGrades();
		writeGradesToFile();
		displayStudents();
	}
	
	public static void makeDir() {
		File file = new File(".\\sba_student_grades");
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
	
	public static void createStudentList() throws FileNotFoundException {
		Scanner file = new Scanner(new File(".\\sba_student_grades\\students.txt"));
		
		file.nextLine();
		while(file.hasNextLine()) {
			String name = file.nextLine();
			studentList.add(new Student(name));
		}
		
		file.close();
	}
	
	public static void setStudentGrades() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter grades for each student.");
		for(int i = 0 ; i < studentList.size(); ++i) {
			System.out.print(studentList.get(i).getName() + ": ");
			double grade = scan.nextDouble();
			
			studentList.get(i).setGrade(grade);
		}
		scan.close();
	}
	
	public static void writeGradesToFile() throws IOException {
		FileWriter fw = new FileWriter(".\\sba_student_grades\\grades.txt");
		
		for(Student s : studentList) {
			fw.append(s.getName() + " :: " + s.getGrade() + "\n");
		}
		fw.append("\n");
		fw.append("Highest Score: " + getMaxGrade() + "\n");
		fw.append("Lowest Score: " + getMinGrade() + "\n");
		fw.append("Average Score: " + getAvgGrade() + "\n");
		
		fw.close();
	}
	
	public static void displayStudents() {
		System.out.println();
		for(Student s : studentList) {
			System.out.println(s);
		}
	}
	
	public static double getMaxGrade() {
		double max = Integer.MIN_VALUE;
		for(Student s : studentList) {
			if(s.getGrade() > max)
				max = s.getGrade();
		}
		
		return max;
	}
	
	public static double getMinGrade() {
		double min = Integer.MAX_VALUE;
		for(Student s : studentList) {
			if(s.getGrade() < min)
				min = s.getGrade();
		}
		
		return min;
	}
	
	public static double getAvgGrade() {
		double sum = 0;
		
		for(Student s : studentList) {
			sum += s.getGrade();
		}
		
		return sum/studentList.size();
	}
}
