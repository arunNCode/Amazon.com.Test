package amazonApp.mobileAppTest;

import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.AppException;
import BaseTest.BaseTest;
import Pages.CountryAndLanguageSettingPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MenuPage;
import Utils.CustomReporter;

/**
 * Product purchase test suite
 */
@Listeners(value=CustomReporter.class)
public class Purchase extends BaseTest {
public static URL url;
  private HomePage homepage; 
  private LoginPage loginpage;
  private MenuPage menuPage;
  private CountryAndLanguageSettingPage countrySelectionPage;

/** 
* Test method which validates "Change country value on Setting page"."
*/

  @Test (priority=0, testName = "Change country value on Settings" )
  public void changeCountrySettings() {
	
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
  /** 
  * Test method which validates "Search a product,view result and do a purchase"
     *@throws AppException exceptions produced by failure of test events 
  */
  @Test (priority=0, testName = "Search a product,view result and do a purchase" ,dependsOnMethods = { "changeCountrySettings" })
  public void buyProduct() throws AppException  {
      Assert.assertTrue(homepage.searchValidation(Search_Key));
      homepage.selectListResult();
	  String buffer1 =  homepage.storePoductInfo();
	  homepage.clickProductResult();
	  String actualValue = homepage.productDetail();
	  Assert.assertTrue(actualValue.contains(buffer1));
	  homepage.scrollAndclickBuy();
	  homepage.addToCart("Added to cart");
	  menuPage.clickCart();
	 
  }
}
