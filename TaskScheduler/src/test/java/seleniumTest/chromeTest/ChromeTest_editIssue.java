package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.WebDriver.WebDriverTest_editIssue;

public class ChromeTest_editIssue extends WebDriverTest_editIssue {

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}
}
