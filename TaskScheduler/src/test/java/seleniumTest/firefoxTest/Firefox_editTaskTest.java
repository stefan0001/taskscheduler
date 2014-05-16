package seleniumTest.firefoxTest;

import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTest.webDriver.WebDriver_editTaskTest;

public class Firefox_editTaskTest extends WebDriver_editTaskTest {

	@Override
	public void initializeWebDriver() {
		driver = new FirefoxDriver();
	}

}
