package com.juaracoding.pageobject.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class SampleForm {
	
	private WebDriver driver;
	
	public SampleForm() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//label[contains(@for, 'gender-radio')]")
//	private List<WebElement> lstGender;
	
	@FindBy(xpath = "//label[contains(@for, 'gender-radio')]")
	private List<WebElement> listGender;
	
	//@for: atribut,// value atribut
	@FindBy(xpath = "//label[contains(@for, 'hobbies-checkbox')]")
	private List<WebElement> listHobbies;
	
	// @for: atribut,// value atribut
	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement uploadFile;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")
	private WebElement menuElement;
	
	//div[contains(@class,'css-1pahdxg-control')]//div[contains(@class,'css-1hwfws3')]
	
	@FindBy(xpath = "//div[@class='element-list collapse show']//li[contains(@id, 'item')]")
	private List<WebElement> listMenuElement;
	
//	@FindBy(xpath = "//label[contains(@for, 'gender-radio')]")
//	private List<WebElement> lstGender;	
//	
//	@FindBy(xpath = "//label[contains(@for, 'hobbies-checkbox')]")
//	private List<WebElement> lstHobbies;
//	
//	@FindBy(xpath = "//input[@id='uploadPicture']")
//	private WebElement uploadFile;
//	
//	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")
//	private WebElement menuElement;
//	
//	@FindBy(xpath = "//div[@class='element-list collapse show']//li[contains(@id, 'item')]")
//	private List<WebElement> lstMenuElement;

	
	//patern
	public void pilihGender(int pilih) {
		listGender.get(pilih).click();
		System.out.println(listGender.get(pilih).getText());
//			for (WebElement webElement : listGender) {	
//			}
	}
	
	//patern
	public void pilihHobbies(int pilih) {
		listHobbies.get(pilih).click();
		System.out.println(listHobbies.get(pilih).getText());
	}
	
	public void uploadGambar() {
		uploadFile.sendKeys("C:\\Users\\Erbina Selvia\\Pictures\\anak.jpg");
	}
	
	public void pilihMenuElement() {
		menuElement.click();
		listMenuElement.get(0).click();
		System.out.println(listMenuElement.get(0).getText());
	}
}
