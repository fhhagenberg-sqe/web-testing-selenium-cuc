Feature: Search the web
  The user enters a search term and receives a list of related pages.

  Scenario: Perform a search using a web search form
    Given the search page "https://www.google.com" is open
    When I enter the term "software testing"
    Then I should see the results on the page "software testing - Google Search"