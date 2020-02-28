package Utils;

import java.util.Collection;

import java.util.Date;

import java.util.List;

import java.util.Map;

import java.util.Set;
import org.testng.IReporter;

import org.testng.IResultMap;

import org.testng.ISuite;

import org.testng.ISuiteResult;

import org.testng.ITestContext;

import org.testng.ITestNGMethod;

import org.testng.xml.XmlSuite;

/**
 * to get  failed test cases info from testng report
 */
public class CustomReporter implements IReporter{
   
    public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String outputDirectory) {
        // Second parameter of this method ISuite will contain all the suite executed.

        for (ISuite iSuite : arg1) {
         //Get a map of result of a single suite at a time
            Map<String,ISuiteResult> results =    iSuite.getResults();

         //Get the key of the result map
            Set<String> keys = results.keySet();

        //Go to each map value one by one
            for (String key : keys) {
             //The Context object of current result
            ITestContext context = results.get(key).getTestContext();

           Log.info("Test Execution Report Directory - "+context.getOutputDirectory());

             //Get Map for failed test cases

            IResultMap resultMap = context.getFailedTests();
            Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();

            //Loop one by one in all failed methods
            System.out.println("<--------FAILED TEST CASE--------->");
            for (ITestNGMethod iTestNGMethod : failedMethods) {
            	Log.info("TESTCASE NAME->"+iTestNGMethod.getMethodName() +"\n:Date->"+new Date(iTestNGMethod.getDate()));

            }

        }

        }

        

    }

}