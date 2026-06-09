package stepDefinitions;

import io.cucumber.java.en.Given;
import resources.TestContext;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.*;

import java.io.IOException;

public class CreateOrderStepDefinitions extends Utils{
	
	TestDataBuild testDataBuild = new TestDataBuild();
	
	@Given("Create Order API")
	public void create_order_api() throws IOException {
	    
	TestContext.request = 	given().log().all().spec(requestSpecification()).header("Authorization", TestContext.accessToken)
		.header("Content-Type", "application/json").body(testDataBuild.createOrderPayload(TestContext.productId));
	}

}
