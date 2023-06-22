package StepDefinitions;

import java.util.Map;

import org.junit.Assert;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.RegisterPage;
import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.EmailWithTimeStamp;

public class Register extends driverFactory{

	HomePage hp;
	RegisterPage rp;
	AccountPage ap;
	
	@Given("user navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnRegisterButton();
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		rp = new RegisterPage(driver);
		rp.enterFirstname(dataMap.get("firstname"));
		rp.enterLastname(dataMap.get("lastname"));
		rp.enterEmail(EmailWithTimeStamp.emailWithTimeStamp());
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterPasswordConfirm(dataMap.get("password"));
	}

	@When("user enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		rp = new RegisterPage(driver);
		rp.enterFirstname(dataMap.get("firstname"));
		rp.enterLastname(dataMap.get("lastname"));
		rp.enterEmail(dataMap.get("email"));
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterPasswordConfirm(dataMap.get("password"));
	}
	
	@And("user selects Privacy Policy")
	public void user_selects_privacy_policy() {
	    
		rp.aggreePrivacyPolicy();
	}

	@And("user clicks continue button")
	public void user_clicks_continue_button() {
		
		rp.clickOnContinueButton();
	}

	@Then("user account should get created successfully")
	public void user_account_should_get_created_successfully() {
	   
		ap = new AccountPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", ap.AccountCreatedSuccessfullyMessage());
	}

	@And("user select Yes for Newsletter")
	public void user_select_yes_for_newsletter() {
	    
		rp = new RegisterPage(driver);
		rp.yesForNewsletter();
	}

	@Then("user should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	   
		rp = new RegisterPage(driver);
		Assert.assertEquals("Warning: E-Mail Address is already registered!", rp.duplicateEmailWarningMessage());
	}

	@When("user dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   
		rp = new RegisterPage(driver);
	}

	@Then("user should get proper warning massages for every mandatory fields")
	public void user_should_get_proper_warning_massages_for_every_mandatory_fields() {
		
		Assert.assertTrue(rp.warningAboutPrivacyPolicy().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(rp.warningAboutFirstname().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(rp.warningAboutLastname().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(rp.warningAboutEmail().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(rp.warningAboutTelephone().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(rp.warningAboutPassword().contains("Password must be between 4 and 20 characters!"));
	   
	}

	
}
