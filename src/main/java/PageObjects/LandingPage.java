package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// pageFactory design pattern for webElement

	@FindBy(css = "#userEmail")
	WebElement email;

	@FindBy(css = "#userPassword")
	WebElement password;

	@FindBy(css = ".login-btn")
	WebElement login;

	@FindBy(css = "[class*='flyInOut']")
	WebElement loginError;

	// Action method for webElement
	public String getErrorMsg() {
		waitForElementToAppear(loginError);
		return loginError.getText();
	}

	public ProductCatalog loginApplication(String email, String password) {

		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.login.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}

	public void goToLandingPage(String url) {
		driver.get(url);
	}

}
