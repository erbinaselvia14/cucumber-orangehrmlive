package com.juaracoding.cucumber.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.RandomPokemon;


public class TestRandomPokemon {

	public static WebDriver driver;
	private RandomPokemon randompokemon;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://randompokemon.com/";
		driver.get(url);	
	}
	
	@BeforeMethod
	public void pageObject() {
		randompokemon = new RandomPokemon();
	}
	
	@Test
	public void testGeneretePokemon() {
		randompokemon.generetePokemon();
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(10);
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
