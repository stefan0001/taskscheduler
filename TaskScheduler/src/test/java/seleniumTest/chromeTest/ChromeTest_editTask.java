package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.WebDriver.WebDriverTest_editTask;

public class ChromeTest_editTask extends WebDriverTest_editTask {

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}

}
