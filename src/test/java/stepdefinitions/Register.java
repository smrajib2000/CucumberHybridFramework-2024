/**
 * 
 */
package stepdefinitions;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	
	@Given("User navigates to Regsiter Account page")
	public void user_navigates_to_regsiter_account_page() {
		driverFactory = new DriverFactory();
		driver= driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickOnRegisterLink();	   
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
		 Map<String, String> dataMap= dataTable.asMap(String.class, String.class);
		 commonUtils = new CommonUtils();
		 registerPage.enterFirstName(dataMap.get("firstName"));
		 registerPage.enterLastName(dataMap.get("lastName"));
		 registerPage.enterEmil(commonUtils.getEmailWithTimeStamp());
		 registerPage.enterTelephone(dataMap.get("telephone"));
		 registerPage.enterPassword(dataMap.get("password"));
		 registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}


	@When("User enters the details into the below fields with duplicate email")
	public void user_enters_the_details_into_the_below_fields_with_duplicate_email(DataTable dataTable) {
		 Map<String, String> dataMap= dataTable.asMap(String.class, String.class);
		
		 registerPage.enterFirstName(dataMap.get("firstName"));
		 registerPage.enterLastName(dataMap.get("lastName"));
		 registerPage.enterEmil(dataMap.get("email"));
		 registerPage.enterTelephone(dataMap.get("telephone"));
		 registerPage.enterPassword(dataMap.get("password"));
		 registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	
	@When("User click on privacy policy")
	public void user_click_on_privacy_policy() {
	  registerPage.selectPrivacyPolicyOption();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		accountSuccessPage= registerPage.clickOnContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
				
	   Assert.assertEquals("Register Account", accountSuccessPage.getPageHeading());
	}

	@When("User should select Yes for newsletter")
	public void user_should_select_yes_for_newsletter() {
		registerPage.clickOnYesToNewsLetter();
	    
	}

	@Then("User account should get proper warning about duplicate email")
	public void user_account_should_get_proper_warning_about_duplicate_email() {
		
	   Assert.assertTrue(registerPage.getWarningMsgText().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	@When("User do not enters any details into fields")
	public void user_do_not_enters_any_details_into_fields() {
		
		registerPage.enterFirstName("");
		 registerPage.enterLastName("");
		 registerPage.enterEmil("");
		 registerPage.enterTelephone("");
		 registerPage.enterPassword("");
		 registerPage.enterConfirmPassword("");
	}

	@Then("User account should get proper warning messages for every mandatory fields")
	public void user_account_should_get_proper_warning_messages_for_every_mandatory_fields() {
		 Assert.assertTrue(registerPage.getWarningMsgText().contains("Warning: You must agree to the Privacy Policy!"));
		 Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getWarningMsgFirstNameFieldText());
	}

	

	
}
