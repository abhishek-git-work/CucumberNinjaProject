package StepDefinitions;

import org.junit.Assert;

import Pages.HomePage;
import Pages.SearchResultPage;
import factory.driverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search extends driverFactory{
	
	HomePage hp;
	SearchResultPage sp;
	
	@Given("user opens the application")
	public void user_opens_the_application() {
		
		hp = new HomePage(driver);	    
	}

	@When("user enters valid product {string} into Seach box field")
	public void user_enters_valid_product_into_seach_box_field(String validProductText) {
	    
		hp = new HomePage(driver);
		hp.enterTextIntoSearcbox(validProductText);
	}

	@And("user clicks on Search button")
	public void user_clicks_on_search_button() {
		
		hp.clickOnSearchButton();
	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	   
		sp = new SearchResultPage(driver);
		Assert.assertEquals("HP LP3065", sp.validProductDisplayInfo());
//		Assert.fail();
	}

	@When("user enters invalid product {string} into Seach box field")
	public void user_enters_invalid_product_into_seach_box_field(String invalidProductText) {
	    
		hp = new HomePage(driver);
		hp.enterTextIntoSearcbox(invalidProductText);
	}

	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	    
		sp = new SearchResultPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.", sp.noMatchingProductFoundMessage());
	}

	@When("user dont enters any product name into Seach box field")
	public void user_dont_enters_any_product_name_into_seach_box_field() {
	   
		hp = new HomePage(driver);
	}

}
