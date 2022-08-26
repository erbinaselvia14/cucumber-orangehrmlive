package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class ModalPages {
	
	private WebDriver driver;
	
	public ModalPages() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[normalize-space()='Click on button to see modal']")
	private WebElement txtModal;
	
	@FindBy(xpath = "//button[@id='showSmallModal']")
	private WebElement btnSmallModal;

	@FindBy(xpath = "//div[@id='example-modal-sizes-title-sm']")
	private WebElement txtTitleModal;
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement txtBodyModal;
	
	@FindBy(xpath ="//button[@id='closeSmallModal']")
	private WebElement btnCloseSmallModal;
	
	@FindBy(xpath = "//button[@id='showLargeModal']")
	private WebElement btnLargeModal;
	
	public String getTxtModal() {
		return txtModal.getText();
	}
	
	public void clickSmallModal() {
		btnSmallModal.click();
	}
	
	public String getTittleModal() {
		return txtTitleModal.getText();
	}
	
	public String getBodyModal() {
		return txtBodyModal.getText();
	}
	
	public void clikcCloseSmallModal() {
		btnCloseSmallModal.click();
	}
	
	public void clickLargeModal() {
		btnLargeModal.click();
	}
}
