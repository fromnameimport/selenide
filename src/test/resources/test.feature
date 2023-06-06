Feature: Test feature
  Scenario: Open and validate page
    When I open test site homepage
    Then I verify that the logo is present on the page

  Scenario: Open about page and send message to administration
    When I open test site homepage
    Then I go to "About page"
    And I verify that "About" page is present
    Then I go to "Contact us page"
    And I verify that "Contact us" page is present
    Then I fill out, submit 'Send Us Message' and verify form sending

  Scenario: Login to a non-existent account
    When I open test site homepage
    Then I go to "My account page"
    And I verify that "My account" page is present
    Then I enter invalid users credentials
    And I verify that there are mistake message

  Scenario: Adding goods to cart
    When I open test site homepage
    Then I go to "Shop page"
    And I verify that "Shop" page is present
    And I add to cart random item
    Then I go to "Cart page"
    And I verify that "Cart" page is present
    And I verify that added item is added to cart

  Scenario: Valid search for item
    When I open test site homepage
    Then I search for "Watch"
    And I verify search results for "Watch"

  Scenario: Invalid search for item
    When I open test site homepage
    Then I search for "sfhdrt3"
    And I verify search results for "sfhdrt3"

  Scenario: Send support form
    When I open test site homepage
    Then I click "Support form" button
    And I fill out, submit and verify 'Support form' sending

  Scenario: Filter shop items
    When I open test site homepage
    Then I go to "Shop page"
    Then I filter "Clothes" items
    And I verify filter for "Clothes" is applied
    Then I filter "Shoes" items
    And I verify filter for "Shoes" is applied
    Then I filter "Uncategorized" items
    And I verify filter for "Uncategorized" is applied
    Then I go to "Shop page"
    Then I filter "Watch" items
    And I verify filter for "Watch" is applied

  Scenario: Cart page file upload
    When I open test site homepage
    Then I go to "Cart page"
    Then I upload text file
    And I verify that file if uploaded