package seleniumTest.WebDriver;

import java.util.List;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class WebDriverTest_overview implements Selectors, URL {
	protected WebDriver driver;

	@Test
	public void openTaskUebersicht() {
		// test case 1
		driver.findElement(By.id(button_uebersicht)).click();
	}

	@Test
	public void filterWithTodo() {
		// test case 18
		List<WebElement> filter = driver.findElements(By.id(checkbox_filter));
		if (((WebElement) filter.get(0)).isSelected()) {
			//it shows todo column
			assertEquals(driver.findElement(By.id(block_todo)).isDisplayed(),
					true);
		} else {
			//it doesn't show todo colum
			assertEquals(driver.findElement(By.id(block_todo)).isDisplayed(),
					false);
			//change visible
			((WebElement) filter.get(0)).click();
			assertEquals(driver.findElement(By.id(block_todo)).isDisplayed(),
					true);
		}
	}

	@Test
	public void filterWithImProgress() {
		// test case 18
		List<WebElement> filter = driver.findElements(By.id(checkbox_filter));
		if (((WebElement) filter.get(0)).isSelected()) {
			assertEquals(driver.findElement(By.id(block_imProgress))
					.isDisplayed(), true);
		} else {
			assertEquals(driver.findElement(By.id(block_imProgress))
					.isDisplayed(), false);
			((WebElement) filter.get(0)).click();
			assertEquals(driver.findElement(By.id(block_imProgress))
					.isDisplayed(), true);
		}
	}

	@Test
	public void filterWithDone() {
		// test case 18
		List<WebElement> filter = driver.findElements(By.id(checkbox_filter));
		if (((WebElement) filter.get(0)).isSelected()) {
			assertEquals(driver.findElement(By.id(block_done)).isDisplayed(),
					true);
		} else {
			assertEquals(driver.findElement(By.id(block_done)).isDisplayed(),
					false);
			((WebElement) filter.get(0)).click();
			assertEquals(driver.findElement(By.id(block_done)).isDisplayed(),
					true);
		}
	}
	
	public abstract void initializeWebDriver();
	
	@BeforeMethod
	public void beforeMethod(){
		initializeWebDriver();
		driver.get(url);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}
}
