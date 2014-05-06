package seleniumTest.WebDriver;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class WebDriverTest_editIssue implements Selectors, URL {
	protected WebDriver driver;

	@Test
	public void editIssue() {
		// test case 15
		// TODO Issue bearbeiten
	}

	@Test
	public void editIssueStatus() {
		// test case 16
		Select status = new Select(driver.findElement(By.id(dropdownMenu_status)));
		status.selectByVisibleText("Open");
		driver.navigate().refresh();
		assertTrue(driver.findElement(By.id(dropdownMenu_status)).getText().equals("Open"));
	}
	
	@Test
	public void editResolutionOfClosedIssue(){
		//test case 17
		//change status to closed
		Select status = new Select(driver.findElement(By.id(dropdownMenu_status)));
		status.selectByVisibleText("Closed");
		Select resolution = new Select(driver.findElement(By.id(dropdownMenu_resolution)));
		resolution.selectByVisibleText("Fixed");
		driver.navigate().refresh();
		assertTrue(driver.findElement(By.id(dropdownMenu_resolution)).getText().equals("Fixed"));
	}
	
	@Test
	public void editResolutionOfNoClosedIssue(){
		//test case 17
		Select resolution = new Select(driver.findElement(By.id(dropdownMenu_resolution)));
		resolution.selectByVisibleText("Fixed");
		//accept alert
		driver.switchTo().alert().accept();
	}

	public abstract void initializeWebDriver();
	
	@BeforeMethod
	public void beforeMethod() {
		initializeWebDriver();
		driver.get(url);
		//TODO issue anzeigen
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		beforeMethod();
		// create a task based on time
				driver.findElement(By.id(button_neuerTask)).click();
				// fill name and description
				driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Time");
				driver.findElement(By.id(eingabefeld_taskBeschreibung)).sendKeys(
						"Time task");
				// based on time
				driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
				driver.findElement(By.className(checkbox_wiederholung)).click();
				;
				driver.findElement(By.id(eingabefeld_datum)).sendKeys(eingabe_datum);
				driver.findElement(By.id(eingabefeld_uhrzeit))
						.sendKeys(eingabe_uhrzeit);
				driver.findElement(By.id(eingabefeld_endDatum)).sendKeys(
						eingabe_endDatum);
				// create a new issue
				driver.findElement(By.id(button_issueAuswaehlen)).click();
				driver.findElement(By.className(button_neuesIssue)).click();
				driver.findElement(By.id(eingabefeld_issueName)).sendKeys(
						"Muster Issue1");
				driver.findElement(By.id(eingabefeld_issueBeschreibung)).sendKeys(
						"Ein Issue");
				// save the issue
				driver.findElement(By.id(button_speichernTask)).click();

				// create a task based on event
				driver.findElement(By.id(button_neuerTask)).click();
				// fill name and description
				driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Event");
				driver.findElement(By.id(eingabefeld_taskBeschreibung)).sendKeys(
						"Event Task");
				// based on event
				driver.findElement(By.id(radioButton_eventbasiertTastErstellen))
						.click();
				// select a event
				driver.findElement(By.id(button_eventAuswaehlen)).click();
				driver.findElements(By.className(checkbox_events)).get(0).click();
				driver.findElement(By.id(button_speichernEvent)).click();
				// create a new issue
				driver.findElement(By.id(button_issueAuswaehlen)).click();
				driver.findElement(By.className(button_neuesIssue)).click();
				driver.findElement(By.id(eingabefeld_issueName)).sendKeys(
						"Muster Issue2");
				driver.findElement(By.id(eingabefeld_issueBeschreibung)).sendKeys(
						"Ein Issue");
				//select type of this issue 
				Select issueType = new Select(driver.findElement(By.id(dropdownMenu_issueType)));
				issueType.selectByVisibleText("Bug");
				//select status of this issue
				Select status = new Select(driver.findElement(By.id(dropdownMenu_status)));
				status.selectByVisibleText("New");
				// save the task
				driver.findElement(By.id(button_speichernTask)).click();
	}

}
