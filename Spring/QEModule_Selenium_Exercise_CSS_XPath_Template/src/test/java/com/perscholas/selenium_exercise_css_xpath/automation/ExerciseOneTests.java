package com.perscholas.selenium_exercise_css_xpath.automation;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseOneTests {
	private static WebDriver driver;
	String actual;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Janice/Documents/"
				+ "Programming/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/QEModule_Selenium_Exercise_01/");
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	@Test
	public void titleTest() {
		
	}
}