package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	 public WebDriver driver;

	public AccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	private WebElement editAccountInformationOption;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement wrongCredentials;
	
	public WebElement editAccountInformationOption() {
		
		return editAccountInformationOption;
	}
	
	public WebElement wrongCredentials() {
		return wrongCredentials;
	}
	
	
}
