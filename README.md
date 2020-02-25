# Mobile App test Automation Framework 

Here are the prerequisites for this test framework setup :

    #Appium (Appium desktop application) - Test automation framework for use with native, hybrid and mobile web apps.
    
    #Android Studio / platform tools - to connect with real device / create and use emulator. 
    
    #Maven -  to install and bundle all of your dependencies.
    
    #TestNG -to have the capabilities to organize test suites and test reports (if following BDD development practice cucumber tool can be used).
    
    - In this framework we are using Page object design with PageFactory Annotations in the page class.
    
    - Test script includes testNg Annotations for organizing the test step and to take care of prerequisites.

Dependent packages for the setup are marked in the pom file. 
https://github.com/arunNCode/testAppAutomation/blob/master/pom.xml

Sample test suite file
https://github.com/arunNCode/testAppAutomation/blob/master/src/test/java/testng-suite.xml

Test Data - Input data for the test scripts are fetched from the test data excel. Based on the modules we can have multiple sheets used for organizing the input data


How it works: 

The client sends post requests, also known as session requests to the appium server. The server differentiates between an iOS request and an Android request using the desiredCapabilites arguments and then processes the request to the respective UI Automators.Post processing and execution of the request(send as JSON objects) on a simulator/emulator/real device, results are communicated to the server and then back to the client system in terms of logs. 
