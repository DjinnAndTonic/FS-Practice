package com.perscholas.servlets.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeServletTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\"
				+ "Per-Scholas\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/SeleniumBasics/HomeServlet");
//		driver.get("https://perscholas.org/");
	}
	@AfterClass
	public static void shutDown() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.close();
	}
	
	@Test
	public void testH1Text() {
		WebElement we = driver.findElement(By.cssSelector("body > h1"));
		String actual = we.getText();
		
		assertEquals(actual, "Hello World");
	}
	
	@Test
	public void testNameId() {
		WebElement we = driver.findElement(By.id("name"));
		String actual = we.getText();
		
		assertEquals("Name is not 'John Doe'", actual, "John Doe");
	}
	
	@Test
	public void testSecondP() {
		WebElement we = driver.findElement(By.cssSelector("p:nth-of-type(2)"));
		String actual = we.getText();
		
		assertEquals(actual, "John Doe");
	}
	
	@Test
	public void testGoogleLink() {
		driver.get("http://localhost:8080/SeleniumBasics/HomeServlet");
		driver.findElement(By.cssSelector("a")).click();
		String title = driver.getTitle();
		
		assertEquals(title, "Google");
	}
}
