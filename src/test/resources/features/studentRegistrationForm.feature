Feature: Test Student Registration Form - Register a Student
    
  @UI_Automation
  Scenario: Test Student Registration Form - Register a Student
    Given I navigate to Main Page
        And I expect to see ToolsQA Logo
        And I navigate to the Student Registration Form Application
    When I click on menu Practice Form link
        And I expect to see the Student Registration Form
    Then I enter "student_01" student details
        And I register a new student