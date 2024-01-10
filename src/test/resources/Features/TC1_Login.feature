@Login
Feature: Login Module API Automation

  Scenario: Get user logToken from login endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify statuscode is 200 
    And User should verify the login responsebody firstname present as "Harish" and get logToken saved
