package seleniumTest.safariTest;

import org.junit.BeforeClass;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import seleniumTest.Selectors;
import seleniumTest.URL;

public class SafariTest_editTask implements URL, Selectors {
	private WebDriver driver;

	@Test
	public void activeTimeTask() {
		// test case 8,9
		driver.findElement(By.id(button_uebersicht)).click();
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertUebersicht)).click();
		// TODO Task auswählen
		// active task
		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0).click();
		driver.findElement(By.id(button_active)).click();
		// save change
		driver.findElement(By.id(button_submitActiveTask)).click();
	}

	@Test
	public void activeEventTask() {
		// test case 8,9
		driver.findElement(By.id(button_uebersicht)).click();
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertUebersicht)).click();
		// TODO Task auswählen
		// active task
		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0).click();
		driver.findElement(By.id(button_active)).click();
		// save change
		driver.findElement(By.id(button_submitActiveTask)).click();
	}

	@Test
	public void deactiveTimeTask() {
		// test case 8,9
		driver.findElement(By.id(button_uebersicht)).click();
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertUebersicht)).click();
		// TODO Task auswählen
		// active task
		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0).click();
		driver.findElement(By.id(button_deactive)).click();
		// save change
		driver.findElement(By.id(button_submitActiveTask)).click();
	}

	@Test
	public void deactiveEventTask() {
		// test case 8,9
		driver.findElement(By.id(button_uebersicht)).click();
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertUebersicht)).click();
		// TODO Task auswählen
		// active task
		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0).click();
		driver.findElement(By.id(button_deactive)).click();
		// save change
		driver.findElement(By.id(button_submitActiveTask)).click();
	}

	@Test
	public void showFireTime() {
		// test case 12
		driver.findElement(By.id(button_uebersicht)).click();
		// based on time
		driver.findElement(By.id(radioButton_zeitbasiertUebersicht)).click();
		// TODO Task auswählen
		// select a task
		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0).click();
		// show FireTime
		driver.findElement(By.id(button_fireTime)).click();
		assertEquals(driver.findElement(By.id(text_fireCounter)).getText(),"0");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new SafariDriver();
		driver.get(url);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		//create a task based on time
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
		driver.findElement(By.id(eingabefeld_issueName)).sendKeys("Muster Issue1");
		driver.findElement(By.id(eingabefeld_issueBeschreibung)).sendKeys("Ein Issue");
		// save the issue
		driver.findElement(By.id(button_speichernTask)).click();
		
		//create a task based on event
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Event");
		driver.findElement(By.id(eingabefeld_taskBeschreibung)).sendKeys(
				"Event Task");
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTastErstellen)).click();
		// select a event
		driver.findElement(By.id(button_eventAuswaehlen)).click();
		driver.findElements(By.className(checkbox_events)).get(0).click();
		driver.findElement(By.id(button_speichernEvent)).click();
		// create a new issue
		driver.findElement(By.id(button_issueAuswaehlen)).click();
		driver.findElement(By.className(button_neuesIssue)).click();
		driver.findElement(By.id(eingabefeld_issueName)).sendKeys("Muster Issue2");
		driver.findElement(By.id(eingabefeld_issueBeschreibung)).sendKeys("Ein Issue");
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
	}

}
