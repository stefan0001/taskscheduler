package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.WebDriver.WebDriverTest_editTask;

public class SafariTest_editTask extends WebDriverTest_editTask {

	@Override
	public void initializeWebDriver() {
		driver = new SafariDriver();
	}
}
