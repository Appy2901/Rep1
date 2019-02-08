package ubs_training.training;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {
	
  @Test(groups = "Actions1")
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\AHK_workspace\\training\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  
	  Actions act1 = new Actions(driver);
	  WebElement source = (driver.findElement(By.xpath("//div[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[2]/div/div/span")));
	  WebElement target = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
	  act1.dragAndDrop(source, target).perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
	  String result = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
			  //("//a[@href = '/personal/products']")));
	  /*act1.moveToElement(driver.findElement(By.xpath("//a[@href = '/personal/products']")));
	  act1.moveToElement(driver.findElement(By.xpath("//a[@href = '/personal/products/cards']")));
	  act1.moveToElement(driver.findElement(By.xpath("//a[@href = '/personal/products/cards/debit-cards']"))).perform();
	  driver.findElement(By.xpath("//a[@href = '/personal/products/cards/debit-cards']")).click();*/
	  System.out.println(result);
	  Assert.assertTrue(result.contains("$"));
	  driver.close();
  }
}
