package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import managers.fileReaderManager;
import testData.pets_API;
import testData.users_API;

public class thenAPI {

    private static Response response;

    @Then("I search for the pet in the system")
	public void I_search_for_the_pet_in_the_system() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        pets_API pet = fileReaderManager.getInstance().getPetsApiJsonReader().getPetById(1256);
		
        request.header("Content-Type", "application/json");
        response = request.pathParam("petId", pet.id)
                .get("/pet/{petId}");
        
        ResponseBody body = response.getBody();

        String bodyAsString = body.asString();
	    Assert.assertEquals(bodyAsString.contains(pet.id.toString()), true);
        Assert.assertEquals(bodyAsString.contains(pet.name), true);
        Assert.assertEquals(bodyAsString.contains(pet.category.name), true);
        Assert.assertEquals(bodyAsString.contains(pet.category.id.toString()), true);
        Assert.assertEquals(bodyAsString.contains(pet.status), true);

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
	}

    @Then("I search for the order in the system")
	public void I_search_for_the_order_in_the_system() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        pets_API pet = fileReaderManager.getInstance().getPetsApiJsonReader().getPetById(1256);
        Integer orderId = 6;
		
        request.header("Content-Type", "application/json");
        response = request.pathParam("orderId", orderId)
                .get("/store/order/{orderId}");
        
        ResponseBody body = response.getBody();

        String bodyAsString = body.asString();
	    Assert.assertEquals(bodyAsString.contains(orderId.toString()), true);
        Assert.assertEquals(bodyAsString.contains(pet.id.toString()), true);
        Assert.assertEquals(bodyAsString.contains("placed"), true);

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
	}

    @Then("I delete the order in the system")
	public void I_delete_the_order_in_the_system() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        Integer orderId = 6;
		
        request.header("Content-Type", "application/json");
        response = request.pathParam("orderId", orderId)
                .delete("/store/order/{orderId}");

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
	}

    @Then("I search for the user in the system")
	public void I_search_for_the_user_in_the_system() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        String newPhoneNumber = "6666663322";
        
        users_API user = fileReaderManager.getInstance().getUserApiJsonReader().getUser_requested("SteveJ");
		
        request.header("Content-Type", "application/json");
        response = request.pathParam("username", user.username)
                .get("/user/{username}");
        
        ResponseBody body = response.getBody();

        String bodyAsString = body.asString();
	    Assert.assertEquals(bodyAsString.contains(user.id.toString()), true);
        Assert.assertEquals(bodyAsString.contains(user.username), true);
        Assert.assertEquals(bodyAsString.contains(user.password), true);
        Assert.assertEquals(bodyAsString.contains(user.firstName), true);
        Assert.assertEquals(bodyAsString.contains(user.lastName), true);

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
	}

}
