package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.APIResources;
import resources.TestContext;
import resources.TestDataBuild;
import resources.Utils;

public class LoginStepDefinitions extends Utils {
	
	//RequestSpecification request;
	//public static Response response;
	
	TestDataBuild testData = new TestDataBuild();
	
	@Given("Login payload with {string} and {string}")
	public void login_payload_with_and(String userEmail, String userPassword) throws IOException {
	   
		TestContext.request = given().spec(requestSpecification()).header("Content-Type", "application/json").
				body(testData.loginPayload(userEmail, userPassword));
		
	}
	
	@When("User calls {string} API with {string} HTTP method")
	public void user_calls_api_with_http_method(String resource, String httpMethod) {
	    APIResources apiResources = APIResources.valueOf(resource);
	    
	    if(httpMethod.equalsIgnoreCase("POST")) {
	    	TestContext.response = TestContext.request.when().log().ifValidationFails().post(apiResources.getAPIResource());
	    }
	    else if(httpMethod.equalsIgnoreCase("DELETE")) {
	    	TestContext.response = TestContext.request.when().delete(apiResources.getAPIResource());
	    }
	    
	}
	
	@Then("API success with status code {int}")
	public void api_success_with_status_code(Integer expectedStatusCode) {
		
	   int actualStatusCode = TestContext.response.getStatusCode();
	   System.out.println("Actual Login Status code: " + actualStatusCode);
	   System.out.println("Expected Login Status code: " + expectedStatusCode);
	   
	   Assert.assertEquals(actualStatusCode, expectedStatusCode);
	   
	  String res = TestContext.response.asString();
	  
	  if(res.contains("token")) {
		  TestContext.accessToken = getJsonPath(TestContext.response, "token");
		  //System.out.println(TestContext.accessToken);
	  }
	  
	  if(res.contains("userId")) {
		  TestContext.userId = getJsonPath(TestContext.response, "userId");
		  //System.out.println(TestContext.userId);
	  }
	  
	  if(res.contains("productId")) {
		 TestContext.productId = getJsonPath(TestContext.response, "productId");
		 System.out.println("Product ID: " + TestContext.productId);
	  }
	  
	}
	@Then("{string} response body is {string}")
	public void response_body_is(String key, String expectedLoginSuccessMessage) {
	   
		String actualLoginSuccessMessage = getJsonPath(TestContext.response, key);
		
		System.out.println("Actual Login Success Message: " + actualLoginSuccessMessage);
		System.out.println("Expected Login Success Message: " + expectedLoginSuccessMessage);
		
		Assert.assertEquals(actualLoginSuccessMessage, expectedLoginSuccessMessage);
		
	}

}
