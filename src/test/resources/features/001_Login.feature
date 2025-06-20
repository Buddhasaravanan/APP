Feature: Login Functionality


  @Sanity-negative
  Scenario: Login with invalid login credentials
    Given the user should be navigate to login page
    When the user entering invalid login credentials
    And the user click sign in button
    Then the user got password wrong message

  @Sanity-Positive
  Scenario: Login with valid login credentials
    Given the user should be navigate to login page
    When the user entering valid login credentials
    And the user click sign in button
    And the user select the company
    Then the user should navigate to dashboard page
