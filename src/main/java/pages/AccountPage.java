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

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Change your password")
	private WebElement changeYourPasswordOption;
	
	
	public boolean displayStatusOfEditYourPasswordOption() {
		return elementUtils.displayStatusOfElement(changeYourPasswordOption, CommonUtils.EXPLICIT_WAIT_TIME); 
	}
}
