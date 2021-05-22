package login;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Case_Login_Successfully {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test(description = "Login successfully with username and password valid")
  public void Login_Successfully() {
	  driver.get("https://muabannhanh.xyz/cms/public/");
//	  laught browser with http://muabannhanh.xyz/cms/public/
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).sendKeys("BM");
//	  click code CH
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).sendKeys("admin");
//	  click and input username
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[3]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[3]/input")).sendKeys("123456");
//	  click and input password
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/button")).click();
//	  click button "Login"
	  String actualUrl = "https://muabannhanh.xyz/cms/public/dashboard";
	  String expectedUrl = driver.getCurrentUrl();
	  Assert.assertEquals(expectedUrl , actualUrl);
	  System.out.println("Title: "+ driver.getTitle());
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("Login successfully");
	  driver.close();
  }
}
