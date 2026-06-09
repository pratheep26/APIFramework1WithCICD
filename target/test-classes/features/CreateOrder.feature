Feature: Validate Create Order API

@Regression
Scenario Outline:
	
	Given Login payload with "<userEmail>" and "<userPassword>"
	When User calls "Login" API with "POST" HTTP method
	Then API success with status code 200
	Then "message" response body is "Login Successfully"
	
	
	Given Create Product API
 	When User calls "CreateProduct" API with "POST" HTTP method
 	Then API success with status code 201
 	Then "message" response body is "Product Added Successfully"
 	
 	
 	Given Create Order API
 	When User calls "CreateOrder" API with "POST" HTTP method
 	Then API success with status code 201
 	Then "message" response body is "Order Placed Successfully"

 	
 	Given Delete Product API
 	When User calls "DeleteProduct" API with "DELETE" HTTP method
 	Then API success with status code 200
 	Then "message" response body is "Product Deleted Successfully"
 	
 	Given Delete Order API
 	When User calls "DeleteOrder" API with "DELETE" HTTP method
 	Then API success with status code 200
 	Then "message" response body is "Orders Deleted Successfully"
 	
 	
 	Examples:
	| userEmail | userPassword |
	| codeaddict@outlook.com | Code@123 |
