package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class Payment extends AbstractComponent {

	public WebDriver driver;

	public Payment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By elementToAppear = By.xpath("//div[text()=' Shipping Information ']");

	@FindBy(css = ".list-group button")
	List<WebElement> countries;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".action__submit")
	WebElement submitPayment;

	public ConfirmationPage paymentPage() {
		waitForElementToAppear(elementToAppear);

		country.sendKeys("Ind");

		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}

		}

		submitPayment.click();

		ConfirmationPage confirmationpage = new ConfirmationPage(driver);

		return confirmationpage;
	}

}
