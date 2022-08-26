package com.juaracoding.pageobject.main;

import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPages;

public class MainApp {
	
public static void main(String [] arg){
		
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		LoginPages loginpages = new LoginPages();
		loginpages.login("Admin","admin1234");
		loginpages.login("Admin1","admin1234");
		loginpages.login("Admin2","admin1234");
		loginpages.login("Admin3","admin1234");
		
		delay(3);
		driver.quit();
	}
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
