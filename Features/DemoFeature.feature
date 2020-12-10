Feature: Test Post Request on REST API

Scenario: Test POST request
	Given I set API endpoint
	When I make a POST request
	Then I receive a valid response
