Feature: Automating a test ecommerce application end to end for a product checkout from login to signout

@EndToEndTest
  Scenario: User should be able to login, add product to cart, checkout and signout successfully
    Given User is on the login page of the test ecommerce application
    When User enters valid username and password
    And User clicks on the login button
    Then User should be navigated to the test ecommernce application homepage
    When User clicks on View button for a product
    And User adds the product to the cart
    And user clicks on the cart button
    Then User should be navigated to the Checkout page
    When User clicks on the checkout button
  	And User enters the payment details
  	And User clicks on place order button
    Then User should be able to complete the purchase successfully
    When User clicks on the signout button
    Then User should be signed out and redirected to the login page
    And browser should be closed
    