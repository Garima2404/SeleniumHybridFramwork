package com.myAutomationProject.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.myAutomationProject.pageObjects.LoginPage;

@Test
public class TestCase_01 extends BaseClass 

{
	public void loginTest() throws InterruptedException, IOException 
	{
		LoginPage lp=new LoginPage(this.driver);
		lp.setUserName(userName);
		logger.info("userName is opened");
		lp.setPassword(password);
		logger.info("password is opened");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("ParaBank | Eror")) {
			Assert.assertTrue(true);
			logger.info("Test pass!");
		}
		else {
			captureScreenShot(driver,"LoginTestfail");
			Assert.assertTrue(false);
			System.out.println("This is false");
			logger.info("Test fail!");
			
		}
	}
}
