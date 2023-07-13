//@Before and @After hooks will run before and after every scenario
//@BeforeStep and @AfterStep hooks will run before and after every steps in scenario
//@BeforeAll and @AfterAll hooks will run once before any scenario is run and after all scenario have been run.
//there can be many same type of hooks in project and we can give the order to execute that same hooks
//order for @Before hooks is ascending type i.e.@Before(order=0,1,...) and for @After hooks is descending type i.e. @After(order=3,2,1..)
//we can also give tags to hooks, so it will run only for that specific tag scenarios 
//user value attribute for taged hooks i.e.@Before(value="@search")
//we can use multiple tags in one hook i.e. @Before(value="@search", order=1)

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
