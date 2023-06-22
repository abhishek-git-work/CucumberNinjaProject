package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="HP LP3065")
	private WebElement validProductDisplayInfo;
	
	public String validProductDisplayInfo() 
	{
		return validProductDisplayInfo.getText();
	}
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement noMatchingProductFoundMessage;
	
	public String noMatchingProductFoundMessage() 
	{
		return noMatchingProductFoundMessage.getText();
	}
}
