package seleniumTest.webDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriver_createIssueIT implements Selectors, URL {
	protected WebDriver driver;

	protected abstract void initializeWebDriver();

	@Before
	public void setUp() throws Exception {
		initializeWebDriver();
		driver.get(url);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

//	@Test
//	public void createAnIssue() throws Exception {
//		// create an new Issue
//		Thread.sleep(500);
//		driver.findElement(By.id(button_issueErstellen)).click();
//		Thread.sleep(500);
//		driver.findElement(By.id(radioButton_createIssueNewIssue)).click();
//		// fill name and description
//		Thread.sleep(500);
//		driver.findElement(By.id(eingabefeld_createIssueName)).sendKeys(
//				"createAnIssueTest");
//		driver.findElement(By.id(eingabefeld_createIssueDescription)).sendKeys(
//				"RT");
//		;
//		Thread.sleep(500);
//		// select every type
//		Select filterTyp = new Select(driver.findElement(By
//				.id(checkbox_filterIssueTyp)));
//		// filterTyp.deselectAll();
//		filterTyp.selectByVisibleText("Bug");
//		filterTyp.selectByVisibleText("Improvement");
//		filterTyp.selectByVisibleText("Task");
//		// save the issue
//		driver.findElement(By.id(button_createIssueSaveNewIssue)).click();
//	}
//
	// @Test
	// public void createAnIssueWithoutName(){
	//
	// }
	//
	// @Test
	// public void createAnIssueWithoutDescription(){
	//
	// }

	@Test
	public void createIssueSelectIssue() throws Exception {
		// create an Issue
		Thread.sleep(500);
		driver.findElement(By.id(button_issueErstellen)).click();
		//select an Issue
		Thread.sleep(500);
		driver.findElement(By.id(radioButton_createIssueSelectIssue)).click();
		
	}

//	@Test
//	public void createAnIssueBreak() throws Exception {
//		// create an new Issue
//		Thread.sleep(500);
//		driver.findElement(By.id(button_issueErstellen)).click();
//		// break
//		Thread.sleep(500);
//		driver.findElement(By.id(button_createIssueBreak)).click();
//	}
//
//	@Test
//	public void createIssueNewIssueBreak() throws Exception {
//		// create an new Issue
//		Thread.sleep(500);
//		driver.findElement(By.id(button_issueErstellen)).click();
//		Thread.sleep(500);
//		driver.findElement(By.id(radioButton_createIssueNewIssue)).click();
//		// break
//		Thread.sleep(500);
//		driver.findElement(By.id(button_createIssueBreak)).click();
//	}
//
//	@Test
//	public void createIssueSelectIssueBreak() throws Exception {
//		// create an Issue
//		Thread.sleep(500);
//		driver.findElement(By.id(button_issueErstellen)).click();
//		//select an Issue
//		Thread.sleep(500);
//		driver.findElement(By.id(radioButton_createIssueSelectIssue)).click();
//		// break
//		Thread.sleep(500);
//		driver.findElement(By.id(button_createIssueBreak)).click();
//	}
}
