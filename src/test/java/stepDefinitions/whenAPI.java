package stepDefinitions;

import java.io.File;

import org.junit.Assert;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.fileReaderManager;
import testData.pets_API;
import testData.users_API;

public class whenAPI {

    private static Response response;

    @When("I add a new pet")
	public void I_add_a_new_pet() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        pets_API pet = fileReaderManager.getInstance().getPetsApiJsonReader().getPetById(1256);
		
        request.header("Content-Type", "application/json");
        response = request.body("{ \"id\":" + pet.id + ", \"category\": { \"id\": " + pet.category.id + ", \"name\": \"" + pet.category.name + "\" }, \"name\": \"" + pet.name +
                 "\", \"photoUrls\": [ \"" + pet.photoUrls + "\" ], \"tags\": [ { \"id\": " + pet.tags.id + ", \"name\": \"" + pet.tags.name + "\"} ], \"status\":\" " + pet.status + "\"}")
				.post("/pet");

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
	}

    @When("I upload the pet photo")
	public void I_upload_the_pet_photo() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        File file = new File("/Users/kf0621/Desktop/Astrik Workspace/assignment/src/test/resources/utils/images/resize-images-print-photoshop-f.jpg");
        
        pets_API pet = fileReaderManager.getInstance().getPetsApiJsonReader().getPetById(1256);
		
        response = request.pathParam("petId", pet.id)
                .multiPart("file", file,"application/json")
				.post("/pet/{petId}/uploadImage");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

	}

    @When("I place an order")
	public void I_place_an_order() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        
        pets_API pet = fileReaderManager.getInstance().getPetsApiJsonReader().getPetById(1256);
		
        request.header("Content-Type", "application/json");
        response = request.body("{ \"id\": 6,\"petId\":" + pet.id + 
                ", \"quantity\": 1, \"shipDate\":\"2021-12-15T07:24:25.471Z\", \"status\":\"placed\", \"complete\": true }")
				.post("/store/order");

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

	}

    @When("I update user information")
	public void I_update_user_information() {

		RestAssured.baseURI = fileReaderManager.getInstance().getConfigReader().getAPI_BASE_URL();
        RequestSpecification request = RestAssured.given();
        String newPhoneNumber = "6666663322";
        
        users_API user = fileReaderManager.getInstance().getUserApiJsonReader().getUser_requested("SteveJ");
		
        request.header("Content-Type", "application/json");
        response = request.pathParam("username", user.username)
                .body("{ \"id\":\"" + user.id + "\",\"username\":\"" + user.username + "\", \"firstName\":\"" + user.firstName + "\", \"lastName\":\"" + user.lastName +
                "\", \"email\":\"" + user.email + "\", \"password\":\"" + user.password + "\", \"phone\":\"" + newPhoneNumber + "\", \"userStatus\":\"" + user.userStatus + "\"}")
				.put("/user/{username}");

		int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

	}

}
