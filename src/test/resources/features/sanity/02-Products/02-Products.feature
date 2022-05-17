@StandardUser
Feature: Sauce Demo Products Page - Standard User

  Scenario Outline: Sort Products - Standard User
    Given user is on the "Products" page
    When user selects "<sort>" from the dropdown
    Then items are sorted by "<sort>" in "<order>" order

    Examples:
    | sort                | order |
    | Name (A to Z)       | ASC   |
    | Name (Z to A)       | DESC  |
    | Price (low to high) | ASC   |
    | Price (high to low) | DESC  |