@StandardUser
Feature: Sauce Demo Products Page - Standard User

  #Mario Start
  Scenario: Login to Sauce Demo With Valid Standard User Credentials
    Given user logs in to sauce demo with "standard user" credentials
    Then user is on the "Products" page
  #Mario End


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

  Scenario Outline: Add Product To Cart - Standard User
    Given user is on the "Products" page
    When user clicks on "Add to cart" button of "<total>" products
    Then products are added to the cart

    Examples:
    | total |
    | 4     |

  Scenario Outline: Remove Product From Cart - Standard User
    Given user is on the "Products" page
    When user clicks on "Remove" button of "<total>" products
    Then products are removed from the cart

    Examples:
    | total |
    | 1     |

  Scenario: User Clicks On Shopping Cart - Standard User
    Given user clicks on the shopping cart
    Then user is on the "Your Cart" page

  #Mario Start
  Scenario Outline: User Clicks On Social Icon - Standard User
    Given user is on the "Products" page
    When user clicks on "<Icon>"
    Then user is on the "<Icon>" page
    Examples:
    | Icon     |
    | twitter  |
    | facebook |
    | linkedin |
  #Mario End

  #Mario Start
  Scenario: Kill driver instance
    Given driver instance is running
    Then user kills driver instance
  #Mario End