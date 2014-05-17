package seleniumTest.webDriver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class WebDriver_overviewTest implements Selectors, URL {
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
		Select filterTyp = new Select(driver.findElement(By.id(checkbox_filterIssueTyp))); 
//		filterTyp.deselectAll();
		filterTyp.selectByVisibleText("Bug");
		filterTyp.selectByVisibleText("Improvement");
		filterTyp.selectByVisibleText("Task");
		//select a resolution
		Select filterResolution = new Select(driver.findElement(By.id(checkbox_filterIssueResolution)));
//		filterResolution.deselectAll();
		filterResolution.selectByVisibleText("Cannot Reproduce");
		filterResolution.selectByVisibleText("Done");
		filterResolution.selectByVisibleText("Duplicate");
		filterResolution.selectByVisibleText("Fixed");
		filterResolution.selectByVisibleText("Wont Fix");
		filterResolution.selectByVisibleText("Unresolved");
		//submit
		driver.findElement(By.id(button_suchen));
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
