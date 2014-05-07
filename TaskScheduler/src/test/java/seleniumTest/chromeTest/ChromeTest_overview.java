package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.WebDriver.WebDriverTest_overview;

public class ChromeTest_overview extends WebDriverTest_overview {

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}

}
