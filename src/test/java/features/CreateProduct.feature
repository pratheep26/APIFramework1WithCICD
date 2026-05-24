Feature: Validate Create Product API

@CreateProduct
Scenario: Verify Create Product API

 	Given Create Product API
 	When User calls "CreateProduct" API with "POST" HTTP method
 	Then API success with status code 201
 	Then "message" response body is "Product Added Successfully"
 	
 