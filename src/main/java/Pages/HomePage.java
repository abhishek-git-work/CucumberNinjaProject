package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccount() 
	{
		myAccountDropMenu.click();
	}
	
	@FindBy(linkText="Login")
	private WebElement clickOnLogin;
	
	public void clickOnLogin() 
	{
		clickOnLogin.click();
	}
	
	@FindBy(linkText="Register")
	private WebElement clickOnRegisterButton;
	
	public void clickOnRegisterButton() 
	{
		clickOnRegisterButton.click();;
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement enterTextIntoSearcbox;
	
	public void enterTextIntoSearcbox(String validProductText) 
	{
		enterTextIntoSearcbox.sendKeys(validProductText);
	}
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement clickOnSearchButton;
	
	public void clickOnSearchButton() 
	{
		clickOnSearchButton.click();;
	}
}
