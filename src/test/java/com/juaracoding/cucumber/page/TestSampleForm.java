package com.juaracoding.cucumber.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleForm;

public class TestSampleForm {
	
	public static WebDriver driver;
	private SampleForm sampleForm;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/automation-practice-form";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleForm = new SampleForm();
	}
	
	@Test
	public void testSampleForm() {
		scroll(150);
		sampleForm.pilihGender(0);
		sampleForm.pilihGender(1);
		sampleForm.pilihGender(2);
		scroll(150);
		sampleForm.pilihHobbies(0);
		sampleForm.pilihHobbies(1);
		sampleForm.pilihHobbies(2);
		sampleForm.uploadGambar();
		scroll(200);
		sampleForm.pilihMenuElement();
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
