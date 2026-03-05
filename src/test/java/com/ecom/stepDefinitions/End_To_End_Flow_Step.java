package com.ecom.stepDefinitions;

import com.ecom.baseTest.BaseTest;
import com.ecom.pom.CartPage;
import com.ecom.pom.HomePage;
import com.ecom.pom.OrderSuccessfulPage;
import com.ecom.pom.PaymentPage;
import com.ecom.pom.ProductPreviewPage;
import com.ecom.pom.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class End_To_End_Flow_Step extends BaseTest {
	
	SignInPage signInPage;
	HomePage homePage;
	ProductPreviewPage productPreviewPage;
	CartPage cartPage;
	PaymentPage paymentPage;
	OrderSuccessfulPage orderSuccessfulPage;
	
	
	@Given("User is on the login page of the test ecommerce application")
	public void user_is_on_the_login_page_of_the_test_ecommerce_application() {
		   
		//Initially chrome browser is launched using Hooks.java class and then the user is navigated to the login page of the test ecommerce application by calling the launchChromeBrowser() method from the BaseTest class, which is inherited by the Hooks class. So, we can assume that the user is already on the login page of the test ecommerce application at this step.
		//Will add assertion here to verify that the user is on the login page of the test ecommerce application.
	}
	
	@When("User enters valid {string} and {string}")
	public void user_enters_valid(String email, String password) {
	   
		signInPage = new SignInPage(driver);
	    signInPage.enterEmail(email);
	    signInPage.enterPassword(password);
	}


	@And("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
	    
	    signInPage.clickLoginButton();
		
	}

	@Then("User should be navigated to the test ecommernce application homepage")
	public void user_should_be_navigated_to_the_test_ecommernce_application_homepage() {
	   
		//Will add assertion here to verify that the user is navigated to the homepage of the test ecommerce application after successful login.
	}

	@When("User clicks on View button for a product")
	public void user_clicks_on_view_button_for_a_product() {
	    
		
		homePage = new HomePage(driver);
	    homePage.clickViewButton();
	    
	}

	@And("User adds the product to the cart")
	public void user_adds_the_product_to_the_cart() {
	    
		productPreviewPage = new ProductPreviewPage(driver);
	    productPreviewPage.clickAddToCartButton();

	}

	@And("user clicks on the cart button")
	public void user_clicks_on_the_cart_button() {
	   
		productPreviewPage.clickCartButton();
		
	}

	@Then("User should be navigated to the Checkout page")
	public void user_should_be_navigated_to_the_checkout_page() {
	    
		//Will add assertion here to verify that the user is navigated to the checkout page of the test ecommerce application after clicking on the cart button.
		
	}

	@When("User clicks on the checkout button")
	public void user_clicks_on_the_checkout_button() {
	    
		cartPage = new CartPage(driver);
	    cartPage.clickCheckoutButton();
		
	}

	@And("User enters the payment details")
	public void user_enters_the_payment_details() {
	    
		paymentPage = new PaymentPage(driver);
	    paymentPage.enterCreditCardNumber("0111 1234 02222 3333");
	    paymentPage.enterCCVNumber("123");
	    paymentPage.enterNameOnCard("Nikhil Kukrety");
	    paymentPage.enterCountry("India");
	    paymentPage.selectCountry();
	    
	}

	@And("User clicks on place order button")
	public void user_clicks_on_place_order_button() {

		paymentPage.clickPlaceOrderButton();
		
	}

	@Then("User should be able to complete the purchase successfully")
	public void user_should_be_able_to_complete_the_purchase_successfully() {

		//Will add assertion here to verify that the user is able to complete the purchase successfully and is navigated to the order successful page of the test ecommerce application after clicking on the place order button.
		
	}

	@When("User clicks on the signout button")
	public void user_clicks_on_the_signout_button() {

		orderSuccessfulPage = new OrderSuccessfulPage(driver);
	    orderSuccessfulPage.clickSignOutButton();
	    
	}

	@Then("User should be signed out and redirected to the login page")
	public void user_should_be_signed_out_and_redirected_to_the_login_page() {
	    
		//Will add assertion here to verify that the user is signed out successfully and is redirected to the login page of the test ecommerce application after clicking on the signout button.
	}

	@And("browser should be closed")
	public void browser_should_be_closed() {

		//Will add assertion here to verify that the browser is closed successfully after the user is signed out and redirected to the login page of the test ecommerce application.
		
	}

}
