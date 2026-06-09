package stepDefinitions;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.TestContext;
import resources.Utils;

public class DeleteOrderStepDefinitions extends Utils{
	
	@Given("Delete Order API")
	public void delete_order_api() throws IOException {
	   TestContext.request = given().log().all().spec(requestSpecification())
	    .header("Authorization", TestContext.accessToken)
	    .pathParam("orders", TestContext.orders);
	}

}
