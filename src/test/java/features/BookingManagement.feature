Feature: Booking management for RESTful Booking API

Background:
Given Set the baseURI for Restful booker API
And Set the user credentials for authenticating the system


@Create @API
Scenario: TC001 Create a POST Request with body in the request
When User send POST request to RESTful booker API
Then Validate the status code is 200


Scenario: TC002 Create a Get Request with no body in the request
When User send GET request to Restful booker API
Then Validate the status code is 200

Scenario: TC003 Create a PUT request with UPDATED body
When User send PUT request to RESTful booker API
Then Validate the status code is 201


  Scenario Outline: TC004  create a DELETE request
    When User send a DELETE request to RESTful booker API
    Then Validate the status code is <statusCode>


Examples:
|statusCode   |
|200          |
