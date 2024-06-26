package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	 public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropdown;
	
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginOption;
	
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	
	public WebElement loginOption() {
		return loginOption;
	}
	
	 
}
