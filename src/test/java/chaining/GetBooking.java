package chaining;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBooking extends BaseAPISteps{

    @Test(priority = 2)
    public void GetBooking() {

      response = RestAssured.given().get("/booking");

      int statusCode = response.getStatusCode();

      System.out.println("Get status code is: "+statusCode);

      response.prettyPrint();



    }




}
