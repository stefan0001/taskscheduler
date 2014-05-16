package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.webDriver.WebDriver_createTaskTest;

public class Chrome_createTaskTest extends WebDriver_createTaskTest{

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}

}
