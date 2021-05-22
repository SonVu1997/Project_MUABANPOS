package login;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Case_Login_Failed_1 {
  WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test(description = "Login failed code CH in correct")
  public void Failed_1() {
	  driver.get("https://muabannhanh.xyz/cms/public/");
//	  laught browser with http://muabannhanh.xyz/cms/public/
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).sendKeys("BMM");
//	  click code CH
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).sendKeys("admin");
//	  click and input username
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[3]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[3]/input")).sendKeys("123456");
//	  click and input password
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/button")).click();
//	  click button "Login"
	  
	  driver.navigate().to("https://muabannhanh.xyz/cms/public/");
//	  load page log bug
	  WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[3]/small"));
	  String actualResult  = element.getText();
	  String expectedResult = "Username hoặc password hoặc mã cửa hàng không đúng";
	  Assert.assertEquals(expectedResult, actualResult);
	  System.out.println("Message: "+ actualResult);
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
