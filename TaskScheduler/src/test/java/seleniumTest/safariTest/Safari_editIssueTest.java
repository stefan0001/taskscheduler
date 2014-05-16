package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.webDriver.WebDriver_editIssueTest;

public class Safari_editIssueTest extends WebDriver_editIssueTest {

	@Override
	public void initializeWebDriver() {
		driver = new SafariDriver();
	}
}
