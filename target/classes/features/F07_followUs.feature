@smoke
  Feature: followUs
    Scenario: user opens facebook link
      Given user click facebook link
      Then "https://www.facebook.com/nopCommerce" is opened in new tab
    Scenario: user opens twitter link
    Given user click twitter link
    Then "https://twitter.com/nopCommerce" is opened in new tab



    Scenario: user opens rss link
    Given user click rss link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

    Scenario: user opens youtube link
    Given user click youtube link
      Then "https://www.youtube.com/user/nopCommerce" is opened in new tab