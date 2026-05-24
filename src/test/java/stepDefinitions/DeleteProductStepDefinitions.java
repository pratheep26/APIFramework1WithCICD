package stepDefinitions;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import resources.*;

public class DeleteProductStepDefinitions extends Utils {
	
	@Given("Delete Product API")
	public void delete_product_api() throws IOException {
	    
	TestContext.request =	given().log().all().spec(requestSpecification()).header("Authorization", TestContext.accessToken)
			.pathParam("productId", TestContext.productId);
		
	}

}
