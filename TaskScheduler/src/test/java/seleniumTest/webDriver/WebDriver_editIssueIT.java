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

	@Test
	public void showAnIssue() throws Exception {
		//select an issue
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"accordion1\"]/div[1]/a/div/h6"))
				.click();
		//click edit icon
		Thread.sleep(500);
		driver.findElements(By.className(className_editIssue)).get(0).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"editModalIssue\"]")).click();
		//close the issue
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"editIssueRadioStatusClosed\"]"))
				.click();
		//save
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"saveIssueChanges\"]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"saveEditedIssue\"]")).click();
		Thread.sleep(500);
		driver.navigate().refresh();
	}

	@Test
	public void deleteAnIssue() throws Exception{
			//select an issue
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"accordion3\"]/div[1]/a/div/h6")).click();
			//click remove icon
			Thread.sleep(500);
			driver.findElements(By.className(className_removeIssue)).get(0).click();
	}

	protected abstract void initializeWebDriver();

	@Before
	public void beforeMethod() {
		initializeWebDriver();
		driver.get(url);
	}

	@After
	public void afterMethod() {
		 driver.close();
		 driver.quit();
	}

}
