@smoke
  Feature: Wishlist
    Scenario: user add a product to wishlist
      Given :user add HTC phone to wish list
      Then :message with green background appears and correct text appear


@smoke
    Scenario: user add a product to wishlist
      Given :user add HTC phone to wish list
      Then :wait for success message to disappear
      Then :verify Qty is more 0


#      wait for alert to appear using explicit wait
#     click close button
#     get text of wishlist to make sure it's more than 0
#