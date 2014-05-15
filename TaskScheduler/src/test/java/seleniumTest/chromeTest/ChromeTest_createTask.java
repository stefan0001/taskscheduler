package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.WebDriver.WebDriverTest_createTask;

public class ChromeTest_createTask extends WebDriverTest_createTask{

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}

}
