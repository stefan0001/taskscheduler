package seleniumTest.safariTest;

import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.WebDriver.WebDriverTest_createTask;

public class SafariTest_createTask extends WebDriverTest_createTask{


@Override
public void initializeWebDriver() {
	driver = new SafariDriver();	
}

}
