package com.perscholas.servlets.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicsTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\Per-Scholas\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("http://localhost:8080/SeleniumBasics/HomeServlet");
		driver.get("https://perscholas.org/");
	}
	@AfterClass
	public static void shutDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
//	@Test
	public void testTitle() throws InterruptedException {
		/* The WebDriver interface includes a method for obtaining the title of a 
		 * web page. In the following test we will assert that the title of the 
		 * web page equals to an expected value. If this turns out to be true, 
		 * then the test passes. */
		String actual = driver.getTitle();
		String expected = "Hello Selenium";
		assertThat(actual, equalTo(expected));
	}
//	@Test
	public void testMessage() {
		/* The WebDriver interface also has methods to find elements on the web 
		 * page. In the following example we will locate the element by it's CSS 
		 * selector. The various ways of locating elements will be discussed 
		 * further in subsequent lessons. */
		WebElement message = driver.findElement(By.cssSelector("h1"));
		// Now we will obtain the text inside the tag with the "getText()" method.
		String actual = message.getText();
		String expected = "Hello Selenium!";
		assertThat(actual, equalTo(expected));
	}
	
//	@Test
	public void testPSSite() throws InterruptedException {
		WebElement we = driver.findElement(By.cssSelector("#main > div > div > div.container > div > h1"));
		
		String actual = we.getText();
		
		assertThat(actual, equalTo("TECHNOLOGY AT WORK"));
		Thread.sleep(250);
	}
	
//	@Test
	public void testAboutButton() {
		WebElement aboutLink = driver.findElement(By.cssSelector("#header > nav.subNav.navbar.navbar-default.affix-top > div > div.hidden-xs > ul > li:nth-child(1) > a"));
		aboutLink.click();
	}
	
	@Test
	public void inputGoogleTest() {
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("hello world");
		driver.findElement(By.name("btnK")).click();
		
		
	}
}
