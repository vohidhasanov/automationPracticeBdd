@loginTechCenture
Feature: Login
#  @login
  Scenario:I should be able to add new student to the system
    Given User navigates to home page "http://techcenture.us/qa-env/"
    When User clicks on CREATE STUDENT button
    And User clicks on CREATE NEW STUDENT button
    And User inputs name, last name, course and student age
    |Name         |Alijan|
    |Last name    |AlijanOZ |
    |Course       |QA3 |
    |Student Age  |46 |

    And User clicks SAVE button
    Then User should see his name in the student list
    And User should validate student data in database