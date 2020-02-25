package amazonApp.mobileAppTest;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import Pages.CountryAndLanguageSettingPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MenuPage;
import Utils.CustomReporter;
import Utils.ExcelUtils;

@Listeners(value=CustomReporter.class)
/**
 * Product purchase test suite
 */
public class Purchase extends BaseTest {

public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;  
  private String Search_Key ;
	private String Country;
List<String> InputValue = new ArrayList<String>();
  private HomePage homepage;
  private LoginPage loginpage;
  private MenuPage menuPage;
  private CountryAndLanguageSettingPage countrySelectionPage;
  
  /**
   * initiating the session 
   */
  @BeforeTest
  public void initialize (){ 
	  driver = BaseTest.init();
  }

  /**
   * reads test input from file 
   */
  @BeforeTest
public void testDataInput (){ 
try{
	URL pathvalue = this.getClass().getResource("/TestData");
	String absoluteDiskPath = pathvalue.getPath();
	ExcelUtils objSheetFile = new ExcelUtils();
	InputValue= objSheetFile.readExcel(absoluteDiskPath,"TestData.xlsx","Sheet1");
	Search_Key= InputValue.get(2);
	Country = InputValue.get(1);
}
	catch(Exception error1)
	  {
		  System.out.print("Message is " +error1.getMessage());
		  error1.printStackTrace();
	  }
}

/** 
* Test method which validates "Change country value on Setting page"."
 * @throws Exception When test case fails due to error
*/
 
  @Test (priority=0, testName = "Change country value on Settings" )
  public void changeCountrySettings() throws Exception  {
	  try{
      homepage = new HomePage(driver);
      loginpage = new LoginPage(driver);
      menuPage = new MenuPage(driver);
      countrySelectionPage = new CountryAndLanguageSettingPage(driver);
      loginpage.selectSkipSignin();
      menuPage.selectCountrySelector();

      countrySelectionPage.selectListValueCountry(Country);
      countrySelectionPage.selectDone();
      Assert.assertTrue(homepage.validateHomeLogo());
      }
	  catch(Exception error)
	  {
		  System.out.print("Message is " +error.getMessage());
		  error.printStackTrace();
		  throw error ;
	  }
  }
  /** 
  * Test method which validates "Search a product,view result and do a purchase"
   * @throws Exception When test case fails due to error
  */
  @Test (priority=0, testName = "Search a product,view result and do a purchase" ,dependsOnMethods = { "changeCountrySettings" })
  public void buyProduct() throws Exception  {
	  try{
      Assert.assertTrue(homepage.searchValidation(Search_Key));
	  homepage.selectResult();
	  String buffer1 =  homepage.storePoductInfo();
	  homepage.clickProductResult();
	  String actualValue = homepage.productDetail();
	  Assert.assertTrue(actualValue.contains(buffer1));
	  homepage.scrollAndclickBuy();
	  homepage.addToCart("Added to cart");
	  menuPage.clickCart();
      }
	  catch(Exception error)
	  {
		  System.out.print("Message is " +error.getMessage());
		  error.printStackTrace();
		  throw error ;
	  }
  }
}
