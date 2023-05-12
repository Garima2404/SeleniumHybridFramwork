package com.myAutomationProject.TestCases;

import org.testng.annotations.Test;

import com.myAutomationProject.Utilities.XLUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_02_LoginBDD extends BaseClass{
    @Test
	public void loginDDT() {
		
    	
	}
    @DataProvider(name="LoginData")
 //   getData()
    {
    	String path="/myAutomationProject/src/test/java/com/myAutomationProject/TestData/LoginData.xlsx";
    	int rownum=XLUtils.getRowCount(path, "Sheet1");
    	int cellcount=XLUtils.getCellCount(path, "Sheet1", 1);
    	
    }
    
}
