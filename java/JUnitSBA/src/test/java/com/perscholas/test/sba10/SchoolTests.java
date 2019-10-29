package com.perscholas.test.sba10;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SchoolTests {
	@Category(Semester.class)
	@Test
	public void addCourseTest() {
		System.out.println("SchoolTests addCourseTest.");
	}
	
	@Category(Semester.class)
	@Test
	public void registerStudentTest() {
		System.out.println("School Tests registerStudentTest.");
	}
	
	@Category(Weekly.class)
	@Test
	public void createWeeklyReportTest() {
		System.out.println("School Tests createWeeklyReportTest.");
	}
	
	@Category(Daily.class)
	@Test
	public void takeAttendanceTest() {
		System.out.println("School Tests takeAttendanceTest.");
	}
	
	@Category(Semester.class)
	@Test
	public void publishGradesTest() {
		System.out.println("School Tests publishGradesTest.");
	}
}
