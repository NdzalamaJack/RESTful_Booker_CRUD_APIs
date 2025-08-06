package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features ="src/test/java/features/BookingManagement.feature",
				glue ="stepsDefn",
				publish = true,
				monochrome = true)
public class RunCucumberTest extends AbstractTestNGCucumberTests{

}
