package com.myAutomationProject.Utilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadConfig {
	Properties pro = new Properties();
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	    } 
		catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url = pro.getProperty("URL");
		return url;	
	}
		
	public String getUserName() {
		String username = pro.getProperty("userName");
		return username;
	}
	public String getPassWord() {
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath(){
		String cpath = pro.getProperty("chromepath");
		return cpath;
	}
	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	public String getFireFoxPath(){
		String ffpath = pro.getProperty("firefoxpath");
		return ffpath;
	}
}
