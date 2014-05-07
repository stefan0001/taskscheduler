package seleniumTest.ieTest;

import org.openqa.selenium.ie.InternetExplorerDriver;

import seleniumTest.WebDriver.WebDriverTest_editIssue;

public class ieTest_editIssue extends WebDriverTest_editIssue {

	@Override
	public void initializeWebDriver() {
		driver = new InternetExplorerDriver();
	}

}
