Feature: JobFinder

  Scenario Outline: Job search with given criteria
    Given Navigated to Home Page <url>
    And Clicks on Home Page logo
    And Clicks on Search for job button
    When User enters job criteria <jobCriteria> in search jobs box
    And Chooses job result <jobResult> from dropdown list
    Then Search results are populated
    And Verify correct search results

    Examples:
      | url                      | jobCriteria | jobResult   |
      | https:\\www.linkedin.com | QA          | QA Engineer |
