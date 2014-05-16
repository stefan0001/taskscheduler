package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.webDriver.WebDriver_createTaskTest;

public class Safari_createTaskTest extends WebDriver_createTaskTest{


@Override
public void initializeWebDriver() {
	driver = new SafariDriver();	
}

}
