package chaining;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BaseAPISteps {
	Response response;
	String sys_id;
	
	@BeforeTest
	public void preSteps() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RestAssured.authentication = RestAssured.basic("admin","password123");
	}
	
	@AfterMethod
	public void postSteps() {

		response.then().log().all();
	}

}
