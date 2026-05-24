Feature: Validate Delete Product API

@DeleteProduct
Scenario: Verify Delete Product API

 Given Delete Product API
 When User calls "DeleteProduct" API with "DELETE" HTTP method
 Then API success with status code 200
 Then "message" response body is "Product Deleted Successfully"