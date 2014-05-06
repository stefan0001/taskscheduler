package seleniumTest.ieTest;

import org.openqa.selenium.ie.InternetExplorerDriver;

import seleniumTest.WebDriver.WebDriverTest_createTask;

public class ieTest_createTask extends WebDriverTest_createTask{

	@Override
	public void initializeWebDriver() {
		driver = new InternetExplorerDriver();
	}

}
