package BaseTest;
import java.io.IOException;
/** 
* 
* @author Arun
*/
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import Utils.ReadFileData;
/** 
 * Base test class
 */
public class BaseTest {
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;  

  /**
   * method to create a new session based on the desired capabilities provided
 * @return AndroidDriver
   */
  public static AndroidDriver<MobileElement> init() {
	String absolutePath = System.getProperty("user.dir")+"\\src\\test\\resources\\configs\\config.properties";
	ReadFileData propertyData = new ReadFileData();
  URL url = null;
try {
	url = new URL(propertyData.ReadPropertiesData(absolutePath,"appiumServerUrl"));
    capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, propertyData.ReadPropertiesData(absolutePath,"platformName"));
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, propertyData.ReadPropertiesData(absolutePath,"deviceName"));
    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, propertyData.ReadPropertiesData(absolutePath,"appPackage"));
    capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, propertyData.ReadPropertiesData(absolutePath,"appActivity"));
    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
   driver.resetApp(); 
  }
	catch(Exception error1)
	  {
		  System.out.print("Cause is " +error1.getCause());
		  System.out.print("Message is " +error1.getMessage());
		  error1.printStackTrace();
	  }
   return driver;
  }  
 

}
