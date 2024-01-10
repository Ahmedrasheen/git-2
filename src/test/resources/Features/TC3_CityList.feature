@Test
Feature: City Module API Automation

  Scenario: Verify user get CityList through API
    Given User add header for to get CityList
    When User add requestbody StateId for get CityList
    And User send "POST" request for CityList endpoint
   Then User should verify statuscode is 200 
    And User verify the CityList response message matches "Yercaud" and saved CityId
