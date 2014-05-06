package seleniumTest.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.WebDriver.WebDriverTest_createTask;


public class FirefoxTest_createTask extends WebDriverTest_createTask{

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
