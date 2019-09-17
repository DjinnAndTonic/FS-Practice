package com.bnguyen.basic_automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Student/Desktop/Per-Scholas/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http:Google.com");
	}
	
	@AfterClass
	public static void shutdown() {
		driver.close();
	}
	
	@Test
	public void testTitle() {
		assertThat(driver.getTitle(), equalTo("Google"));
	}
}
