package seleniumTest.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.WebDriver.WebDriver_editIssueTest;

public class Firefox_editIssueTest extends WebDriver_editIssueTest {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
