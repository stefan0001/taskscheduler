package testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	private WebDriver driver;
	private String url;
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new SafariDriver();
	  url = "http://www.google.de";
	  driver.get(url);
  }

  @AfterClass
  public void afterClass() {
  }

}
