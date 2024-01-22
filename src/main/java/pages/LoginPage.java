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

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id="input-email")
	private WebElement emailField;
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(xpath="//*[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsg;
	
	public void  enterEmailAddress(String emailId) {
		elementUtils.enterTextIntoElement(emailField, emailId, CommonUtils.EXPLICIT_WAIT_TIME); 
	}
	
	public void enterPassword(String password) {
		elementUtils.enterTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_TIME); 
	}
	
	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_TIME); 
		return new AccountPage(driver);
	}
	
	public String getWarningMsgText() {
		return elementUtils.getTextFromElement(warningMsg, CommonUtils.EXPLICIT_WAIT_TIME);
	}
}
