package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.WebDriver.WebDriver_editTaskTest;

public class Safari_editTaskTest extends WebDriver_editTaskTest {

	@Override
	public void initializeWebDriver() {
		driver = new SafariDriver();
	}
}
