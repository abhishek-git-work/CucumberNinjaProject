package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Constants;
import utils.configReader;

public class MyHooks extends driverFactory{
		
	
	@Before
	public void setup() throws IOException
	{
		Properties prop = configReader.intializeProperties();
		driverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName = scenario.getName().replace(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] srnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srnshot, "image/png", scenarioName);
		}
		
		driver.quit();
	}

}
