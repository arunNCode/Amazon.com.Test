package Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import Base.AppException;
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
    
    public boolean searchValidation(String searchKey) throws AppException {
    	waitUntilVisible(searchField);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     sendKeysToElement(searchKey, searchField, false); 
     enterKey();
     Boolean checkResult = isDisplayed(searchList);
     if( checkResult == true)
     {
    	return true; }
     else
     {
    	 return false;}
    	}

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout" )
    public MobileElement searchList;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.view.View/android.view.View[8]" )
    public MobileElement resultList;
    
    /**
     * to perform selection of a search result value 
     * @throws AppException if the event fails 
     */
    public void selectResult() throws AppException {
    	resultList.click() ;
        }
  
    /**
     * to perform selection of a search list result value 
     * @throws AppException if the event fails 
     */
    public void selectListResult() throws AppException {
    	searchList.click() ;
        }
  
    @AndroidFindAll({@AndroidFindBy(xpath = "//android.widget.LinearLayout//android.view.View")})
    public List<MobileElement> productList;
    
    /**
     * store the product info for further validation
     * @throws AppException if the event fails 
     * @return product info text value 
     */
    public String storePoductInfo() throws AppException {
    	String actual = getScreenText(productList.get(7));
        return actual;
        }
    
    /**
     * method to select second product entry from result list 
     * @throws AppException if the event fails 
     */
    
    public void clickProductResult() throws AppException {
    	productList.get(7).click();
    }
    
    @AndroidFindBy(xpath = "//android.view.View[@id='title_feature_div']//android.view.View[@id='title']")
    public MobileElement productDetail;
    	
    /**
     * method to get the product detail value
     * @throws AppException if the event fails 
     * @return product detail text value 
     */
    public String productDetail() throws AppException {
    	String actual = getScreenText(productDetail);
    	return actual;
        }
    
    @AndroidFindBy(xpath = "//android.view.View[@resourceId='offers']//android.widget.Button")
    public MobileElement buyOptions;
    
    /**
     * method to scroll and select see buy options button on the product detail page
     *@throws AppException exceptions produced by failure of test events 
     */
    public void scrollAndclickBuy() throws AppException {
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