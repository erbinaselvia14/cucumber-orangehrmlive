package com.juaracoding.cucumber.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Constants;

public class TestLogin {

	public static WebDriver driver;
	private LoginPages loginPage;

	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constants.CHROME);
		loginPage = new LoginPages();
	}

	@After
	public void closeBrowser() {
		delay(3);
		DriverSingleton.closeObjectInstance();
	}

	@Given("User go to Web HRM")
	public void user_go_to_Web_HRM() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@When("User enter username and password")
	public void user_enter_username_and_password() {
		loginPage.login("Admin", "admin1234");
	}

	@And("User click button login")
	public void user_click_button_login() {
		loginPage.clickBtnLogin();
	}

	@Then("User invalid credentials")
	public void user_invalid_credentials() {
		assertEquals(loginPage.msgInvalid(), "Invalid credentials");
	}

	@When("User enter username and password valid")
	public void user_enter_username_and_password_valid() {
		loginPage.login("Admin", "admin123");

	}

	@And("User click button login valid")
	public void user_click_button_login_valid() {
		loginPage.clickBtnLogin();
	}

	@Then("User valid credentials")
	public void user_valid_credentials_valid() {

	}
	
//	@Test
//	public void testInvalidLogin() {
//		loginpage.login("Admin", "admin1234");
//		assertEquals(loginpage.msgInvalid(), "Invalid credentials");
//	}
	
//	@Test
//	public void testUsernameEmpaty() {
//		loginpage.login("","admin123");
//		assertEquals(loginpage.nameEmpaty(), "Username cannot be empty");
//	}
//	
//	@Test
//	public void testValidLogin() {
//		loginpage.login("Admin", "admin123");
//		assertEquals(loginpage.getTxtDashboard(), "Dashboard");
//	}
	
	
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
