package seleniumTest.firefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.webDriver.WebDriver_overviewTest;

public class Firefox_overviewTest extends WebDriver_overviewTest {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
