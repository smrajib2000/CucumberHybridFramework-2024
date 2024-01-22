Feature: Search Functionality

  Scenario: User searches for valid product
    Given User navigate to search page
    When User enters valid product "HP" into Search Box field
    And User click on search button
    Then user should get valid prouct displayed in search results

  Scenario: User searches for invalid product
    Given User navigate to search page
    When User enters invalid product "honda" into Search Box field
    And User click on search button
    Then user should get a no message about no procut mathces

  Scenario: User searches without any product
    Given User navigate to search page
    When User do not enter any product into Search Box field
    And User click on search button
    Then user should get a no message about no procut mathces
