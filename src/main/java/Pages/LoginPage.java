package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Login page 
 */
public class LoginPage extends BasePage {
	/**
	 * to use the created driver instance
	 * @param driver the driver that will be used to look up the elements
	 */
   public LoginPage(AppiumDriver driver) {
		super(driver);
	}

   @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
   public MobileElement loginButton;
   

   @AndroidFindBy(xpath = "//android.widget.EditText")
   public MobileElement emailField;
   
   @AndroidFindBy(xpath = "//android.webkit.WebView//android.view.View/android.view.View/android.view.View[4]/android.widget.Button")
   public MobileElement continueButton;
 
   //Password input
   @AndroidFindBy(xpath = "//hierarchy//android.view.View[7]/android.view.View[2]/android.widget.EditText")
   public MobileElement passwordField;
   
   @AndroidFindBy(xpath = "//android.webkit.WebView/android.webkit.WebView/android.view.View//android.widget.Button")
   public MobileElement signInSubmit;
   
   @AndroidFindBy(id =  "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
   public MobileElement skipSignIn;
   /**
    * page function to click skip SignIn button
    * */
   public void selectSkipSignin(){
	   click(skipSignIn);
   }
   
 
   /**
    * page function to perfom the username and password input to navigate to home page
    * @param username username test data value 
    * @param password password test data value
    * @throws InterruptedException if event fails 
    */

   public void login(String username, String password) throws InterruptedException {
   	   loginButton.click();
//   	   WebDriverWait wait = new WebDriverWait(driver, 60);
   	   sendKeysToElement(username, emailField, false); 
   	   click(continueButton);
       sendKeysToElement(password, passwordField, false); 
       passwordField.sendKeys(password);
       click(signInSubmit);
   }
   
  

    
}