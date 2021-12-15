package stepDefinitions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.webDriverManager;

public class webDriverSetUp {

		static WebDriver driver;
    	static webDriverManager webDriverManager;
		

	    @Before(value= "@UI_Automation")
	    public static WebDriver setUp() throws MalformedURLException{

			webDriverManager = new webDriverManager();
			return driver = webDriverManager.getDriver();
			
		}
		
		public static WebDriver getWebDriverSession() throws MalformedURLException {
			if (driver == null) {
				driver = setUp();
				return driver;
			}
			else {
				return driver;
			}
		}
		
	    @After(value= "@UI_Automation")
	    public void tearDown() throws MalformedURLException{

			getWebDriverSession().close();
			getWebDriverSession().quit();
	    }

}
