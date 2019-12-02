package com.perscholas.css_selectors.automation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumInputsTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Charlie\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Selenium_CSS_Selectors/HomeServlet/formInputs");
	}
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	/* "sendKeys()" method and "Keys.TAB" and "Keys.ENTER" static methods. Note 
	 * that the "Keys" static methods won't work with operating system dialog 
	 * windows such as those used when selecting a file to upload. */
	@Test
	public void searchTest() {
		String actual;
		WebElement searchInput = driver.findElement(By.cssSelector("#pageTitle~form > input:nth-child(1"));
		searchInput.sendKeys("QEA");
		searchInput.sendKeys(Keys.TAB, Keys.ENTER);
		actual = driver.findElement(By.cssSelector("body > header > p")).getText();
		assertThat(actual, containsString("QEA"));
	}
	/* There are two steps in selecting an option from an HTML drop-down menu. First, 
	 * the <select> element is selected and then the <option> element is selected 
	 * and set as the input value. */
	
	@Test
	public void courseSelection() {
		String actual;
		// Select the <select> element
		Select courses = new Select(driver.findElement(By.name("selectCourse")));
		// Set the input value by selecting one of the option elements
		courses.selectByValue("Data Engineering");		
		driver.findElement(By.cssSelector("fieldset > form > input[type='submit']")).click();
		actual = driver.findElement(By.cssSelector("#resultsFieldset > p:nth-child(2)")).getText();
		assertThat(actual, containsString("Data Engineering"));
		courses.selectByValue("Quality Engineering & Assurance");
		driver.findElement(By.cssSelector("fieldset > form > input[type='submit']")).click();
		actual = driver.findElement(By.cssSelector("#resultsFieldset > p:nth-child(2)")).getText();
		assertThat(actual, containsString("Quality Engineering & Assurance"));	
	}
	/* Radio buttons are grouped by the "name" attribute and activated by the 
	 * "click()" method. Only one element per group can be clicked. */
	@Test
	public void courseLocation() {
		String actual;
		WebElement radioDallas = driver.findElement(By.cssSelector("input[type='radio'][value='Dallas']"));
		WebElement radioIrving = driver.findElement(By.cssSelector("input[type='radio'][value='Irving']"));
		radioDallas.click();
		assertTrue(radioDallas.isSelected() && !radioIrving.isSelected());
		radioIrving.click();
		assertTrue(!radioDallas.isSelected() && radioIrving.isSelected());
		driver.findElement(By.cssSelector("fieldset > form > input[type='submit']")).click();
		actual = driver.findElement(By.cssSelector("#resultsFieldset > p:nth-child(3)")).getText();
		assertThat(actual, containsString("Irving"));
	}
	/* Checkboxes are not grouped so any combination of elements can be checked. */
	@Test
	public void relocationPreferences() {
		WebElement checkAspen = driver.findElement(By.cssSelector("input[type='checkbox'][value='Aspen']"));
		WebElement checkHonolulu = driver.findElement(By.cssSelector("input[type='checkbox'][value='Honolulu']"));
		WebElement checkLakeTahoe = driver.findElement(By.cssSelector("input[type='checkbox'][value='Lake Tahoe']"));
		WebElement checkMiami = driver.findElement(By.cssSelector("input[type='checkbox'][value='Miami']"));

		checkAspen.click();
		checkLakeTahoe.click();
		assertTrue(checkAspen.isSelected() && checkLakeTahoe.isSelected() && 
				!checkHonolulu.isSelected() && !checkMiami.isSelected());
		checkAspen.click();
		checkLakeTahoe.click();	
		checkHonolulu.click();
		checkMiami.click();
		assertFalse(checkAspen.isSelected() && checkLakeTahoe.isSelected() && 
				!checkHonolulu.isSelected() && !checkMiami.isSelected());
		driver.findElement(By.cssSelector("fieldset > form > input[type='submit']")).click();
		
		List<WebElement> relocList = driver.findElements(By.cssSelector
				("#resultsFieldset p[style=\"margin-left: 25px;\"]"));
		List<String> elementText = relocList.stream().map(we -> we.getText())
				.collect(Collectors.toList());
		assertThat(elementText, hasItems("Honolulu", "Miami"));
	}
	/* Calendar inputs - HTML date inputs allow the user to choose a date and/or 
	 * time from a drop-down calendar. The "chooseDateAvailable()" method selects 
	 * a date input. Once this is done, providing input is similiar to text type 
	 * inputs. However, care must be taken to provide the input in the correct 
	 * date and/or time format. */
	@Test
	public void chooseDateAvailable() {
		String actual;
		WebElement availCal = driver.findElement(By.cssSelector("input[type='date']"));
		availCal.sendKeys("09152019");
		driver.findElement(By.cssSelector("fieldset > form > input[type='submit']")).click();
		actual = driver.findElement(By.cssSelector("#resultsFieldset > "
				+ "p:nth-last-child(2)")).getText();
		assertThat(actual, containsString("2019-09-15"));
	}
	/* Select file to upload - this methods demonstrates specifying the path to a 
	 * file for uploading. The upload operation can not be completed by Selenium because 
	 * it involves an operating system dialogue box which is beyond the scope of 
	 * this lesson. However, Selenium does provide a way for us to specify a file 
	 * by specifying the file path. We can then test that the file path is in place. */
	@Test
	public void chooseUpload() {
		String actual;
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\Charlie\\Documents\\JavaSnippets\\Images\\while_loop.PNG");
		driver.findElement(By.cssSelector("fieldset > form > input[type='submit']")).click();
		actual = driver.findElement(By.cssSelector("#resultsFieldset > "
				+ "p:last-child")).getText();
		assertThat(actual, containsString("while_loop.PNG"));
	}
}