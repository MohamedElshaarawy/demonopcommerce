
@smoke
Feature: homeSliders
Scenario: user click the first to open product page
  Given user click in first slider
  Then the Nokia page open


#  expected URL https://demo.nopcommerce.com/nokia-lumia-1020

  @smoke
  Scenario: user click the second slider
    Given user click in second slider
    Then the iphone page open

