@StandardUser
Feature: Sauce Demo Shopping Cart & Checkout Pages - Standard User

  Scenario: Validate Items In Cart - Standard User
    Given user is on the "My cart" page
    Then user validates items in shopping cart

  Scenario: User Checkout
    Given user is on the "My cart" page
    When user clicks on checkout button
    Then user is on the "Checkout: Your Information" page

  Scenario: Price Check
    Given user is on the "Checkout: Your Information" page
    When user fills in checkout form
    Then user is on the "Checkout: Your Overview" page