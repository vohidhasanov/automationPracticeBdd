@loginTechCenture
Feature: Login
#  @login
  Scenario:I should be able to add new student to the system
    Given User navigates to home page "http://techcenture.us/qa-env/"
    When User clicks on CREATE STUDENT button
    And User clicks on CREATE NEW STUDENT button
    And User inputs name, last name, course and student age
    |Name         |Ali|
    |Last name    |Oz |
    |Course       |QA |
    |Student Age  |26 |

    And User clicks SAVE button
    Then User should see his name in the student list
    And User should validate student data in database