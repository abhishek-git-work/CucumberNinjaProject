package StepDefinitions;

import org.junit.Assert;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import factory.driverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.EmailWithTimeStamp;


public class Login extends driverFactory{
	
	HomePage hp;
	LoginPage lp;
	AccountPage ap;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnLogin();	   
	}

	@When("^user has entered valid email address (.+) into email field$")
	public void user_has_entered_valid_email_address_into_email_field(String emailText) {
	    
		lp = new LoginPage(driver);
		lp.enterEmailAddress(emailText);
	}

	@And("^user has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
	   
		lp.enterPassword(passwordText);
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    
		lp.clickOnLoginButton();
	}

	@Then("user gets login successfully")
	public void user_gets_login_successfully() {
	    
		ap = new AccountPage(driver);
		Assert.assertTrue(ap.loginSuccessfullyConfirmation());
	}

	@When("user has entered invalid email address into email field")
	public void user_has_entered_invalid_email_address_into_email_field() {
	    
		lp = new LoginPage(driver);
		lp.enterEmailAddress(EmailWithTimeStamp.emailWithTimeStamp());
	}

	@Then("user should get proper warning massage about credentials mismatch")
	public void user_should_get_proper_warning_massage_about_credentials_mismatch() {
	    
		Assert.assertTrue(lp.warningMessageOfCredentialsMissmatch().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user has entered invalid password {string} into password field")
	public void user_has_entered_invalid_password_into_password_field(String invalidPasswordText) {
	    
		lp.enterPassword(invalidPasswordText);
	}

	@When("user dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		lp = new LoginPage(driver);	    
	}

	@And("user dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	    
		lp = new LoginPage(driver);	
	}

}
