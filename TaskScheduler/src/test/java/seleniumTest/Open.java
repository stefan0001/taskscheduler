package seleniumTest;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Open {
	private String url = "http://localhost:8080/TaskScheduler/static/gui/";
	private WebDriver driver;

	 @Test
	 public void safariTest() {
	 driver = new SafariDriver();
	 driver.get(url);
	 }

	@Test
	public void chromeTest() {
		driver = new ChromeDriver();
		driver.get(url);
	}

	

	@Test
	public void firefoxTest() {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();

		// driver.close();
	}
}
