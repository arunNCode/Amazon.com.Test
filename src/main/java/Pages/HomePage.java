package Pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import Base.BasePage;
/**
 * Amazon Home, Product page methods and element identifiers 
 */
public class HomePage extends BasePage {
	/**
	 * to use the created driver instance
	 * @param driver the driver that will be used to look up the elements
	 */
    public HomePage(AppiumDriver driver) {
        super(driver);
    }
   
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    public MobileElement searchField;
    
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Home']")
    public MobileElement homeLogo;
    /**
     * to perform field input and validation	
     * @param searchKey search input value 
     * @return searches and return true or false based on result list display
     * @throws InterruptedException if the event fails 
     */
    
    
    /**
     * to validate logo displayed on home page 
     * @return Boolean value for assertion 
     */
    public Boolean validateHomeLogo()   {
      
    	return isDisplayed(homeLogo);
        }
    
    public boolean searchValidation(String searchKey) throws InterruptedException {
     sendKeysToElement(searchKey, searchField, false); 
     enterKey();
     Boolean checkResult = isDisplayed(resultList);
     if( checkResult == true)
     {
    	return true; }
     else
     {
    	 return false;}
    	}
  

    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.view.View/android.view.View[8]" )
    public MobileElement resultList;
    
    /**
     * to perform selection of a search result value 
     * @throws InterruptedException if the event fails 
     */
    public void selectResult() throws InterruptedException {
    	resultList.click() ;
        }
  
    @AndroidFindAll({@AndroidFindBy(xpath = "//android.widget.LinearLayout//android.view.View")})
    public List<MobileElement> productList;
    
    /**
     * store the product info for further validation
     * @throws InterruptedException if the event fails 
     * @return product info text value 
     */
    public String storePoductInfo() throws InterruptedException {
    	String actual = getScreenText(productList.get(7));
        return actual;
        }
    
    /**
     * method to select second product entry from result list 
     * @throws InterruptedException if the event fails 
     */
    
    public void clickProductResult() throws InterruptedException {
    	productList.get(7).click();
    }
    
    @AndroidFindBy(xpath = "//android.view.View[@id='title_feature_div']//android.view.View[@id='title']")
    public MobileElement productDetail;
    	
    /**
     * method to get the product detail value
     * @throws InterruptedException if the event fails 
     * @return product detail text value 
     */
    public String productDetail() throws InterruptedException {
    	String actual = getScreenText(productDetail);
    	return actual;
        }
    
    @AndroidFindBy(xpath = "//android.view.View[@resourceId='offers']//android.widget.Button")
    public MobileElement buyOptions;
    
    /**
     * method to scroll and select see buy options button on the product detail page
     * @throws InterruptedException if the event fails 
     */
    public void scrollAndclickBuy() throws InterruptedException {
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."+"scrollable(true)).scrollIntoView(new UiSelector().resourceId(“offers”))”"));
    	 buyOptions.click();
    }
    
 
    @AndroidFindBy(xpath = "//android.view.View[@id='a-autoid-0']/android.widget.Button")
    public MobileElement addToCart;
    
    @AndroidFindBy(id = "atc-success")
    public MobileElement successMessage;
    
    @AndroidFindBy(xpath = "//android.view.View[4]/android.widget.Button")
    public MobileElement confirmContinue;
    
    /**
     * method to select addtoCart and validate success message 
     * @param expected expected value to compare against actual
     */
    public void addToCart(String expected) {
    	click(addToCart);
    	String actual = getScreenText(successMessage);
    	Assert.assertTrue(actual.contains(expected));
	}
	
    
    


    	
    
 


}