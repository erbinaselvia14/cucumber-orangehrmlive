package com.juaracoding.cucumber.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleAlert;


public class TestAlert {

	public static WebDriver driver;
	private SampleAlert sampleAlert;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/alerts";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleAlert = new SampleAlert();
	}
	
	@Test (priority = 1)
	public void testAlertOne() {
		scroll(260);
		sampleAlert.clickMe();
		delay(1);
		String txtAlert = driver.switchTo().alert().getText();
		delay(1);
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		System.out.println(sampleAlert.getTxtConfirmResult());
		System.out.println(txtAlert);
		String txt = sampleAlert.getTxtConfirmResult();
		assertTrue(txt.contains("Cancel"));
	}
	
	@Test (priority = 2)
	public void testAlertTwo() {
		scroll(250);
		sampleAlert.clickMeTwo();
		delay(1);
		driver.switchTo().alert().sendKeys("Test");
		delay(1);
		driver.switchTo().alert().accept();
		System.out.println(sampleAlert.getTxtPromtResult());
		String txt = sampleAlert.getTxtPromtResult();
		assertTrue(txt.contains("Test"));
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(10);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}
}
