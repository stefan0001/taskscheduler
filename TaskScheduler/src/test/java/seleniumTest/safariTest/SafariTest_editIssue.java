package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.WebDriver.WebDriverTest_editIssue;

public class SafariTest_editIssue extends WebDriverTest_editIssue {

	@Override
	public void initializeWebDriver() {
		driver = new SafariDriver();
	}
}
