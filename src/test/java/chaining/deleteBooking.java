package chaining;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class deleteBooking extends BaseAPISteps{

    @Test(priority = 4)
    public void deleteBooking(){

        response = RestAssured.given().delete();

        int statusCode = response.getStatusCode();

        System.out.println("The status code for Delete is "+statusCode);
    }
}
