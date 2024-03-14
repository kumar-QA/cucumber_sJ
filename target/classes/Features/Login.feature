
Feature: verify loginFunction completely
Background:
  Given openbrowser and enter url

  Scenario: verify login function with valid data

  When user enter valid username
  And user enter vlaid password
  When user click on loginButton
  Then it should naviagte to dashboardpage
  
  
  Scenario: verify login function with Invalid data

  When user enter invalid username
  And user enter invalid password
  When user click on loginButton
  Then it should throw error message as No customer account found
  
  
  Scenario: verify login function with validusername and invalid password

  When user enter valid username
  And user enter invalid password
  When user click on loginButton
  Then it should throw error message as The credentials provided are incorrect
  
  
  
  Scenario: verify login function with invalidusername and valid password
  When user enter invalid username
  And user enter vlaid password
  When user click on loginButton
  Then it should throw error message as No customer account found
  
  
  Scenario: verify login function with Empty credentials
   Given openbrowser and enter url
   When user Keep username and password Fields as empty
   When user click on login button without credentials
  Then it should throw error message as Please enter your email

  
  
  
   
  