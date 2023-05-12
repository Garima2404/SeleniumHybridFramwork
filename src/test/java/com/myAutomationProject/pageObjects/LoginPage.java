package com.myAutomationProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}

	public void setUserName(String uname){
		driver.findElement(By.name("username")).sendKeys(uname);
		
	}
    public void setPassword(String password){
    	driver.findElement(By.name("password")).sendKeys(password);
	}
    public void clickSubmit(){
    	driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	}

}
