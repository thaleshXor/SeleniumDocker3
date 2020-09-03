package com.temp_test.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    protected WebDriver driver;
	//String browserName=System.getProperty("BROWSER");
    String completeURL="http://34.122.0.237:4444/wd/hub";
    //-------------------------------------------RUN ON  Agent Node------------------------------------------
   
    @Parameters({"browserName"})
    @BeforeMethod
	public void initialSetUp1(String browserName) throws MalformedURLException {
        if(browserName.equalsIgnoreCase("CHROME")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>RUNNING ON CHROME<<<<<<<<<<<<<<<<<<<<");
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities dc=new DesiredCapabilities();
	        dc.setBrowserName("chrome");
	        ChromeOptions options=new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
	        options.merge(dc);
			driver=new RemoteWebDriver(new URL(completeURL), options);
        }
        else if(browserName.equalsIgnoreCase("FIREFOX")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>RUNNING ON FIREFOX<<<<<<<<<<<<<<<<<<<<");
	        WebDriverManager.firefoxdriver().setup();
	        DesiredCapabilities dc=new DesiredCapabilities();
	        dc.setBrowserName("firefox");
	        FirefoxOptions options=new FirefoxOptions();
	        options.addArguments("--no-sandbox");
	        options.addArguments("--headless");
	        options.merge(dc);
	        driver=new RemoteWebDriver(new URL(completeURL), options);

        }
        else {
        	
        	try {
        		throw new Exception("No BROWSER NAME WAS PROVIDED !!");
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		System.out.println("Executing : tearDown()");
		this.driver.quit();
		String name=result.getMethod().getMethodName();
		System.out.println("---------Test : " + name + " ends-----------");
		System.out.print("\n");
		
		
	}

}
