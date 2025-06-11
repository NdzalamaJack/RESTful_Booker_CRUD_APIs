package chaining;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class putBooking extends BaseAPISteps{

    @Test(priority = 3)
    public void putBooking(){

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

        response= RestAssured.given().header("Content-Type","application/json").body(putBody).put("/booking");

        int statusCode = response.getStatusCode();

        System.out.println("The status code for the Update is: "+statusCode);



    }

}
