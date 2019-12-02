package com.perscholas.css_selectors.automation;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumImplicitWaitTest {
	private static WebDriver driver;
	private static WebDriver driverAlt;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Charlie\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driverAlt = new ChromeDriver();
		/* Several WebDriver methods are chained together here to invoke an 
		 * implicit wait for 5 seconds. The web page used for this demonstration 
		 * has an intentional three-second delay for creating the <h1> page title. 
		 * The method utilizing "driver" will wait up to five seconds for the 
		 * element to be created. The second method that uses "driverAlt" will not 
		 * wait and will throw NoSuchElementException. */
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
		driverAlt.close();
	}
	/* No exception is thrown because "driver" has been set with implicit wait. */
	@Test
	public void implicitWaitTest() {
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/wait");
		driver.findElement(By.id("pageTitle"));
	}
	/* Exception is thrown because "driverAlt" has not been set with implicit wait. */
	@Test(expected = NoSuchElementException.class)
	public void noImplicitWaitTest() {
		driverAlt.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/wait");
		driverAlt.findElement(By.id("pageTitle"));
	}
}