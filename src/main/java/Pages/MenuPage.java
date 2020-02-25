package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/**
 *  Menu page, header icon elements and methods
 */
public class MenuPage extends BasePage {
	/**
	 * to use the created driver instance
	 * @param driver the driver that will be used to look up the elements
	 */
   public MenuPage(AppiumDriver driver) {
		super(driver);
	}

   @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
   public MobileElement burgerMenuIcon;
   

   @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_cart_image")
   public MobileElement shoppingCart;
   
   
   @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
   public MobileElement settingsIcon;


   @AndroidFindBy(xpath = "//android.widget.TextView[@text='Country & Language']")
   public MobileElement countrySelector;
   
   /**
    * page function to select Burger menu
    */

   public void clickBurgerMenu() {
		
	    click(burgerMenuIcon);
	    
   }
   
   /**
    * page function to select shopping cart
    */

   public void clickCart() {
		
	    click(shoppingCart);
	    
   }
   /**
    * page function to select country and lanaguage settings icon from Burger menu
    */

   public void selectCountrySelector() {
		
	    click(burgerMenuIcon);
	    click(settingsIcon);
	    click(countrySelector);
   }
   
  

    
}