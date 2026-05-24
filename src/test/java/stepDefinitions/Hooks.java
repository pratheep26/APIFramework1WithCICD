package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.Before;
import resources.APIResources;
import resources.TestContext;
import resources.TestDataBuild;
import resources.Utils;

public class Hooks extends Utils {
	
	//RequestSpecification request;
    //Response response;
	
	TestDataBuild testData = new TestDataBuild();

	@Before("@CreateProduct")
	public void beforeScenario() throws IOException {
		TestContext.request = given()
                .spec(requestSpecification())
                .header("Content-Type", "application/json")

                .body(testData.loginPayload(getGlobalProperties("userEmail"),
                		getGlobalProperties("userPassword")));

		TestContext.response = TestContext.request.when()
                .post(APIResources.Login.getAPIResource());

        TestContext.accessToken = getJsonPath(TestContext.response, "token");

        TestContext.userId = getJsonPath(TestContext.response, "userId");

        System.out.println("Token: " + TestContext.accessToken);
        System.out.println("UserId: " + TestContext.userId);

	}
}
