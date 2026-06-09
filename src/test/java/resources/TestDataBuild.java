package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.CreateOrder;
import pojo.CreateOrderRequest;
import pojo.CreateProductRequest;
import pojo.LoginRequest;

public class TestDataBuild {
	
	
	
	public LoginRequest loginPayload(String userEmail, String userPassword) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail(userEmail);
		loginRequest.setUserPassword(userPassword);
		return loginRequest;
	}
	
	public CreateProductRequest createProductPayload() {
		
		CreateProductRequest createProductRequest = new CreateProductRequest();
		createProductRequest.setProductName("iPhone 15 Pro");
		createProductRequest.setProductAddedBy(TestContext.userId);
		createProductRequest.setProductCategory("Electronics");
		createProductRequest.setProductSubCategory("IPhone");
		createProductRequest.setProductPrice("120000");
		createProductRequest.setProductDescription("Iphone 15 Pro");
		createProductRequest.setProductFor("All");
		return createProductRequest;
	}
	
	public CreateOrderRequest createOrderPayload(String productOrderedId) {
		CreateOrder createOrder = new CreateOrder();
		createOrder.setCountry("India");
		createOrder.setProductOrderedId(productOrderedId);
		List<CreateOrder> orderDetails = new ArrayList<CreateOrder>();
		orderDetails.add(createOrder);
		CreateOrderRequest createOrderRequest = new CreateOrderRequest();
		createOrderRequest.setOrders(orderDetails);
		return createOrderRequest;
	}

}
