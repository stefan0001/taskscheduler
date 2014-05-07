package seleniumTest.ieTest;

import org.openqa.selenium.ie.InternetExplorerDriver;

import seleniumTest.WebDriver.WebDriverTest_overview;

public class ieTest_overview extends WebDriverTest_overview {

	@Override
	public void initializeWebDriver() {
		driver = new InternetExplorerDriver();
	}

}
