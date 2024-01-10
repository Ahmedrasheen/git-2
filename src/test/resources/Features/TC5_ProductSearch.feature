@Search
Feature: Search Module API Automation

  Scenario Outline: Verify user get search product through API
    Given User add header for search product
    When User add request body for search product "<product_Name>"
    And User send "POST" request for productSearch endpoint
    Then User should verify statuscode is 200
    And User should verify productSearch message matches "OK"

    Examples: 
      | product_Name |
      | Nuts         |
