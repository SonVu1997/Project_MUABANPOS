package sign_out;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Log_out {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test(description = "Login successfully with username and password valid", priority = 1)
  public void LogIn_Successfully() {
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
  @Test(description = "Action button logout", priority = 2)
  public void Action_Button_Logout() {
	  
	  WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/nav/ul/li[3]/a"));
	  Actions actions = new Actions(driver);
	  actions.clickAndHold(element).click().build().perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/nav/ul/li[3]/ul/li[3]/a")));
	  driver.findElement(By.xpath("/html/body/div[3]/div[1]/nav/ul/li[3]/ul/li[3]/a")).click();

  }
  @Test(description = "Logout successfully", priority = 3)
  public void LogOut_Account() {
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div")));
	  driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/form/button[1]")).click();
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("Logout successfully");
	  driver.close();
  }
}
