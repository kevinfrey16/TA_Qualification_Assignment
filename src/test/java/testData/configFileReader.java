package testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.driverType;
import enums.environmentType;

public class configFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//Configuration.properties";

	
	public configFileReader(){

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDRIVER_PATH(){

		String DRIVER_PATH = properties.getProperty("DRIVER_PATH");
		if(DRIVER_PATH!= null) return DRIVER_PATH;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}

	public String getUSERNAME(){

		String USERNAME = properties.getProperty("USERNAME");
		if(USERNAME!= null) return USERNAME;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}

	public String getACCESS_KEY(){

		String ACCESS_KEY = properties.getProperty("ACCESS_KEY");
		if(ACCESS_KEY!= null) return ACCESS_KEY;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String getURL() {

		String URL = properties.getProperty("URL");
		if(URL != null) return URL;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getTEST_DATA_RESOURCE_PATH(){

		String TEST_DATA_RESOURCE_PATH = properties.getProperty("TEST_DATA_RESOURCE_PATH");
		if(TEST_DATA_RESOURCE_PATH!= null) return TEST_DATA_RESOURCE_PATH;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
	}

	public driverType getBrowser() {

		String browserName = properties.getProperty("browser");

		if(browserName == null || browserName.equals("chrome")) return driverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return driverType.FIREFOX;
		else if(browserName.equals("edge")) return driverType.EDGE;
		else if(browserName.equals("safari")) return driverType.SAFARI;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public environmentType getEnvironment() {

		String environmentName = properties.getProperty("environment");

		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return environmentType.LOCAL;
		else if(environmentName.equals("remote")) return environmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public String getAPI_USERNAME(){

		String API_USERNAME = properties.getProperty("API_USERNAME");
		if(API_USERNAME!= null) return API_USERNAME;
		else throw new RuntimeException("API_USERNAME not specified in the Configuration.properties file.");		
	}

	public String getAPI_PASSWORD(){

		String API_PASSWORD = properties.getProperty("API_PASSWORD");
		if(API_PASSWORD!= null) return API_PASSWORD;
		else throw new RuntimeException("API_PASSWORD not specified in the Configuration.properties file.");		
	}

	public String getAPI_BASE_URL(){

		String API_BASE_URL = properties.getProperty("API_BASE_URL");
		if(API_BASE_URL!= null) return API_BASE_URL;
		else throw new RuntimeException("API_BASE_URL not specified in the Configuration.properties file.");		
	}

}
