package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;

public class LogOutFromUserPage {
	private WebDriver driver;
	private HomePageModel objHomePage;
	private UserPageModel objUserPage;
	private final String pathToDriver = "chromeDriver\\chromedriver.exe";
	private final String baseUrl = "https://uk-ua.facebook.com/";
	
	@Test(priority = 0)
	public void testExitFromUserPageIsCorrect() {
		objHomePage = new HomePageModel(driver);
		objUserPage = new UserPageModel(driver);
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");
		objUserPage.chooseFunctionInSettingsMenu("¬ийти");
		Assert.assertTrue(objHomePage.verifyTitle("Facebook Ч ув≥йд≥ть або зареЇструйтес€"));
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", pathToDriver);
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		driver.close();
	}
}
