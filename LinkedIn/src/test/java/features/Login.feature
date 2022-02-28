Feature: Application Login

  Scenario Outline: Positive login with valid credentials
    Given Navigated to Home Page <url>
    And Clicks on Sign in button to navigate to Sign in Page
    When User logs in with username <username> and password <password>
    Then Verify that user is logged in

    Examples:
      | url                      | username              | password       |
      | https:\\www.linkedin.com | milanguzina@yahoo.com | micantheman123 |


  Scenario Outline: Negative login with invalid credentials
    Given Navigated to Home Page <url>
    And Clicks on Sign in button to navigate to Sign in Page
    When User logs in with username <username> and password <password>
    Then Verify that user is not logged in


    Examples:
      | url                      | username              | password      |
      | https:\\www.linkedin.com | milanguzina@yahoo.com | wrongpassword |