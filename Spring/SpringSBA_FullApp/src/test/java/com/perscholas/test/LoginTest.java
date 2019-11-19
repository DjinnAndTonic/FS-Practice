package com.perscholas.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\Per-Scholas\\Selenium\\chromedriver.exe");
				
		driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/hibernate_validation_repository/");
	}
	
	@AfterClass
	public static void cleanUp() {
		driver.close();
	}
	
	@Test
	public void loginTest() {
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("test");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.cssSelector("td:nth-child(1) > input")).click();
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Ads"));
	}
}
