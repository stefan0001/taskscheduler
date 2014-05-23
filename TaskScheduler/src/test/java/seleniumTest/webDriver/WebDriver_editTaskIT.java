package seleniumTest.webDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public abstract class WebDriver_editTaskIT implements URL, Selectors {
	protected WebDriver driver;

//	@Test
//	public void activeTimeTask() {
//		// test case 8,9
//		driver.findElement(By.id(button_uebersicht)).click();
//		// based on time
//		driver.findElement(By.id(radioButton_zeitbasiertUebersicht)).click();
//		// TODO Task auswählen
//		// active task
//		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0)
//				.click();
//		driver.findElement(By.id(button_active)).click();
//		// save change
//		driver.findElement(By.id(button_submitActiveTask)).click();
//	}
//
//	@Test
//	public void activeEventTask() {
//		// test case 8,9
//		driver.findElement(By.id(button_uebersicht)).click();
//		// based on event
//		driver.findElement(By.id(radioButton_eventbasiertUebersicht)).click();
//		// TODO Task auswählen
//		// active task
//		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0)
//				.click();
//		driver.findElement(By.id(button_active)).click();
//		// save change
//		driver.findElement(By.id(button_submitActiveTask)).click();
//	}
//
//	@Test
//	public void deactiveTimeTask() {
//		// test case 8,9
//		driver.findElement(By.id(button_uebersicht)).click();
//		// based on time
//		driver.findElement(By.id(radioButton_zeitbasiertUebersicht)).click();
//		// TODO Task auswählen
//		// active task
//		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0)
//				.click();
//		driver.findElement(By.id(button_deactive)).click();
//		// save change
//		driver.findElement(By.id(button_submitActiveTask)).click();
//	}
//
//	@Test
//	public void deactiveEventTask() {
//		// test case 8,9
//		driver.findElement(By.id(button_uebersicht)).click();
//		// based on event
//		driver.findElement(By.id(radioButton_eventbasiertUebersicht)).click();
//		// TODO Task auswählen
//		// active task
//		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0)
//				.click();
//		driver.findElement(By.id(button_deactive)).click();
//		// save change
//		driver.findElement(By.id(button_submitActiveTask)).click();
//	}
//
//	@Test
//	public void showFireTime() {
//		// test case 12
//		driver.findElement(By.id(button_uebersicht)).click();
//		// based on time
//		driver.findElement(By.id(radioButton_zeitbasiertUebersicht)).click();
//		// TODO Task auswählen
//		// select a task
//		driver.findElements(By.className(checkbox_tasksUebersicht)).get(0)
//				.click();
//		// show FireTime
//		driver.findElement(By.id(button_fireTime)).click();
//		assertEquals(driver.findElement(By.id(text_fireCounter)).getText(), "0");
//	}
	public abstract void initializeWebDriver();
//
//	@Before
//	public void beforeMethod(){
//		initializeWebDriver();
//		driver.get(url);
//	}
//
//	@After
//	public void afterMethod() {
//		driver.close();
//		driver.quit();
//	}
//
	// @BeforeClass
	// static public void beforeClass() throws Exception{
	//
	// WebDriver driver = new FirefoxDriver();
	// driver.get(url);
	// // create a task based on time
	// driver.findElement(By.id(button_neuerTask)).click();
	//
	// // fill name and description
	// Thread.sleep(500);
	// driver.findElement(By.id(eingabefeld_taskName)).sendKeys("editIssueTest");
	//
	// // based on time
	// Thread.sleep(500);
	// driver.findElement(By.id(radioButton_zeitbasiertTaskErstellen)).click();
	// Thread.sleep(500);
	// // choose a day
	// driver.findElement(By.id(eingabefeld_datum)).click();
	// Thread.sleep(500);
	// driver.findElements(By.className(date)).get(13).click();
	// // choose a time
	// driver.findElement(By.id(eingabefeld_uhrzeit)).click();
	// Thread.sleep(500);
	// driver.findElement(
	// By.xpath("/html/body/div[5]/div[2]/table/tbody/tr/td/span[8]"))
	// .click();
	// Thread.sleep(500);
	// driver.findElement(
	// By.xpath("/html/body/div[5]/div[1]/table/tbody/tr/td/span[3]"))
	// .click();
	// // set repeat
	// driver.findElement(
	// By.xpath("//*[@id=\"TaskInput\"]/p[6]/select/option[2]"))
	// .click();
	//
	// // create a new issue
	// driver.findElement(By.id(button_taskErstellenNeuesIssue)).click();
	// Thread.sleep(500);
	// driver.findElement(By.id(eingabefeld_issueNameFuerTask)).sendKeys(
	// "Muster");
	// driver.findElement(By.id(eingabefeld_issueBeschreibungFuerTask))
	// .sendKeys("Beispiel");
	// driver.findElement(By.id(button_speichernTaskNeuesIssue)).click();
	// Thread.sleep(500);
	//
	//
	// // create a task based on event
	// driver.findElement(By.id(button_neuerTask)).click();
	//
	// // fill name and description
	// Thread.sleep(500);
	// driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Event");
	//
	// // based on event
	// driver.findElement(By.id(radioButton_eventbasiertTaskErstellen))
	// .click();
	// // select a event
	// driver.findElement(By.id(button_taskErstellenNeuesEvent)).click();
	// driver.findElement(By.xpath(eingabefeld_taskErstellenNeuesEventName)).sendKeys("Beispielevent");
	//
	// // create a new issue
	// driver.findElement(By.id(button_taskErstellenNeuesIssue)).click();
	// Thread.sleep(500);
	// driver.findElement(By.id(eingabefeld_issueNameFuerTask)).sendKeys(
	// "Muster");
	// driver.findElement(By.id(eingabefeld_issueBeschreibungFuerTask))
	// .sendKeys("Beispiel");
	// driver.findElement(By.id(button_speichernTaskNeuesIssue)).click();
	// Thread.sleep(500);
	//
	// // save the task
	// driver.findElement(By.id(button_speichernTask)).click();
	// driver.close();
	// driver.quit();
	// }
}
