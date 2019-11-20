@excel
Feature: Excel Generator
@skip
  Scenario: As user able to generate excel file
    Given I user I should able to read excel file
@excel1
    Scenario: As user I should able to generate excel file with test data
      Given User navigates to "https://mockaroo.com/" website
      When User add field name and type
          |field name |type         |
          |id         |Number       |
          |first_name |First Name   |
          |last_name  |Last Name    |
          |address    |Street Address|