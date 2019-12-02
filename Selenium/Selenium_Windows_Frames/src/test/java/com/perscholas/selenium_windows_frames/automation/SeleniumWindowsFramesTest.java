package com.perscholas.selenium_windows_frames.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWindowsFramesTest {	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Charlie\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	@Test
	public void javaWindowSwitchTest() {
		driver.get("http://localhost:8080/selenium_windows_frames/HomeServlet");
		// The main window's handle is saved while it is open
		String mainPage = driver.getWindowHandle();
		// Next, we click on the link to open up the pop-up window.
		driver.findElement(By.cssSelector("nav > a")).click();
		/* We need to retrieve the pop-up window's handle so we need to retrieve all 
		 * window handles and save the second value (index 1). We also need to cast 
		 * the Set to an ArrayList since sets are not indexed in java. We can't just  
		 * retrieve the window handle after the pop-up window opened because Selenium 
		 * is operating on the main window until we tell it to switch. */
		Set<String> handles = driver.getWindowHandles();
		List<String> winHandles = new ArrayList<String>(handles);
		String popUp = winHandles.get(1);
		/* The pop-up is already visible, but Selenium is still operating on the 
		 * main window. To prove this, we will run a simple test on the page title. 
		 * The following test passes. */
		String mainTitle = driver.getTitle();
		assertThat(mainTitle, equalTo("Main Window"));
		/* Now we will run the "switchTo()" method to direct Selenium to 
		 * switch focus to the pop-up. */
		driver.switchTo().window(popUp);
		String popUpTitle = driver.getTitle();
		assertThat(popUpTitle, equalTo("Pop-up Window"));
		// Next, the pop-up window is closed by clicking on the link.
		driver.findElement(By.cssSelector("body > header > a")).click();
		driver.switchTo().window(mainPage);
		/* Just as before, we must switch the focus back to the main window for 
		 * Selenium to recognize it. If we don't direct Selenium to switch to the 
		 * main window, the following statement will return a NoSuchWindowException 
		 * because the pop-up window has already been closed and Selenium wouldn't 
		 * have a current window handle. */
		// Test for the title of the main window
		mainTitle = driver.getTitle();
		assertThat(mainTitle, equalTo("Main Window"));
	}
	
	@Test
	public void iFrameSwitchTest() {
		/* This test class will attempt to retrieve the <h1> headers for each of 
		 * the three iFrames and the parent window. The assertions will not succeed 
		 * unless Selenium successfully switches to the correct frame and back to 
		 * the parent window after switching to each frame. */
		driver.get("http://localhost:8080/selenium_windows_frames/HomeServlet/frames");
		String frameHeader;
		// Switch to frame by name
		driver.switchTo().frame("frameOne");
		frameHeader = driver.findElement(By.cssSelector("h1")).getText();
		assertThat(frameHeader, equalTo("Frame 1"));
		/* It is necessary to switch back to the parent window before switching 
		 * to another frame on the page. */
		driver.switchTo().defaultContent();
		
		// Switch to frame by ID
		driver.switchTo().frame("if2");
		frameHeader = driver.findElement(By.cssSelector("h1")).getText();
		assertThat(frameHeader, equalTo("Frame 2"));
		
		// Switch to frame by index
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		frameHeader = driver.findElement(By.cssSelector("h1")).getText();
		assertThat(frameHeader, equalTo("Frame 3"));
		
		// Switch to frame by WebElement
		driver.switchTo().defaultContent();
		WebElement frameElement = driver.findElement(By.name("frameTwo"));
		driver.switchTo().frame(frameElement);
		frameHeader = driver.findElement(By.cssSelector("h1")).getText();
		assertThat(frameHeader, equalTo("Frame 2"));
		// Switch back to parent window
		driver.switchTo().defaultContent();
		String windowHeader = driver.findElement(By.cssSelector("h1")).getText();
		assertThat(windowHeader, equalTo("Selenium Windows & Frames Demonstration"));
	}
}