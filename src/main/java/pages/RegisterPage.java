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

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstNameFiled;
	@FindBy(id="input-lastname")
	WebElement lastNameFiled;
	@FindBy(id="input-email")
	WebElement emailFiled;
	@FindBy(id="input-telephone")
	WebElement telephoneField;
	@FindBy(id="input-password")
	WebElement passwordFiled;
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetter;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsgDuplicateEmail;
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningMsgFirstNameField;

	
	
	public void enterFirstName(String firstNameText) {
		elementUtils.enterTextIntoElement(firstNameFiled, firstNameText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public void enterLastName(String lastNameText) {
		elementUtils.enterTextIntoElement(lastNameFiled, lastNameText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public void enterEmil(String emailText) {
		elementUtils.enterTextIntoElement(emailFiled, emailText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public void enterTelephone(String telephoneText) {
		elementUtils.enterTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public void enterPassword(String passwordText) {
		elementUtils.enterTextIntoElement(passwordFiled, passwordText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		elementUtils.enterTextIntoElement(confirmPasswordField, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_TIME);
	} 
	public void selectPrivacyPolicyOption() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_TIME); 
		return new AccountSuccessPage(driver);
	}
	public void clickOnYesToNewsLetter() {
		elementUtils.clickOnElement(newsLetter, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	public String getWarningMsgText() {
		return elementUtils.getTextFromElement(warningMsgDuplicateEmail, CommonUtils.EXPLICIT_WAIT_TIME); 
	}
	public String getWarningMsgFirstNameFieldText() {
		return elementUtils.getTextFromElement(warningMsgFirstNameField, CommonUtils.EXPLICIT_WAIT_TIME); 
	}
}
