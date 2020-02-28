package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/** 
 * Base page to hold common methods which can be used across other page classes 
 */
public abstract class BasePage {
    @SuppressWarnings("rawtypes")
	protected  static AppiumDriver driver;
    
    /**
     * method to initialize the element and while searching it performs with implicit wait 
     * @param driver the driver that will be used to look up the elements
     */
   protected BasePage(AppiumDriver driver){
       this.driver = driver;
       PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
   }
   protected void sendKeysToElement(String input, WebElement element,Boolean clearFlag)
   {    if(clearFlag == true)
   {    element.clear(); }
   	 element.sendKeys(input);
   }
   
   /**
    * method to wait until element is clickable
    * @param element - element reference
    */
   public static void explicitWait(WebElement element ){
             WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.elementToBeClickable(element));
        
   }
   
   /**
    * method to wait until element is displayed
    * @param element - element reference
    */
   public static void waitUntilVisible(WebElement element ){
	   
	   WebDriverWait wait = new WebDriverWait(driver,30);
	      wait.until(ExpectedConditions.visibilityOf(element));
          }
   /**
    * method to swipe to the bottom of current view port 
    */
   protected void swiptToBottom()
	{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int top_y = (int)(height*0.80);
		int bottom_y = (int)(height*0.20);
		TouchAction ts = new TouchAction(driver);
		ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
	}
   
   /**
    * method to perform click event on an element
    * @param element Element to be clicked 
    */
   protected void click(WebElement element){
	   waitUntilVisible(element);
	   element.click();}
   
   /**
    * method to get text from screen
    * @param element Element value 
    * @return text value 
    */
   protected String getScreenText(WebElement element){
String value= element.getText();
return value;}
   
   /**
    * method to perform keyboard ENTER key selection
    * @param element Element to be clicked 
    */
   
   protected void enterKey(){  
	   ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER ); }
	  
   
   
   /**
    * method to wait until element is clickable
    * @param element Element to wait for 
    */
   protected boolean isDisplayed(WebElement element)
   { explicitWait(element);
   return element.isDisplayed();
   }
   /**
    * method to capture screenshot during execution
    * the screenshot will be displayed against method testng 'emailable-report'
    * @param testScreenNamePath File name with path 
 * @throws IOException IOException
    */
public static void takeScreenShot(String testScreenNamePath) throws IOException {
   			File scrFile = driver.getScreenshotAs(OutputType.FILE);
		 		FileUtils.copyFile(scrFile, new File(testScreenNamePath));
					File tempFile = new File(testScreenNamePath);
		String src = driver.getScreenshotAs(OutputType.BASE64);
		String path = "<img src=\"data:image/png;base64, " + src + "\" width=\"400\" height=\"300\" />";
		Reporter.log(path);
}

/**
 * method to get driver instance  
 * @return driver 
 */
public static AppiumDriver getDriver() {
	return driver;

}
/**
 * method to make an assertion fails, but not to throw an exception 
 * @return  testng Assertion instance  
 */
public  SoftAssert softAssertions() { 
	SoftAssert softAssert = new SoftAssert();
	return softAssert;
}
}

