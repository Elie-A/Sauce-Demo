@StandardUser
Feature: Sauce Demo Login Page - Standard User

  Scenario: Login to Sauce Demo With Valid Standard User Credentials
    Given user logs in to sauce demo with "standard user" credentials
    Then user is on the "Products" page