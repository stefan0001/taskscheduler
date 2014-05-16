package de.sep.innovativeoperation.taskscheduler.test.selenium.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public abstract class WebDriver_createTaskIT implements Selectors, URL {
	protected WebDriver driver;

	@Test
	public void testTest(){
		driver = new FirefoxDriver();
		driver.get(url);
		
		driver.close();
		driver.quit();
	}
}
