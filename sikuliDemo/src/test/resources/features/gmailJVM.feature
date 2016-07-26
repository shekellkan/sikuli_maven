@gmailJVM
Feature: gmailJVM
  Background:
    Given I navigate to gmail login page
    And I login on gmail with valid credentials "signageteamqav2" and "control123"
    Then I should be on main email page

  @newMail
  Scenario: Create a new mail and send to email jalasoft
    Given I opened to new email form
    When I type new data in from field: "joaquin.gonzales@jalasoft.com"
    And I type new data in subject field: "email by jvm"
    And I type new data in description field: "this is an example for sikuli with maven and cucumber and joaquin funciona..!"
    And I send a bew email
    Then I should be see a popup information about the email