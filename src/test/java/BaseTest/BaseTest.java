package BaseTest;
import Utils.ExcelUtils;

import Base.AppException;
import Base.BasePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
/** 
* 
* @author Arun
*/
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.itextpdf.text.DocumentException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import Utils.ReadFileData;
import Utils.Log;
import Base.TestDataReader;
/** 
 * Base test class
 */
public class BaseTest  {
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;  
  HashMap<String,String> ExcelInput = new HashMap<String,String>();
  protected String Search_Key ;
  protected String Country;
	
  
  
  /**
   *BeforeSuite method to setup logger by reading log4j property file
   */
  @BeforeSuite
  public static void logSetup(){
		String absolutePath = System.getProperty("user.dir")+"\\src\\test\\resources\\configs\\log4j.properties";
	  String log4jConfPath = absolutePath;
	  PropertyConfigurator.configure(log4jConfPath);
}
  
  /**
   *BeforeSuite method to create a new session based on the desired capabilities provided
 * @throws IOException exceptions produced by failed/interrupted I/O operations.
     * 	@throws AppException exceptions produced by failure of test events 
   */
	
	@BeforeSuite
  public static void init() throws AppException, IOException{
	
	String absolutePath = System.getProperty("user.dir")+"\\src\\test\\resources\\configs\\config.properties";
	ReadFileData propertyData = new ReadFileData();
	URL url = null;
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
	
	 /**
	   *get driver method to fetch runtime values
	   *@return driver instance
	   */
	
	 public AndroidDriver<MobileElement> getDriver() {
	        return driver;
	    }
	 
	
	 /**
	   * After suite method to close the driver session
	   */
	@AfterSuite
    public void afterSuite() {
        if(null != driver) {
        	driver.closeApp();
        	driver.quit();
        }
    }
  
  /**
   * reads test input from file required for test suite
   * @throws IOException exceptions produced by failed/interrupted I/O operations.
     *@throws AppException exceptions produced by failure of test events 
   */
  @BeforeTest
  public void setInputData() throws AppException, IOException
  { 
	 ExcelInput = TestDataReader.testDataReader("src\\test\\resources\\testData\\testDataInput.xlsx", "Sheet1");
	 Search_Key= ExcelInput.get("SearchKey");
	Country= ExcelInput.get("Country");  
  }
  


 
}
