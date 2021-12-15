Feature: Test Book Store Application - Login
  
  @UI_Automation
  Scenario: Test Book Store Application - Login
    Given I navigate to Main Page
      And I expect to see ToolsQA Logo
    	And I navigate to the Book Store Application
    When I click on menu Login link
      And I enter "user_empty_account" login details
    Then I click on Login button
      And I should be able to see the profile details