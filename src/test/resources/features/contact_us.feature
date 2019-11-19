Feature: Contact Us

  @smokeTest @contactUs
  Scenario: User should able to contact service
    Given User clicks on Contact Us link
    When User populates Contact Us form
    And User clicks on Send button
    Then User should view success message
