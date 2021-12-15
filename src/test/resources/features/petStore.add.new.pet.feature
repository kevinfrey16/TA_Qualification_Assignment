Feature: Test Pet Store - Add a new pet and verify is added

Pet Store Swagger URL: https://petstore.swagger.io
  
  Scenario: Test Pet Store - Add a new pet and verify is added
    Given I create user account
        And I login into the system
    When I add a new pet
        And I upload the pet photo
    Then I search for the pet in the system