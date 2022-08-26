package com.juaracoding.cucumber.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.ModalPages;


public class TestModal {

	public static WebDriver driver;
	private ModalPages modal;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/modal-dialogs";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		modal = new ModalPages();
	}
	
	@Test
	public void testSmallModal() {
		scroll(150);
		System.out.println(modal.getTxtModal());
		modal.clickSmallModal();
		System.out.println(modal.getTittleModal());
		System.out.println(modal.getBodyModal());
		modal.clikcCloseSmallModal();
		
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
