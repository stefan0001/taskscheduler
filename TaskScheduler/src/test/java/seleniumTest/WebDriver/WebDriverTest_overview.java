package seleniumTest.WebDriver;

import java.util.List;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class WebDriverTest_overview implements Selectors, URL {
	protected WebDriver driver;

	@Test
	public void openTaskUebersicht() {
		// test case 1
		driver.findElement(By.id(button_uebersicht)).click();
	}

	@Test
	public void filter() {
		// test case 18
		//insert a issue name
		driver.findElement(By.id(eingabefeld_filterIssueName)).sendKeys("Beispiel");
		//select a type
		List<WebElement> filterElement;
		//submit
	}

	
	public abstract void initializeWebDriver();
	
	@BeforeMethod
	public void beforeMethod(){
		initializeWebDriver();
		driver.get(url);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}
}
