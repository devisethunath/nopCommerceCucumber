Feature: Login

Scenario: Successful login with valid credentials

Given User launch chrome browser
When User opens the URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "admin@yourstore.com" and password as "admin"
And click on login button
Then page title should be "Dashboard / nopCommerce administration"
When User clicks on logout button 
Then page title should be "Your store. Login"
And close browser


Scenario Outline: Login DataDriven

Given User launch chrome browser
When User opens the URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "<email>" and password as "<password>"
And click on login button
Then page title should be "Dashboard / nopCommerce administration"
When User clicks on logout button 
Then page title should be "Your store. Login"
And close browser

Examples:

| email | password |
| admin@yourstore.com | admin |
| admi@yourstore.com | admi |


