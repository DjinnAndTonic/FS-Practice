package com.perscholas.css_selectors.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExplicitWaitTest {
	private static WebDriver driver;
	private static WebDriver driverAlt;
	// Create an instance of the WebDriverWait class
	private static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Charlie\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driverAlt = new ChromeDriver();
		/* Initialize the WegDriverWait class. It takes the WebDriver instance and 
		 * time in seconds as arguments. */
		wait = new WebDriverWait(driver, 10);
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
		driverAlt.close();
	}
	/* Explicit wait is applied at the method level and replaces the "findBy" 
	 * WebDriver method used for finding and selecting elements. */
	@Test
	public void explicitWaitTest() {
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/wait");
		String actual = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("pageTitle"))).getText();
		assertThat(actual, equalTo("Selenium Wait Demonstration Page"));
	}
	/* The following method attempts to locate the page title <h1> element, but it 
	 * doesn't exist until three seconds after page load so it throws an exception. */
	@Test(expected = NoSuchElementException.class)
	public void noExplicitWaitTest() {
		driverAlt.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/wait");
		String actual = driverAlt.findElement(By.id("pageTitle")).getText();
		assertThat(actual, equalTo("Selenium Wait Demonstration Page"));
	}
}