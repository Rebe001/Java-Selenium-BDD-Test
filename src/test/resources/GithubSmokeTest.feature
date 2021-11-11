Feature:  Github Smoke test

  Background:
    Given I navigate to "https://www.google.com"
    And I search query "Github" on Goggle
    And I click on first result on Google
    Then I landed on Github home page

  Scenario: Search and view Github Repository
    When I search query "user:Rebe001" on Github global navigation
    And I click on search result "Rebe001/Giphy-Rest-api-test" on Github search result page
    Then I can view Github Repository titled "Giphy REST api test"

  Scenario: Navigate through Github global navigation bar and site map
    When I click on nav item "Team" on Github global navigation
    And I scroll to bottom on "Github repository page"
    And I click on "About" on footer
    Then I landed on Github About page


