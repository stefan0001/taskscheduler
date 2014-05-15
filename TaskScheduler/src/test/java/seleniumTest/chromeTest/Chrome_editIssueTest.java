package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.WebDriver.WebDriver_editIssueTest;

public class Chrome_editIssueTest extends WebDriver_editIssueTest {

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}
}
