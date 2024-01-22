Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Regsiter Account page
    When User enters the details into the below fields
      | firstName | Guest     |
      | lastName  | LastGuest |
      | telephone |    123456 |
      | password  |    123456 |
    And User click on privacy policy
    And User click on continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Regsiter Account page
    When User enters the details into the below fields
      | firstName | Guest     |
      | lastName  | LastGuest |
      | telephone |    123456 |
      | password  |    123456 |
    And User should select Yes for newsletter
    And User click on privacy policy
    And User click on continue button
    Then User account should get created successfully

  Scenario: User creates an account with duplicate email address
    Given User navigates to Regsiter Account page
    When User enters the details into the below fields with duplicate email
      | firstName | Guest            |
      | lastName  | LastGuest        |
      | email     | shahalaul@gmail.com |
      | telephone |           123456 |
      | password  |           123456 |
    And User should select Yes for newsletter
    And User click on privacy policy
    And User click on continue button
    Then User account should get proper warning about duplicate email

  Scenario: User creates an account without filling any fields
    Given User navigates to Regsiter Account page
    When User do not enters any details into fields
    And User click on continue button
    Then User account should get proper warning messages for every mandatory fields
