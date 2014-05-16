package seleniumTest.firefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.webDriver.WebDriver_editIssueTest;

public class Firefox_editIssueTest extends WebDriver_editIssueTest {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
