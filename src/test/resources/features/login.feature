Feature: Login

  Scenario: User can log in
    Given User is on login page
    When User inserts username
    And User inserts password
    And User clicks on Login button
    Then User is logged in

  Scenario Outline: User cannot log in with invalid username
    Given User is on login page
    When User inserts username <username>
    And User inserts password
    And User clicks on Login button
    Then User is not logged in
    Examples:
      | username    |
      | "tom smith" |
      | "TOMSMITH"  |
      | "TOM SMITH" |

    Scenario Outline: User cannot log in with invalid username and password
      Given User is on login page
      When User inserts username <username>
      And User inserts password <password>
      And User clicks on Login button
      Then User is not logged in

      Examples:
      | username | password |
      | "tom smith" | "super secret password !" |
      | "TOMSMITH"  | "SUPERSECRETPASSWORD!"    |
      | "tomsmith!" | "SuperSecretPassword"     |
