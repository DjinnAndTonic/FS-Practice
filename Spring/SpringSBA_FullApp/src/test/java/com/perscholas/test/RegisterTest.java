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

public class RegisterTest {
private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\Per-Scholas\\Selenium\\chromedriver.exe");
				
		driver = new ChromeDriver();
		
		//Sets the webpage that is inside the driver
		driver.get("http://localhost:8080/hibernate_validation_repository/");
	}
	
	@AfterClass
	public static void cleanUp() {
		driver.close();
	}
	
	@Test
	public void registerTest() {
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("test2");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.name("registerbtn")).click();
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Login Page"));
	}
}
