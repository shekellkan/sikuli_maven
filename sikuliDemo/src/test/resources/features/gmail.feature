@gmail
  Feature: gmail
    Background:
      Given I navigate to gmail page
        And I login on gmail with the credentials "signageteamqav2" and "control123"
      Then I should be on main gmail page

    @newMail
    Scenario: Create a new mail and send to email jalasoft
      Given I enable to new email form
      When I enter new data in from field: "miguel.terceros@jalasoft.com"
        And I enter new data in subject field: "email test"
        And I enter new data in description field: "this is an example for sikuli with maven and cucumber '\n' and edmundo funciona..!"
        And I send the email
      Then I should be see a popup information
