package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateBooking extends BaseAPISteps {
	
	@Test(priority = 1)
	public void createBooking() {

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

        response.then().statusCode(200);

		int statusCode = response.getStatusCode();
		System.out.println("The status code is: "+statusCode);

		sys_id = response.body().jsonPath().getString("result.sys_id");
		System.out.println("Sys_id retrived from the response: "+sys_id);

		
		
	}

}
