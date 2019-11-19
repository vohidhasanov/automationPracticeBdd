Feature: Macharoo file download

  Scenario: As a user I should able to download excel file
    Given User navigates to mackaroo home page
    When User enters ID
    And User enters first_name to form and select firstName type
    And User enters last_name to form and select lastname type
    And User enters email to form select emailType
    And User enters gender to form and select Type
    And User enters ip_adress to form and select Ip Type
    And User enters row numbers
    And User enters file format to dowonload
    Then User click download button
