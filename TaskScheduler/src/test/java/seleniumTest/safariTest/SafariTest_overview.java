package seleniumTest.safariTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import seleniumTest.Selectors;
import seleniumTest.URL;

public class SafariTest_overview implements Selectors,URL{
	private WebDriver driver;

	@Test
	public void openTaskUebersicht() {
		// test case 1
		driver.findElement(By.id(button_uebersicht)).click();
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
}
