package seleniumTest.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.WebDriver.WebDriver_createTaskTest;


public class Firefox_createTaskTest extends WebDriver_createTaskTest{

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
