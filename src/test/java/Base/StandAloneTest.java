package Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import PageObjects.ConfirmationPage;
import PageObjects.Payment;
import PageObjects.ProductCatalog;
import TestComponent.TestComponents;

public class StandAloneTest extends TestComponents {

	@Test
	public void submitOrder() throws IOException {

		ProductCatalog productCatalog = landingpage.loginApplication("abhijeet@gmail.com", "Qwerty123");

		Payment payment = productCatalog.addToCart("ADIDAS ORIGINAL");

		ConfirmationPage confirmationpage = payment.paymentPage();

		String text = confirmationpage.Confirmation();

		System.out.println(text);

	}

	@Test(dependsOnMethods = "submitOrder")
	public void ordersHistory() {
		landingpage.loginApplication("abhijeet@gmail.com", "Qwerty123");

		String text = landingpage.goToOrder().orderverify();

		System.out.println(text);

	}

//	@DataProvider
//	public Object[][] getData() throws IOException
//	{
////		HashMap<String,String> hashMap = new HashMap<String,String>();
////
////		hashMap.put("user","abhijeet@gmail.com");
////		hashMap.put("password","Qwerty123");
////		hashMap.put("productName","IPHONE 13 PRO");
////
////		Object[] object ={hashMap};
////		return object;
//
//		 List<HashMap<String,String>> list =getJsondata();
//		 Map<String,String> m1=list.get(0);
//		 Map<String,String> m2=list.get(1);
//
//		 Object[][] object = new Object[][] {{m1},{m2}};
//
//		 return object;
//	}



	

}
