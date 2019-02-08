package ubs_training.training;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClearTrip {
	WebDriver driver;
  @BeforeTest
  public void BeforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\AHK_workspace\\training\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @Test(groups = "Actions2")
  public void f() throws InterruptedException {
    driver.get("https://www.cleartrip.com");
    Thread.sleep(5000);
	Actions act1 = new Actions(driver);
	WebElement target = driver.findElement(By.id("FromTag"));
	act1.sendKeys(target, "HYD").perform();
	Thread.sleep(5000);
	act1.sendKeys(Keys.ENTER).perform();
	WebElement source = driver.findElement(By.id("ToTag"));
	source.sendKeys("BKK");
	Thread.sleep(5000);
	act1.sendKeys(Keys.ENTER).perform();
  }
}
