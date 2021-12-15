package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.fileReaderManager;
import testData.users_API;

public class givenAPI {

	private static Response response;

    @Given("I create user account")
	public void I_create_user_account() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        users_API user = fileReaderManager.getInstance().getUserApiJsonReader().getUser_requested("SteveJ");
		
        request.header("Content-Type", "application/json");
		response = request.body("{ \"id\":\"" + user.id + "\",\"username\":\"" + user.username + "\", \"firstName\":\"" + user.firstName + "\", \"lastName\":\"" + user.lastName +
                 "\", \"email\":\"" + user.email + "\", \"password\":\"" + user.password + "\", \"phone\":\"" + user.phone + "\", \"userStatus\":\"" + user.userStatus + "\"}")
				.post("/user");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
	}

    @Given("I login into the system")
	public void I_login_into_the_system() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        users_API user = fileReaderManager.getInstance().getUserApiJsonReader().getUser_requested("SteveJ");
		
        request.header("Content-Type", "application/json");
		response = request.queryParam("username", user.username) 
				                   .queryParam("password", user.password) 
				                   .get("/user/login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("logged in user session"), true);
	}



}
