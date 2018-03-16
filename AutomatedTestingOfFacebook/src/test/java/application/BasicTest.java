package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BasicTest {
	protected WebDriver driver;
	protected final String pathToDriver = "chromeDriver\\chromedriver.exe";
	protected final String baseUrl = "https://uk-ua.facebook.com/";
	
	@BeforeClass(alwaysRun = true)
	protected void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", pathToDriver);
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	protected void afterTest() {
		driver.close();
	}
}
