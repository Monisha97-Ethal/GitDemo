#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login Functionality
  
  Scenario Outline: Unsuccessfull Login
    Given User is in Login page
    When User Enters invalid credentials 
      |username|password|
     | wqd@gmail.com  | qwdwq2 |
      | qwwe@gmail.com |sxdwqw|
      | sqqw@gmail.com |qwwqd|
      |wwwqw@gmail.com|qwdwq| 
      |monishavelu05@gmail.com|Ethalya17@22|
    
    Then ErrorMessage On the Screen

    