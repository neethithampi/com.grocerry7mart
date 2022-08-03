package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\AMMU\\Desktop\\TestNg\\com.grocerry7mart\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
