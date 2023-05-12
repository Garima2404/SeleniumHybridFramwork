package com.myAutomationProject.TestCases;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import com.myAutomationProject.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	public String URL = rc.getApplicationURL();
	public String userName = rc.getUserName();
	public String password = rc.getPassWord();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass

	public void setup(String br) {
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();
		System.out.println("Browser set : "+driver);
	    }
		
		if(br.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver",rc.getFireFoxPath());
		driver = new FirefoxDriver();
	    }
		
		if(br.equals("IE")) {
		System.setProperty("webdriver.ie.driver",rc.getIEPath());
		driver = new  InternetExplorerDriver();
	    }
		
		driver.get(URL);	
		logger.info("URL is opened");
	}	
		
    @AfterClass
    public void teardown()
    {
        driver.quit();
	}
    public void captureScreenShot(WebDriver driver,String tname) throws IOException {
    	//Convert web driver object to TakeScreenshot
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
    	//Call getScreenshotAs method to create image file
    	File source=scrShot.getScreenshotAs(OutputType.FILE);
    	//Move image file to new destination
    	File destination=new File(System.getProperty("user.dir")+"/Screenshots"+tname+".png");
    	//Copy file at destination
    	FileUtils.copyFile(source, destination);
    }

	

}
