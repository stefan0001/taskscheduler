package seleniumTest.chromeTest;

import org.openqa.selenium.chrome.ChromeDriver;

import seleniumTest.WebDriver.WebDriver_editTaskTest;

public class Chrome_editTaskTest extends WebDriver_editTaskTest {

	@Override
	public void initializeWebDriver() {
		driver = new ChromeDriver();
	}

}
