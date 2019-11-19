@login
Feature: Login functionality
  # some text regarding feature file

  Background: User login
    Given User navigates to home page
    When User clicks on sign in link

  @smokeTest
  Scenario: User Login Validation

    And User input email adress and password
    And User clicks on sign in button
    Then User is on account page

  @negative
  Scenario: User Login Validation with Invalid credentials
#    Given User navigates to home page
#    When User clicks on sign in link
    And User input "ivalid" email  and "invalid" password
    And User clicks on sign in button
    Then User should see error message "Invalid email address."

@loginCheck
  @negative
  Scenario Outline: User Login Validation with Invalid credentials
#    Given User navigates to home page
#    When User clicks on sign in link
    And User input "<email>" email  and "<password>" password
    And User clicks on sign in button
    Then User should see error message "<error message>"
  Examples: Invalid credentials
    |email                  |password   |error message|
    |invalid                |invalid   |Invalid email address.|
    |abc213@mailinator.com  |invalid    |Authentication failed|
    |invalid                |abc1234    |Invalid email address.|




  @negative @wip
  Scenario: User Login Validation with Invalid credentials
#    Given User navigates to home page
#    When User clicks on sign in link
    And User inputs email, password and clicks on sign in button and validate error message
      |email                  |password   |error message|
      |invalid                |invalid   |Invalid email address.|
      |abc213@mailinator.com  |invalid    |Authentication failed.|
      |invalid                |abc1234    |Invalid email address.|

#    And User input "<email>" email  and "<password>" password
#    And User clicks on sign in button
#    Then User should see error message "<error message>"

#   And new feature validation

    # Steps key words
  # Given, When, And, But, Then,
