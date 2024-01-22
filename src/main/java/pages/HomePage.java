/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;


public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(linkText="Login")
	private WebElement clickOnLogin;
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	@FindBy(name="search")
	private WebElement searchBoxField;
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(clickOnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterLink() {
		elementUtils.clickOnElement(registerLink, CommonUtils.EXPLICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterProductSearchBoxField(String validProductText) {
		elementUtils.enterTextIntoElement(searchBoxField, validProductText, CommonUtils.EXPLICIT_WAIT_TIME); 
	}
	public SearchResultPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_TIME); 
		return new SearchResultPage(driver);
	}
}
