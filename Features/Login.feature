Feature: Login

Scenario: Successful login with valid credentials

Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on login
Then Page title should be "Dashboard / nopCommerce administration"
When User clicks on logout link
Then Page title should be "Your store. Login"
And Close browser


Scenario Outline: Login Data Driven
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" and password as "<password>"
And Click on login
Then Page title should be "Dashboard / nopCommerce administration"
When User clicks on logout link
Then Page title should be "Your store. Login"
And Close browser
	
	Examples:
	|email   						| password  |
	|admin@yourstore.com| admin 		|
	|admin@yourstore.com| admin123	|