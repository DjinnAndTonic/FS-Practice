package com.perscholas.test.sba10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StudentTests {
	@Category(Daily.class)
	@Test
	public void submitAssignmentTest() {
		System.out.println("StudentTests submitAssignmentTest.");
	}
	
	@Category(Weekly.class)
	@Test
	public void submitExamTest() {
		System.out.println("StudentTests submitExamTest.");
	}
	
	@Category(Semester.class)
	@Test
	public void joinClubTest() {
		System.out.println("StudentTests joinClubTest.");
	}
}
