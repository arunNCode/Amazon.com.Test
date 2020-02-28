package Utils;
import Base.BasePage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.itextpdf.text.DocumentException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * TestListener method implementation for various test events 
 */

public class TestListener implements ITestListener {
	  AppiumDriver<MobileElement> driver = null ;
	String absolutePath = System.getProperty("user.dir")+"\\test-output\\SCREENSHOTS\\";
	String fileName = null;
	DateFormat formatDate = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
	Date dateobj = new Date();
	String formattedDate = formatDate.format(dateobj);
	
	/**
	 * On'Test Fail event' screenshot will be captured for reporting 
	 * @param result test result 
	 */
	public void onTestFailure(ITestResult result) {
		try
		{   
	
	   String  methodName= getMethodName(result) ;
	    fileName= getFolderName(methodName,"Failed") ;
        BasePage.getDriver();
        BasePage.takeScreenShot(fileName);
        Reporter.log("Time "+formattedDate+ " -"+methodName+" - Failed");;
		}
		catch(Exception ignore)
		{
			
		}
    }
	 /**
	   * method to fetch result's name info
	 * @param result test result 
	 * @return methodname 
	   */
	public String getMethodName(ITestResult result) {
		return result.getName().toString().trim();
	}
	
	/**
	 * method to form screenshot path 
	 * @param methodName method name 
	 * @param folder folder reference
 *@return filepath 
	 */
	public String getFolderName(String methodName,String folder) {
    	return absolutePath+"\\"+folder+"\\"+methodName+formattedDate+".png" ;
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	 /**
	   * method to create screenshot and add log on event of success 
	 * @param result test result 
	   */
	public void onTestSuccess(ITestResult result)  {
        try {		  
        	String  methodName= getMethodName(result) ;
	    fileName= getFolderName(methodName,"Success") ;
        BasePage.getDriver();
			BasePage.takeScreenShot(fileName);
	        Reporter.log("Time "+formattedDate+ " -"+methodName+" - Passed");
		} catch (IOException e) {
			e.printStackTrace();
		}

;
	}

	 /**
	   * method onTestSkipped
	 * @param result test result 
	   */
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	 /**
	   * method onTestFailedButWithinSuccessPercentage
	 * @param result test result 
	   */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
    
} 