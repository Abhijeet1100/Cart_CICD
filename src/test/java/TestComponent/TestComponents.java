package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;
import Utility.DataReader;

public class TestComponents extends DataReader {

	public WebDriver driver;

	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {

		// Properties class

		Properties property = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/GlobalData.properties");

		property.load(fis);

		String browserName = property.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// chrome browser

			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		return driver;

		// firefox
	}
	
	public String getScreenshot(String testCaseName ,WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;

		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		File destinationFile = new File(System.getProperty("user.dir")+" "+testCaseName +" "+".png");

		FileUtils.copyFile(sourceFile,destinationFile);

		return System.getProperty("user.dir")+" "+testCaseName +" "+".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goToLandingPage("https://rahulshettyacademy.com/client");
		return landingpage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
