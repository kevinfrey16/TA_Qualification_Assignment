Feature: Test Pet Store - Update user information

Pet Store Swagger URL: https://petstore.swagger.io
  
  Scenario: Test Pet Store - Update user information
    Given I create user account
        And I search for the user in the system
    When I login into the system
        And I update user information
    #Then I search for the user in the system