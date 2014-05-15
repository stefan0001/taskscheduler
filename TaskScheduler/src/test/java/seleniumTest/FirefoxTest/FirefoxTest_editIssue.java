package seleniumTest.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.WebDriver.WebDriverTest_editIssue;

public class FirefoxTest_editIssue extends WebDriverTest_editIssue {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
