package com.perscholas.test.sba10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstructorTests {
	@Category(Daily.class)
	@Test
	public void gradeAssignmentTest() {
		System.out.println("InstructorTests gradeAssignmentTest.");
	}
	
	@Category(Weekly.class)
	@Test
	public void gradeExamTest() {
		System.out.println("InstructorTests gradeExamTest.");
	}
	
	@Category(Semester.class)
	@Test
	public void submitFinalGradesTest() {
		System.out.println("InstructorTests submitFinalGradesTest.");
	}
	
	@Category(Semester.class)
	@Test
	public void adviseStudentTest() {
		System.out.println("InstructorTests adviseStudentTest.");
	}
}
