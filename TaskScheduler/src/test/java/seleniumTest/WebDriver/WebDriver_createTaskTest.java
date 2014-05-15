package seleniumTest.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public abstract class WebDriver_createTaskTest implements Selectors, URL {
	protected WebDriver driver;

	@Test
	public void createTaskBreak() {
		// test case 2,3
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		driver.findElement(By.id(button_createTaskBreak)).click();
	}

	@Test
	public void createEventTaskBreak() {
		// test case 3
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTastErstellen)).click();
		// break
		driver.findElement(By.id(button_createTaskBreak)).click();
	}

	@Test
	public void createTimeTaskBreak() {
		// test case 3
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		// break
		driver.findElement(By.id(button_createTaskBreak)).click();
	}

	@Test
	public void selectIssueBreak() {
		// test case 3
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		;
		// break
		driver.findElement(By.id(button_createTaskBreak)).click();
	}

	@Test
	public void saveTimeTaskNothing() {
		// test case 5
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	@Test
	public void saveTimeTaskNoName() {
		// test case 5, 14
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	@Test
	public void saveTimeTaskNoDescription() {
		// test case 5
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	@Test
	public void saveTimeTaskNoTime() {
		// test case 5
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	@Test
	public void saveTimeTaskValidWithLoop() {
		// test case 5, 11
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");

		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
		driver.findElement(By.name(eingabefeld_datum)).sendKeys(eingabe_datum);
		driver.findElement(By.id(eingabefeld_uhrzeit))
				.sendKeys(eingabe_uhrzeit);
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		;
		// save the issue
		driver.findElement(By.id(button_speichernTask)).click();
	}

	@Test
	public void saveEventTaskValid() {
		// test case 7, 13
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTastErstellen)).click();
		// select a event
		driver.findElement(By.id(button_eventAuswaehlen)).click();
		driver.findElements(By.className(radioButton_events)).get(0).click();
		driver.findElement(By.id(button_speichernEvent)).click();
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
	}

	@Test
	public void saveEventTaskNoEvent() {
		// test case 7
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTastErstellen)).click();
		// save no event
		driver.findElement(By.id(button_speichernEvent)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	@Test
	public void saveTaskNoSelect() {
		// test case 7
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");
		// select a issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElements(By.className(radioButton_issues)).get(0).click();
		driver.findElement(By.id(button_speichernIssue)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	@Test
	public void savaTaskNoIssue() {
		// test case 7
		// create a new task
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Muster");
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTastErstellen)).click();
		// select a event
		driver.findElement(By.id(button_eventAuswaehlen)).click();
		driver.findElements(By.className(radioButton_events)).get(0).click();
		driver.findElement(By.id(button_speichernEvent)).click();
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		// accept alert
		driver.switchTo().alert().accept();
	}

	public abstract void initializeWebDriver();
	
	@BeforeMethod
	public void beforeMethod() {
		initializeWebDriver();
		driver.get(url);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}
