Feature: Validate Login API


@Login @Smoke
Scenario Outline: Verify Login API
	Given Login payload with "<userEmail>" and "<userPassword>"
	When User calls "Login" API with "POST" HTTP method
	Then API success with status code 200
	Then "message" response body is "Login Successfully"
	
Examples:
	| userEmail | userPassword |
	| codeaddict@outlook.com | Code@123 |