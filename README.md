# RESTful Booker CRUD API Automation

This project demonstrates end-to-end API automation testing on the [RESTful Booker](https://restful-booker.herokuapp.com/) platform using **Java**, **Selenium**, 
**RestAssured**, **TestNG**, and **Cucumber** in a **hybrid framework** structure.

## Technologies Used

- **Java**
- **RestAssured** – for API requests
- **Selenium** – for demonstration integration (optional)
- **TestNG** – for test configuration and assertions
- **Cucumber** – for BDD-style scenarios
- **Maven** – for dependency management


## Key Features

- Full **CRUD operations** (Create, Read, Update, Delete) using RestAssured.
- **Hybrid testing** approach combining **TestNG** and **Cucumber** for flexibility.
- Centralized **Base Class** for setup and authentication.
- Easy-to-maintain modular structure.
- Clear **Gherkin syntax** for business-readable test scenarios.


## ✅ How to Run

1. **Clone the repository**  
   ```bash
   git clone https://github.com/NdzalamaJack/RESTful_Booker_CRUD_APIs.git
   cd RESTful_Booker_CRUD_APIs
2. **Run with TestNG**
  Open and execute TestNG_Runner.xml from your IDE or terminal.

3. **Run with Cucumber (Hybrid)**
Execute Testng_AND_Cucumber(Hybrid_Runner).xml for combined BDD + TestNG functionality.

**Author**
Ndzalama Mahlaule
Reach me via GitHub: @NdzalamaJack


**PROJECT STRUCTURE**

RESTful_Booker_CRUD_APIs/
│
├── .allure/                       # Allure configuration
├── .idea/                         # IntelliJ project settings
├── data/
├── src/
│   └── test/
│       ├── java/
│       │   ├── chaining/          # CRUD logic
│       │   │   ├── BaseAPISteps.java
│       │   │   ├── CreateBooking.java
│       │   │   ├── deleteBooking.java
│       │   │   ├── GetBooking.java
│       │   │   └── putBooking.java
│       │   │
│       │   ├── runner/            # Cucumber runner class
│       │   │   └── RunCucumberTest.java
│       │   │
│       │   └── stepsDefn/         # Step definitions
│       │       └── BookingManagementSteps.java
│       │
│       └── resources/
│           ├── features/          # Cucumber feature files
│           │   └── BookingManagement.feature
│           ├── allure.properties
│           ├── categories.json
│           └── config.properties
│
├── target/                        # Compiled outputs
├── test-output/                   # TestNG output
├── pom.xml                        # Maven configuration
├── TestNG_Runner.xml             # Runs TestNG chaining classes
└── Testng_AND_Cucumber(Hybrid_Runner).xml  # Hybrid runner (Cucumber + TestNG)


