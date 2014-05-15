package seleniumTest.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.WebDriver.WebDriverTest_editTask;

public class FirefoxTest_editTask extends WebDriverTest_editTask {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
