package ubs_training.training;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class Login {
	WebDriver driver;
  @Test(dataProvider="dp1")
  public void f(String username, String pwd) {
	  driver.findElement(By.linkText("Log in")).click();
	  driver.findElement(By.id("Email")).sendKeys(username);
	  driver.findElement(By.id("Password")).sendKeys(pwd);
	  driver.findElement(By.cssSelector("input[value='Log in']")).click();
	  Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
  }
  
  @DataProvider(name="dp1")
	public Object[][] getData()
	{
		return Day2.testreadExcel();
	}
  
  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\AHK_workspace\\training\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://demowebshop.tricentis.com");
  }
  
  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }
}
