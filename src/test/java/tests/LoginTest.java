package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	public Logger 	log = LogManager.getLogger(LoginTest.class.getName());

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedResult) {


		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddress().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.password().sendKeys(password);
		log.debug("Password got entered");

		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");

		AccountPage accountPage = new AccountPage(driver);
		String actualResult = null;

		try {
			boolean displayed = accountPage.editAccountInformationOption().isDisplayed();
			actualResult = "successfull";
			log.debug("User got logged in");

		} catch (Exception e) {
			log.debug("User didn't log in");
				actualResult = "failure";
		}
		AssertJUnit.assertEquals(actualResult, expectedResult);
		if (actualResult.equals(expectedResult)) {

			log.info("Login Test got passed");

		} else {

			log.error("Login Test got failed");
		}
//		System.out.println(displayed);

	}

	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initiaizeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("URL"));
		log.debug("Navigated to application URL");

	}

	@AfterMethod
	public void closure() {
		driver.quit();
		log.debug("Browser got closed");

	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "hthitame@gmail.com", "1234", "successfull" }, { "abcd@gmail.com", "123", "failure" } };
		return data;
	}
}
