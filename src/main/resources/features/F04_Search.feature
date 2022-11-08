@smoke
Feature: Search

  @somke
  Scenario Outline: user could search using product name
    Given user search by "<ProductName>"
    And  user Click search button
    Then user see search page with searched "<ProductName>"


    Examples:
      | ProductName |
      | book        |
      | laptop      |
      | nike        |

#  Use soft assertion to verify the following
#  1- url contains https://demo.nopcommerce.com/search?q=
#  2- search shows relevant results
#  2.1- Count number of search results using findElements & size()
#  2.2- Create for loop and verify each result contains the search word
#

  @smoke
  Scenario Outline: user could search for product using sku
    Given user search by "<sku>"
    And  user Click search button
    Then user click on product in search result
    Then user see the "<sku>" in product page

    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |


#  1- search with sku (You should pass parameter from Feature File in this step)
#  2- After searching, you need to click on the product in search result
#  3- Use hard assertion to verify the following
#  3.1- get the sku shown in this page then make sure it contains the sku that you are using in search