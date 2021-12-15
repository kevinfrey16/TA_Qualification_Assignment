package managers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import enums.driverType;
import enums.environmentType;
import testData.configFileReader;

public class webDriverManager {

    private WebDriver driver;
    public static configFileReader configReader;
	private static driverType driverType;
	private static environmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";



	public webDriverManager() {
		driverType = fileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = fileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() throws MalformedURLException {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() throws MalformedURLException {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}

	private WebDriver createRemoteDriver() throws MalformedURLException {
        
            configReader = new configFileReader();
			String URL = "https://" + fileReaderManager.getInstance().getConfigReader().getUSERNAME() + ":" + fileReaderManager.getInstance().getConfigReader().getACCESS_KEY() + "@ondemand.saucelabs.com:443/wd/hub";

			DesiredCapabilities caps = DesiredCapabilities.chrome();
    		caps.setCapability("platform", "Windows 10");
    		caps.setCapability("version", "latest");
 
    		driver = new RemoteWebDriver(new URL(URL), caps);
			return driver;
	}

	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, fileReaderManager.getInstance().getConfigReader().getDRIVER_PATH());
        	driver = new ChromeDriver();
    		break;
        case EDGE : driver = new EdgeDriver();
    		break;
        case SAFARI : driver = new SafariDriver();
	    	break;
        }
        return driver;

	}	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
