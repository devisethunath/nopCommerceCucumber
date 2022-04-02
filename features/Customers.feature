Feature: Customer Feature


Background: all the common steps 

Given User launch chrome browser
When User opens the URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "admin@yourstore.com" and password as "admin"
And click on login button
Then user can view Dashbord

@Regression
Scenario: Add new Customer


When User clicks on customers menu
And click on customers menu item
And click on add new button
Then user can view Add new customer page
When user enter customer info
And click on save button
Then user can view confirmation message "The new customer has been added successfully"
And close browser

@Smoke
Scenario: Search for a customer by emailId


When User clicks on customers menu
And click on customers menu item
And enter customer email
And click search button
Then user should find email in search table
And close browser



