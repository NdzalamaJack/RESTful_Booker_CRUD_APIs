package stepsDefn;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingManagementSteps {
	
	RequestSpecification inputRequest;
	Response response;
	String sys_id;

	@BeforeTest
	@Given("Set the baseURI for Restful booker API")
	public void setEndPOint() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}

	@BeforeTest
	@Given("Set the user credentials for authenticating the system")
	public void setAuth() {
		RestAssured.authentication = RestAssured.basic("admin","password123");
	}

	@Test(priority = 1)
	@When("User send POST request to RESTful booker API")
	public void POSTRequest() {
		String postBody = "{\n" +
				"    \"firstname\": \"Ndzalama\",\n" +
				"    \"lastname\": \"Mahlaule\",\n" +
				"    \"totalprice\": 111,\n" +
				"    \"depositpaid\": true,\n" +
				"    \"bookingdates\": {\n" +
				"        \"checkin\": \"2025-06-10\",\n" +
				"        \"checkout\": \"2025-06-15\"\n" +
				"    },\n" +
				"    \"additionalneeds\": \"Breakfast\"\n" +
				"}";

		response = RestAssured.given().header("Content-Type","application/json").body(postBody).post("/booking");
		response.prettyPrint();
		sys_id = response.jsonPath().getString("result.sys_id");
		int statusCode = response.getStatusCode();
		System.out.println("The status code for POST is: "+statusCode);
		System.out.println("The system ID for POST request is : "+sys_id);
	}

	@Test(priority = 2)
	@When("User send GET request to Restful booker API")
	public void GetRequest() {

		response = RestAssured.given().get("/booking");
		int statusCode = response.getStatusCode();
		response.getBody().prettyPrint();
		System.out.println("Get status code is: "+statusCode);
		sys_id = response.jsonPath().getString("result.sys_id");
		//response.prettyPrint();

	}
	@Test(priority = 3)
	@When("User send PUT request to RESTful booker API")
	public void PUTRequest() {

		//int sys_id ;
		String putBody = "{\n" +
				"    \"firstname\": \"Jack\",\n" +
				"    \"lastname\": \"Mahlaule\",\n" +
				"    \"totalprice\": 3000,\n" +
				"    \"depositpaid\": true,\n" +
				"    \"bookingdates\": {\n" +
				"        \"checkin\": \"2025-06-10\",\n" +
				"        \"checkout\": \"2025-06-15\"\n" +
				"    },\n" +
				"    \"additionalneeds\": \"Breakfast\"\n" +
				"}";

		response= RestAssured.given().header("Content-Type","application/json").body(putBody).put("/booking/"+sys_id+"/");

		response.prettyPrint();

		int statusCode = response.getStatusCode();

		System.out.println("The status code for the Update is: "+statusCode);


	}

	@Test(priority = 4)
	@When("User send a DELETE request to RESTful booker API")
	public void deleteRequest() {

		int sys_id = 2391;
		response= RestAssured.given().delete("/booking"+sys_id);
		int statusCode = response.getStatusCode();
		System.out.println("The status code for the DELETE is: "+statusCode);

		response.prettyPrint();

	}
	
	@Then("Validate the status code is {int}")
	public void validateStatusCode(Integer statusCode) {
		response.then().assertThat().statusCode(Matchers.equalTo(statusCode));
	}

}
