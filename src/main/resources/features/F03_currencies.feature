

  @somke
    Feature: F03_currencies | users can use different currencies
      Scenario: user could change currency to euro
        Given user select euro currency from dropdown list
        Then the products in home page are shown with Euro Symbol (€)