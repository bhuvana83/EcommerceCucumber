Feature: Login

@sanity
Scenario: Successfull Login with Valid User
	Given user launch chrome browser with url
	And user enters Email as "admin@yourstore.com" and Password as "admin"
	When click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When click on logout
	Then Page title should be "Your store. Login"
	And close browser
	
@Regression	
	Scenario Outline: Login Data Driven
	Given user launch chrome browser with url
	And user enters Email as "<Email>" and Password as "<Password>"
	When click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When click on logout
	Then Page title should be "Your store. Login"
	And close browser
	
Examples:
|Email							|Password		|
|admin@yourstore.com			|admin			|
|admin@yourstore.com			|feee123		|

