package seleniumTest.FirefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.WebDriver.WebDriverTest_overview;

public class FirefoxTest_overview extends WebDriverTest_overview {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
