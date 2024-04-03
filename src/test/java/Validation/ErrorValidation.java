package Validation;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import PageObjects.ConfirmationPage;
import PageObjects.Payment;
import PageObjects.ProductCatalog;
import TestComponent.TestComponents;

public class ErrorValidation extends TestComponents {

	@Test(groups = "ErrorHandling")
	public void loginError() {

		landingpage.loginApplication("abhijeet@gmail.co", "Qwerty123");
		AssertJUnit.assertEquals("Incorrect email or pass@@word.", landingpage.getErrorMsg());

	}

	@Test
	public void orderConfirmationError() {

		ProductCatalog productCatalog = landingpage.loginApplication("abhijeet@gmail.com", "Qwerty123");

		Payment payment = productCatalog.addToCart("String productName");

		ConfirmationPage confirmationpage = payment.paymentPage();

		String text = confirmationpage.Confirmation();
		
		AssertJUnit.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
