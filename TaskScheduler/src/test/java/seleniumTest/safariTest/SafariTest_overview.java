package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.WebDriver.WebDriverTest_overview;

public class SafariTest_overview extends WebDriverTest_overview {

	@Override
	public void initializeWebDriver() {
		driver = new SafariDriver();
	}
}
