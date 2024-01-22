Feature: Login Functionality

  Scenario Outline: Login with valid credentials
    Given User has navigate to login page
    When User has to enter valid email address <username> into email field
    And User has to enter valid password <password> into password fill
    And click the login button
    Then User should get successfully loged in

    Examples: 
      | username               | password |
      | shahalaul@gmail.com    | guest123 |
      | amotooricap1@gmail.com |    12345 |
      | amotooricap2@gmail.com |    12345 |

  Scenario: Login with invalid credentials
    Given: User has navigate to login Page

    Given User has navigate to login page
    When User has to enter invalid email address into email field
    And User has to enter invalid password "guest1234" into password fill
    And click the login button
    Then User should get a proper warning message about credential missmatch

  Scenario: Login with valid email and invalid Password
    Given: User has navigate to login Page

    Given User has navigate to login page
    When User has to enter valid email address "shahalaul@gmail.com" into email field
    And User has to enter invalid password "guest12345" into password fill
    And click the login button
    Then User should get a proper warning message about credential missmatch

  Scenario: Login with invalid email and valid Password
    Given: User has navigate to login Page

    Given User has navigate to login page
    When User has to enter invalid email address into email field
    And User has to enter invalid password "guest123" into password fill
    And click the login button
    Then User should get a proper warning message about credential missmatch

  Scenario: Login without prividing any credentials
    Given: User has navigate to login Page

    Given User has navigate to login page
    When User do not enter email address into email field
    And User do not enter password into password fill
    And click the login button
    Then User should get a proper warning message about credential missmatch
