package com.myAutomationProject.Utilities;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listener Class used to generate extent reports
public class Reporting extends TestListenerAdapter{

	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	
	public void onStart(ITestContext testContext) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;//timeStamp
		
		String repName="TestReport-"+timestamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test output/"+repName);//Location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Garima");
		
		htmlReporter.config().setDocumentTitle("myAutomationProject");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}
	public void onTestSuccess(ITestContext testContext) {
		logger=extent.createTest(testContext.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(testContext.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestContext testContext) {
		logger=extent.createTest(testContext.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(testContext.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+testContext.getName()+".png";
		File f=new File(screenshotpath);
		if(f.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	public void onTestSkip(ITestContext testContext) {
		logger=extent.createTest(testContext.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(testContext.getName(), ExtentColor.ORANGE));
	
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
}
