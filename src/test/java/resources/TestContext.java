package resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {

	public static String accessToken;
	public static String userId;
	public static String productId;
	public static String orders;

	public static RequestSpecification request;
	public static Response response;

}
