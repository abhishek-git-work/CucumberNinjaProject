package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement enterFirstname;
	
	public void enterFirstname(String firstnameText) 
	{
		enterFirstname.sendKeys(firstnameText);
	}
	
	@FindBy(id="input-lastname")
	private WebElement enterLastname;
	
	public void enterLastname(String lastnameText) 
	{
		enterLastname.sendKeys(lastnameText);
	}
	
	@FindBy(id="input-email")
	private WebElement enterEmail;
	
	public void enterEmail(String emailText) 
	{
		enterEmail.sendKeys(emailText);
	}
	
	@FindBy(id="input-telephone")
	private WebElement enterTelephone;
	
	public void enterTelephone(String telephoneText) 
	{
		enterTelephone.sendKeys(telephoneText);
	}
	
	@FindBy(id="input-password")
	private WebElement enterPassword;
	
	public void enterPassword(String passwordText) 
	{
		enterPassword.sendKeys(passwordText);
	}
	
	@FindBy(id="input-confirm")
	private WebElement enterPasswordConfirm;
	
	public void enterPasswordConfirm(String passwordText) 
	{
		enterPasswordConfirm.sendKeys(passwordText);
	}
	
	@FindBy(name="agree")
	private WebElement aggreePrivacyPolicy;
	
	public void aggreePrivacyPolicy() 
	{
		aggreePrivacyPolicy.click();
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement clickOnContinueButton;
	
	public void clickOnContinueButton() 
	{
		clickOnContinueButton.click();
	}

	@FindBy(xpath="//label[text()='Yes']")
	private WebElement yesForNewsletter;
	
	public void yesForNewsletter() 
	{
		yesForNewsletter.click();
	}
	
	@FindBy(xpath="//div[normalize-space()='Warning: E-Mail Address is already registered!']")
	private WebElement duplicateEmailWarningMessage;
	
	public String duplicateEmailWarningMessage() 
	{
		return duplicateEmailWarningMessage.getText();
	}
	
	@FindBy(xpath="//div[normalize-space()='Warning: You must agree to the Privacy Policy!']")
	private WebElement warningAboutPrivacyPolicy;
	
	public String warningAboutPrivacyPolicy() 
	{
		return warningAboutPrivacyPolicy.getText();
	}
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement warningAboutFirstname;
	
	public String warningAboutFirstname() 
	{
		return warningAboutFirstname.getText();
	}
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement warningAboutLastname;
	
	public String warningAboutLastname() 
	{
		return warningAboutLastname.getText();
	}
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement warningAboutEmail;
	
	public String warningAboutEmail() 
	{
		return warningAboutEmail.getText();
	}
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement warningAboutTelephone;
	
	public String warningAboutTelephone() 
	{
		return warningAboutTelephone.getText();
	}
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement warningAboutPassword;
	
	public String warningAboutPassword() 
	{
		return warningAboutPassword.getText();
	}
}
