package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base{

	
	LandingPage landingPage = null;
	LoginPage loginPage = null;
	AccountPage accountPage  = null;
	
	
	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
		
		WebDriver driver = initiaizeDriver();
		
	}

	@Given("^Navigate to Login page$")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("URL"));
		
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_and_password_as_into_the_fields(String email, String password) {
		
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();

		loginPage = new LoginPage(driver);
		loginPage.emailAddress().sendKeys(email);
		loginPage.password().sendKeys(password);
	}

	@When("^User clicks on Login button$")
	public void user_clicks_on_login_button() {
		
		loginPage.loginButton().click();
	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		accountPage = new AccountPage(driver);
		
		AssertJUnit.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
		
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
