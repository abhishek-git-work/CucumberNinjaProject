package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement enterEmailAddress;
	
	public void enterEmailAddress(String emailText) 
	{
		enterEmailAddress.sendKeys(emailText);
	}
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement enterPassword;
	
	public void enterPassword(String passwordText) 
	{
		enterPassword.sendKeys(passwordText);
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement clickOnLoginButton;
	
	public void clickOnLoginButton()
	{
		clickOnLoginButton.click();
	}
	
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement warningMessageOfCredentialsMissmatch;
	
	public String warningMessageOfCredentialsMissmatch()
	{
		return warningMessageOfCredentialsMissmatch.getText();
	}
}
