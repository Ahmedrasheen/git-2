Feature: Address Module API Automation

  @Address
  Scenario Outline: Verify add user address to application  through API
    Given User add header and bearer authorization for accessing address endpoints
    When User add requestbody for add new address "<first_name>","<last_name>","<mobile>","<apartment>",<state> and <city> and <country>,"<zipcode>","<address>" and "<address_type>"
    And User sent "POST" request for addUserAddress endpoint
    Then User should verify statuscode is 200
    And User should verify the addUserAddress response message matches "Address added successfully" and get userId saved

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Harish     | s         | 8072134077 | princess  |    35 | 4440 |     101 |  605757 | Chennai | Home         |

  @GetAddress
  Scenario: Verify user get address through API
    Given User add header and bearer authorization for accessing address endpoints
    When User send "PUT" request for getUserAddress endpoint
    Then User should verify statuscode is 200
    And User shoud verify getUserAddress respond message matches "OK"

  @Update
  Scenario Outline: Verify user Update address through API
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body userId for  update address "<user_Id>","<first_name>","<Last_name>","<mobile>","<apartment>",<state> and <city> and <country>,"<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateAddress endpoint
     Then User should verify statuscode is 200
    And User should verify updateAddress respond message "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Harish     | hetvik    | 8072134077 | princess  |    35 | 4439 |     101 |  605757 | Chennai | Home         |

  @DeleteAddress
  Scenario Outline: Verify add user address to application  through API
    Given User add header and bearer authorization for accessing address endpoints
    When User add requestbody for delete address "<addressId>"
    And User sent "DELETE" request for deleteUserAddress endpoint
    Then User should verify statuscode is 200
    And User should verify the DeleteAddress response message matches "Address deleted successfully" 
