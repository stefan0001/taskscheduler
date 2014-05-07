package seleniumTest.ieTest;

import org.openqa.selenium.ie.InternetExplorerDriver;

import seleniumTest.WebDriver.WebDriverTest_editTask;

public class ieTest_editTask extends WebDriverTest_editTask {

	@Override
	public void initializeWebDriver() {
		driver = new InternetExplorerDriver();
	}

}
