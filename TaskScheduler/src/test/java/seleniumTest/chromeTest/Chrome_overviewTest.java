package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.webDriver.WebDriver_overviewTest;

public class Chrome_overviewTest extends WebDriver_overviewTest {

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}

}
