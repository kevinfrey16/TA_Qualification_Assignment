Feature: Test Pet Store - Place and remove an order

Pet Store Swagger URL: https://petstore.swagger.io
  
  Scenario: Test Pet Store - Place and remove an order
    Given I create user account
        And I login into the system
        And I add a new pet
        And I search for the pet in the system
    When I place an order
        And I search for the order in the system
    Then I delete the order in the system