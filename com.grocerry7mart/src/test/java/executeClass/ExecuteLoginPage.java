package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;

public class ExecuteLoginPage extends BaseClass{
	
	LoginPage lp;
	
  @Test
  public void verifyLoginPageIsVisibleWhileLaunchingTheApplication() {
	  lp = new LoginPage(driver);
	  
	  String expectedurl = "http://groceryapp.uniqassosiates.com/admin/login";
	  String actualurl = lp.getUrlOfTheLogin();
	  
	  Assert.assertEquals(expectedurl, actualurl);
  }
  
 
  @Test
  
  public void verifySuccessfullLoginWithValidUsernameAndPassword() throws IOException
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(lp.readUsername(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickOnLogin();
	  String expectedUsername = "Admin";
	  String actualUsername = lp.getAdminText();
	  
	  Assert.assertEquals(actualUsername, expectedUsername);
  }
  
  @Test
  
  public void verifyRememberMeCheckboxIsSelectedOrNot()
  {
	  lp = new LoginPage(driver);
	  boolean rememberMe = lp.isRemembermeSelected();
	 Assert.assertFalse(rememberMe);
  }
  
  @Test
  
  public void isHomePageDisplayedWhileLogin() throws IOException
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(lp.readUsername(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickOnLogin();
	  String expectedUsername = "Admin";
	  String actualUsername = lp.getAdminText();
	  
	  Assert.assertEquals(expectedUsername, actualUsername);
	  
  }
  
  @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class)
  
  public void verifyUnsuccessfullLogin(String name, String pass) throws IOException
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(lp.readUsername(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickOnLogin();
	  boolean actualAlertmsg = lp.isAlertMsgDisplayed();
	  Assert.assertTrue(actualAlertmsg);
  }
}
