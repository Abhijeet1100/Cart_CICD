package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	public WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".row .col-lg-4")
	List<WebElement> items;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;

	@FindBy(css = ".ng-tns-c31-1")
	WebElement elementsAppear;

	public List<WebElement> productList() {

		return items;
	}

	public Payment addToCart(String productName) {

		for (int i = 0; i < productList().size(); i++) {

			if (items.get(i).findElement(By.cssSelector(".card-body h5")).getText().equals(productName)) {

				items.get(i).findElement(By.cssSelector(".fa-shopping-cart")).click();
				break;
			}
		}

		waitForElementNotToAppear(elementsAppear);

		cart.click();

		Payment payment = cartPage();
		return payment;

	}

}
