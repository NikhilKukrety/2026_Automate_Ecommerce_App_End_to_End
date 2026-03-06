package com.ecom.testClasses;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ecom.baseTest.BaseTest;
import com.ecom.pom.CartPage;
import com.ecom.pom.HomePage;
import com.ecom.pom.OrderSuccessfulPage;
import com.ecom.pom.PaymentPage;
import com.ecom.pom.ProductPreviewPage;
import com.ecom.pom.SignInPage;

@Listeners(com.ecom.listeners.Listeners.class) //This annotation is used to specify that the Listeners class should be used as a listener for the test execution.
public class TestCases extends BaseTest {
	
	
	@Test(priority = 0)
	public void testLoginFunctionality()
	{
		//Creating an object of the SignInPage class to access its methods and perform the login operation and passing the driver as an argument to the constructor of the SignInPage class:
		SignInPage signInPage = new SignInPage(driver);
		signInPage.verifySuccessfulNavigationToSignInPage();
		signInPage.enterEmail("test@gmail.com");
		signInPage.enterPassword("Abcd@1234");
		signInPage.clickLoginButton();
		HomePage homePage = new HomePage(driver);
		homePage.verifySuccessfulNavigationToHomePage();
	}	
	
	@Test(dependsOnMethods = "testLoginFunctionality")
	public void testProductPreviewFunctionality()
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifySuccessfulNavigationToHomePage();
		homePage.clickViewButton();
		ProductPreviewPage productPreviewPage = new ProductPreviewPage(driver);
		productPreviewPage.verifySuccessfulNavigationToProductPreviewPage();
	}
	
	@Test(dependsOnMethods = "testProductPreviewFunctionality")
	public void testAddToCartFunctionality()
	{
		ProductPreviewPage productPreviewPage = new ProductPreviewPage(driver);
		productPreviewPage.clickAddToCartButton();
	}
	
	@Test(dependsOnMethods = "testAddToCartFunctionality")
	public void testCartFunctionality()
	{
		ProductPreviewPage productPreviewPage = new ProductPreviewPage(driver);
		productPreviewPage.clickCartButton();
		CartPage cartPage = new CartPage(driver);
		cartPage.verifySuccessfulNavigationToCartPage();
	}
	
	@Test(dependsOnMethods = "testCartFunctionality")
	public void testCheckoutFunctionality()
	{
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckoutButton();
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.verifySuccessfulNavigationToPaymentPage();
	}
	
	@Test(dependsOnMethods = "testCheckoutFunctionality")
	public void testPaymentPageFunctionality()
	{
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.enterCreditCardNumber("0111 1234 02222 3333");
		paymentPage.enterCCVNumber("123");
		paymentPage.enterNameOnCard("Nikhil Kukrety");
		paymentPage.enterCountry("India");
		paymentPage.selectCountry();
		paymentPage.clickPlaceOrderButton();
		OrderSuccessfulPage orderSuccessfulPage = new OrderSuccessfulPage(driver);
		orderSuccessfulPage.verifySuccessfulNavigationToOrderSuccessfulPage();
		
	}
	
	@Test(dependsOnMethods = "testPaymentPageFunctionality")
	public void testSignOutFunctionality()
	{
		OrderSuccessfulPage orderSuccessfulPage = new OrderSuccessfulPage(driver);
		orderSuccessfulPage.clickSignOutButton();
		SignInPage signInPage = new SignInPage(driver);
		signInPage.verifySuccessfulNavigationToSignInPage();
		
	}
	

}
