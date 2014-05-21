package seleniumTest.webDriver;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriver_editIssueIT implements Selectors, URL {
	protected WebDriver driver;

	//
	// @Test
	// public void editIssue() {
	// // test case 15
	// // TODO Issue bearbeiten
	// }
	//
	// @Test
	// public void editIssueStatus() {
	// // test case 16
	// Select status = new
	// Select(driver.findElement(By.id(dropdownMenu_status)));
	// status.selectByVisibleText("Open");
	// driver.navigate().refresh();
	// assertTrue(driver.findElement(By.id(dropdownMenu_status)).getText().equals("Open"));
	// }
	//
	// @Test
	// public void editResolutionOfClosedIssue(){
	// //test case 17
	// //change status to closed
	// Select status = new
	// Select(driver.findElement(By.id(dropdownMenu_status)));
	// status.selectByVisibleText("Closed");
	// Select resolution = new
	// Select(driver.findElement(By.id(dropdownMenu_resolution)));
	// resolution.selectByVisibleText("Fixed");
	// driver.navigate().refresh();
	// assertTrue(driver.findElement(By.id(dropdownMenu_resolution)).getText().equals("Fixed"));
	// }
	//
	// @Test
	// public void editResolutionOfNoClosedIssue(){
	// //test case 17
	// Select resolution = new
	// Select(driver.findElement(By.id(dropdownMenu_resolution)));
	// resolution.selectByVisibleText("Fixed");
	// }

	protected abstract void initializeWebDriver();

	@Before
	public void beforeMethod() {
		initializeWebDriver();
		driver.get(url);
	}
	
	@Test
	public void showAIssue(){
		driver.findElement(By.xpath("//*[@id=\"accordion1\"]/div[1]/a/div/h6")).click();
	}

	@After
	public void afterMethod() {
//		driver.close();
//		driver.quit();
	}

	@BeforeClass
	static public void beforeClass() throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		// create a task based on time
		driver.findElement(By.id(button_neuerTask)).click();
		
		// fill name and description
		Thread.sleep(200);
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Time");
		
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		Thread.sleep(200);
		// choose a day
		driver.findElement(By.id(eingabefeld_datum)).click();
		Thread.sleep(200);
		driver.findElements(By.className(date)).get(13).click();
		// choose a time
		driver.findElement(By.id(eingabefeld_uhrzeit)).click();
		Thread.sleep(200);
		driver.findElement(
				By.xpath("/html/body/div[5]/div[2]/table/tbody/tr/td/span[8]"))
				.click();
		Thread.sleep(200);
		driver.findElement(
				By.xpath("/html/body/div[5]/div[1]/table/tbody/tr/td/span[3]"))
				.click();
		// set repeat
		driver.findElement(
				By.xpath("//*[@id=\"TaskInput\"]/p[6]/select/option[2]"))
				.click();
		
		// create a new issue
		driver.findElement(By.id(button_taskErstellenNeuesIssue)).click();
		Thread.sleep(200);
		driver.findElement(By.id(eingabefeld_issueNameFuerTask)).sendKeys(
				"Muster");
		driver.findElement(By.id(eingabefeld_issueBeschreibungFuerTask))
				.sendKeys("Beispiel");
		driver.findElement(By.id(button_speichernTaskNeuesIssue)).click();
		Thread.sleep(200);

		
		// create a task based on event
		driver.findElement(By.id(button_neuerTask)).click();
		
		// fill name and description		
		Thread.sleep(200);
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Event");
		
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTaskErstellen))
				.click();
		// select a event
		 driver.findElement(By.id(button_taskErstellenNeuesEvent)).click();
		 driver.findElement(By.xpath(eingabefeld_taskErstellenNeuesEventName)).sendKeys("Beispielevent");
		 
		// create a new issue
		 driver.findElement(By.id(button_taskErstellenNeuesIssue)).click();
		 Thread.sleep(200);
		 driver.findElement(By.id(eingabefeld_issueNameFuerTask)).sendKeys(
		 "Muster");
		 driver.findElement(By.id(eingabefeld_issueBeschreibungFuerTask))
		 .sendKeys("Beispiel");
		 driver.findElement(By.id(button_speichernTaskNeuesIssue)).click();
		 Thread.sleep(200);
		 
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
	}

}
