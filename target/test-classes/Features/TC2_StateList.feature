@Test
Feature: State Module API Automation

  Scenario: Verify user get StateList through API
    Given user add header for StateList
    When user send "GET" request for StateList endpoint
    Then User should verify statuscode is 200 
    And User should verify the StateList response message matches "Tamil Nadu" and saved StateId
