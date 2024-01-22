/**
 * 
 */
package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;


public class Search {

	WebDriver driver;
	private HomePage homePage;
	SearchResultPage searchResultPage;
	private DriverFactory driverFactory;
	
	@Given("User navigate to search page")
	public void user_navigate_to_search_page() {
		driverFactory = new DriverFactory();
	  driver =  driverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search Box field")
	public void user_enters_valid_product_into_search_box_field(String validProductName) {
		homePage = new HomePage(driver);
		homePage.enterProductSearchBoxField(validProductName);
	    
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
	   searchResultPage = homePage.clickOnSearchButton();
	}

	@Then("user should get valid prouct displayed in search results")
	public void user_should_get_valid_prouct_displayed_in_search_results() {
		 		
	    Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search Box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductName) {
		homePage = new HomePage(driver);
		homePage.enterProductSearchBoxField(invalidProductName);
		
	}

	@Then("user should get a no message about no procut mathces")
	public void user_should_get_a_no_message_about_no_procut_mathces() {
				
	    Assert.assertEquals("There is no product that matches the search criteria.",searchResultPage.getMsgText());
	}

	@When("User do not enter any product into Search Box field")
	public void user_do_not_enter_any_product_into_search_box_field() {
	   homePage = new HomePage(driver);
	}


}
