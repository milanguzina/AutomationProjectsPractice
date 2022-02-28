Feature: Hyper Links

  Scenario Outline: Hyper links functionality
    Given Navigated to Home Page <url>
    When Scrolled down to footer hyper links section
    Then Verify Hyper link functionality with response code

    Examples:
      | url                      |
      | https:\\www.linkedin.com |

