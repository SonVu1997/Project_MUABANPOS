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

public class Change_Pass_Failed_2 {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
  @Test(description = "Login successfully", priority = 1)
  public void Login_successfully() {
	  driver.get("https://www.muabannhanh.xyz");
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[1]/input")).sendKeys("minhkhanh07");
//	  click user name and input user name
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/div[2]/input")).sendKeys("123456");
//	  click password and input password
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/form/button")).click();
//	  click button "Login"
	  String actualUrl = "https://www.muabannhanh.xyz/dashboard";
	  String expectedUrl = driver.getCurrentUrl();
	  Assert.assertEquals(expectedUrl , actualUrl);
	  System.out.println("Title: "+ driver.getTitle());
//	  Login successfully
  }
  @Test(description = "action button `doi mat khau`", priority = 2)
  public void ChangePassWord() {
	  WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/nav/ul/li[3]/a"));
	  Actions actions = new Actions(driver);
	  actions.clickAndHold(element).click().build().perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/nav/ul/li[3]/ul/li[1]/a")));
	  driver.findElement(By.xpath("/html/body/div[3]/div[1]/nav/ul/li[3]/ul/li[1]/a")).click();
  }
  @Test(description = "Change pass word failed with new password different again new password", priority = 3)
  public void Input_Data() {
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div")));
//	  change password
	  driver.findElement(By.id("old_password")).click();
	  driver.findElement(By.id("old_password")).sendKeys("123456");
//	  input password first
	  driver.findElement(By.id("dashpassword_change")).click();
	  driver.findElement(By.id("dashpassword_change")).sendKeys("654321");
//	  input new password
	  driver.findElement(By.id("dashpassword_change2")).click();
	  driver.findElement(By.id("dashpassword_change2")).sendKeys("123456");
//	  input again new password
	  driver.findElement(By.id("btn_change_password_dashboard_account")).click();
//	  click button "cap nhat"
	  
	  WebElement element2 = driver.findElement(By.id("dasherpassword2"));
	  String actualResult = element2.getText();
	  String expectedResult = "M???t kh???u nh???p l???i kh??ng ????ng";
	  Assert.assertEquals(expectedResult, actualResult);
	  System.out.println("Alert: " + actualResult);  
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("Change pass word failed");
	  driver.close();
  }
}


