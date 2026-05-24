package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.en.Given;
import resources.TestContext;
import resources.TestDataBuild;
import resources.Utils;

public class CreateProductStepDifinitions extends Utils {

	// RequestSpecification request;
	TestDataBuild testDataBuild = new TestDataBuild();

	@Given("Create Product API")
	public void create_product_api() throws IOException {

		TestContext.request = given().header("Authorization", TestContext.accessToken).spec(requestSpecification())

				.param("productName", testDataBuild.createProductPayload().getProductName())

				.param("productAddedBy", testDataBuild.createProductPayload().getProductAddedBy())

				.param("productCategory", testDataBuild.createProductPayload().getProductCategory())

				.param("productSubCategory", testDataBuild.createProductPayload().getProductSubCategory())

				.param("productPrice", testDataBuild.createProductPayload().getProductPrice())

				.param("productDescription", testDataBuild.createProductPayload().getProductDescription())

				.param("productFor", testDataBuild.createProductPayload().getProductFor())

				.multiPart("productImage", new File("/Users/pratheepponnusamy/Desktop/Iphone 15 Pro.png"));
	}

}
