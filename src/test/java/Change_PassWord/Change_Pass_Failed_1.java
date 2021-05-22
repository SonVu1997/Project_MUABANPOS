package Change_PassWord;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Change_Pass_Failed_1 {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test(description = "Login successfully", priority = 1)
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
  @Test(description = "Action button`doi mat khau`", priority = 2)
  public void ChangePassWord() {
	  WebElement element = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[3]/a/span[1]"));
	  Actions actions = new Actions(driver);
	  actions.clickAndHold(element).click().build().perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav\"]/ul/li[3]/ul/li[1]/a")));
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[3]/ul/li[1]/a")).click();
  }
  @Test(description = "Change password failed with new password null", priority = 3)
  public void Input_Data() {
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div")));
//	  change password
	  driver.findElement(By.id("old_password")).click();
	  driver.findElement(By.id("old_password")).sendKeys("123456");
//	  input password first
	  driver.findElement(By.id("dashpassword_change")).click();
	  driver.findElement(By.id("dashpassword_change")).sendKeys("");
//	  input new password
	  driver.findElement(By.id("dashpassword_change2")).click();
	  driver.findElement(By.id("dashpassword_change2")).sendKeys("");
//	  input again new password
	  driver.findElement(By.id("btn_change_password_dashboard_account")).click();
//	  click button "cap nhat"
	  
	  WebElement element2 = driver.findElement(By.id("dasherpassword"));
	  String actualResult = element2.getText();
	  String expectedResult = "Mật khẩu phải ít nhất 6 ký tự";
	  Assert.assertEquals(expectedResult, actualResult);
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("Change password failed");
	  driver.close();
  }
}

