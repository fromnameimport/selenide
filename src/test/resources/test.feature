Feature: Test
  Scenario: Open and validate page
    When I open test site homepage
    Then I verify that the logo is present on the page
    Then Close browser

  Scenario: Open about page and send message to administration
    When I open test site homepage
    Then I go to "About page"
    And I verify that "About page" is present
    Then I go to "Contact us page"
    And I verify that "Contact us page" is present
    Then I fill out, submit 'Send Us Message' and verify form sending
    And Close browser

  Scenario: Login to a non-existent account
    When I open test site homepage
    Then I go to "My account page"
    And I verify that "My account page" is present
    Then I enter invalid users credentials
    And I verify that there are mistake message
    Then Close browser

  Scenario: Adding goods to cart
    When I open test site homepage
    Then I go to "Shop page"
    And I verify that the "Shop" page is present
    And I add to cart random item
    Then I go to "Cart page"
    And I verify that the "Cart" page is present
    And I verify that added item is added to cart
    Then Close browser

  Scenario: Valid search for item
    When I open test site homepage
    Then I search for "Watch"
    And I verify search results for "Watch"
    Then Close browser

  Scenario: Invalid search for item
    When I open test site homepage
    Then I search for "sfhdrt3"
    And I verify search results for "sfhdrt3"
    Then Close browser

#  Scenario: Test scenario
#    When I open test site homepage
#    Then I go to "Shop page"
#    Then I verify that the "Shop" page is present
#    Then I add to cart random item
#    Then I go to "Cart page"
#    Then I verify that the "Cart" page is present
#    And I verify that added item is added to cart
#    Then Close browser