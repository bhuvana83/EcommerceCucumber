Feature: Customer

Background: Use these steps to navigate to Customer Page
 	Given user launch chrome browser with url
	And user enters Email as <Email> and Password as <Password>
	|admin@yourstore.com		|admin		|
	When click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When click on Customer menu and move to Customer section
	Then Page title should be "Customers / nopCommerce administration"

	
@Test1
Scenario: Add Customer
	When click on add new button
	Then Page title should be "Add a new customer / nopCommerce administration"
	And Add new customer info
	When click on save
	Then user see the confirmation message 
	When click on logout
	Then Page title should be "Your store. Login"
	And close browser
	

@Test2
Scenario Outline: Search Customer by Email
	When user enters Email as "<Emailid>" and click on Search button 
	Then user see the Customer related to"<Emailid>" in the table below 
	When click on logout
	Then Page title should be "Your store. Login"
	And close browser

	Examples:
|Emailid		|
|admin@yourStore.com		|

@Test3
Scenario Outline: Search Customer by Name
	When user enters name as "<FirstName>" and "<LastName>" click on Search button 
	Then user see the Customerdetails related to "<FirstName>" and "<LastName>" in the table below 
	When click on logout
	Then Page title should be "Your store. Login"
	And close browser

	Examples:
|FirstName		|LastName		|
|Arthur			|Holmes			|
