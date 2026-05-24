package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification request;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(request == null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		request = new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
		.build();
		}
		return request;
	}
	
	public String getGlobalProperties(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream
				(System.getProperty("user.dir") + "/src/test/java/resources/global.properties");
				properties.load(fis);
				return properties.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key) {
		
		String res = response.asString();
		
		if(res == null || res.isEmpty()) {
			  throw new RuntimeException("Response is empty, cannot parse JSON");
		}
		JsonPath js = new JsonPath(res);
		Object value = js.get(key);
		
		if(value == null) {
			System.out.println("Key not found in response: " + key);
	        return "";
		}
		return value.toString();
	}

}
