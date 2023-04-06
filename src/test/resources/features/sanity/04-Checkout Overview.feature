@StandardUser
Feature: Sauce Demo Checkout Overview Page - Standard User

  Scenario: Validate Prices On Checkout Overview - Standard User
    Given user is on the "Checkout: Your Overview" page
    Then user validates total price

  Scenario: Validate Total - Standard User
    Given user is on the "Checkout: Your Overview" page
    Then user validates total price with tax of "taxKey"
    And user clicks on finish button
    * user is on the "Checkout: Complete!" page
