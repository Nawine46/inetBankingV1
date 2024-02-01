package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadingConfig {
	
	
	
	Properties pro;
	
	public ReadingConfig () {
		
		
		//File src =new File("./Configuration/config.properties");
		File src =new File("Configuration//config.properties");
		
	    try {
	    	
	    	FileInputStream fis =new FileInputStream(src);
	    	
	    	pro =new Properties();
	    	
	    	pro.load(fis);
	    	
	    	
	    } catch (Exception e){
	    	
	    	
	    		System.out.println("Exception "+e.getMessage());
	    	   	
	    	
	    }
		
			
	
		
	}

	public String getApplicationURL() {
		
		String url = pro.getProperty("baseURL");
		
		return url;
		
		
	}
	
	
	public String getUsername() {
		
		String Username = pro.getProperty("userName");
		
		return Username;
		
		
	}
	
	public String passWord() {
		
		String passWord = pro.getProperty("userName");
		
		return passWord;
		
		
	}
	
	public String getChromePath() {
		
		
		String chromepath = pro.getProperty("chromepath");
		
		return chromepath;
		
	}

	
	public String getFirefoxpath() {
		
		
		String firepath = pro.getProperty("firefoxpath");
		return firepath;
		
		
	}
}
