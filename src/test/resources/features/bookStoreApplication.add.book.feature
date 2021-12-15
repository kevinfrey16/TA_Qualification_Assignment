Feature: Test Book Store Application - Verify a book is added to your account

@UI_Automation
Scenario: Test Book Store Application - Verify a book is added to your account
    Given I navigate to Main Page
        And I expect to see ToolsQA Logo
        And I navigate to the Book Store Application
        And I click on Login button
        And I enter "user_empty_account" login details
        And I click on Login button
        And I should be able to see the Book Store Application
    When I add "Git Pocket Guide" book
        And I click on menu Profile link
    Then I should be able to see "Git Pocket Guide" book added
        And I click on Delete All Books button
        And I click on Logout button