package Utils;
import Base.BasePage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * TestListener method implementation for various test events 
 */

public class TestListener implements ITestListener {
	  AppiumDriver<MobileElement> driver = null ;
	String absolutePath = System.getProperty("user.dir")+"\\test-output\\SCREENSHOTS\\Failed\\";
	String fileName = null;
	DateFormat formatDate = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
	Date dateobj = new Date();
	
	/**
	 * On'Test Fail event' screenshot will be captured 
	 * @param result test result 
	 */
	public void onTestFailure(ITestResult result) {
		try
		{   

		String formattedDate = formatDate.format(dateobj);
    	String methodName=result.getName().toString().trim();
        fileName= absolutePath+methodName+"_Failed_"+formattedDate+".png" ;
        BasePage.getDriver();
        BasePage.takeScreenShot(fileName);
		}
		catch(Exception ignore)
		{
			
		}
    }

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

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