package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.webDriver.WebDriver_editTaskTest;

public class Safari_editTaskTest extends WebDriver_editTaskTest {

	@Override
	public void initializeWebDriver() {
		driver = new SafariDriver();
	}
}
