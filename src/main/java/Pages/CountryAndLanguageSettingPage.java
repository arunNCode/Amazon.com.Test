package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
/**
 * Country And Language Setting page 
 */
public class CountryAndLanguageSettingPage extends BasePage {

	/**
	 * to use the created driver instance
	 * @param driver the driver that will be used to look up the elements
	 */
   public CountryAndLanguageSettingPage(AppiumDriver driver) {
		super(driver);
	}
   @AndroidFindBy(xpath = "//android.view.View/android.view.View[6]/android.widget.Button")
   public MobileElement countryButton;

   @AndroidFindAll({@AndroidFindBy(xpath = "//android.view.View //android.widget.RadioButton")})
   public List<MobileElement> countryList;
   
	 @AndroidFindBy(xpath = "//android.view.View[@text='Done']")
	 public MobileElement doneButton;
   
   /**
    * countryAndLanguageSettingPage page function to select a country 
    * @param textToSearch Country value to be selected 
    */

   public void selectListValueCountry(String textToSearch) {
	   selectCountryButton();
	  for(MobileElement e1 :countryList)
	  {
	  String text = e1.getText();
	  if (text.contains(textToSearch)) {
          click(e1) ;
          break;
      }
	  }
	  }
   
   /**
    * countryAndLanguageSettingPage page function to select done  
    */
   public void selectCountryButton() {
	   click(countryButton);
	    
	}
	   public void selectDone() {
	   click(doneButton);
	    
	}
   }