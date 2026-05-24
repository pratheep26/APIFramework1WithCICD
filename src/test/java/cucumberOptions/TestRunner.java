package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
				glue = "stepDefinitions",
				plugin = {
						"json:target/jsonReports/cucumber-report.json",
						"html:target/cucumber-report.html"},
				
				tags = ""
			)
				

public class TestRunner extends AbstractTestNGCucumberTests {

}
