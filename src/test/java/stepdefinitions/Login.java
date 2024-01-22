/**
 * 
 */
package stepdefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	
	@Given("User has navigate to login page")
	public void user_has_navigate_to_login_page() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}

	@When("^User has to enter valid email address (.+) into email field$")
	public void user_has_to_enter_valid_email_address_into_email_field(String validEmail) {
	    
	    loginPage.enterEmailAddress(validEmail);
	}

	@When("^User has to enter valid password (.+) into password fill$")
	public void user_has_to_enter_valid_password_into_password_fill(String validPassword) {
		
		loginPage.enterPassword(validPassword);
	}

	@When("click the login button")
	public void click_the_login_button() {
	    accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully loged in")
	public void user_should_get_successfully_loged_in() {
				
	    Assert.assertTrue(accountPage.displayStatusOfEditYourPasswordOption());
	}

	@When("User has to enter invalid email address into email field")
	public void user_has_to_enter_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
	}

	@When("User has to enter invalid password {string} into password fill")
	public void user_has_to_enter_invalid_password_into_password_fill(String invalidPassword) {
		loginPage.enterPassword(invalidPassword);
	}

	@Then("User should get a proper warning message about credential missmatch")
	public void user_should_get_a_proper_warning_message_about_credential_missmatch() {
	    Assert.assertTrue(loginPage.getWarningMsgText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User do not enter email address into email field")
	public void user_do_not_enter_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
	}

	@When("User do not enter password into password fill")
	public void user_do_not_enter_password_into_password_fill() {
		loginPage.enterPassword("");
	}


	
}
