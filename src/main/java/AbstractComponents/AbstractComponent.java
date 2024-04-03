package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.OrderPage;
import PageObjects.Payment;

public class AbstractComponent {

	public WebDriver driver;
	public WebDriverWait wait;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement cartPage;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderPage;

	public Payment cartPage() {
		cartPage.click();
		return new Payment(driver);
	}

	public OrderPage goToOrder() {
		orderPage.click();
		OrderPage order = new OrderPage(driver);
		return order;
	}

	public void waitForElementNotToAppear(WebElement webelement) {

		wait.until(ExpectedConditions.invisibilityOf(webelement));

	}

	public void waitForElementToAppear(WebElement webelement) {

		wait.until(ExpectedConditions.visibilityOf(webelement));

	}

	public void waitForElementToAppear(By by) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

}
