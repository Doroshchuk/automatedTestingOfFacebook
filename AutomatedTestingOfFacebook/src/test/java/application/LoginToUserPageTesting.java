package application;

import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoginToUserPageTesting {
	private WebDriver driver;
	private HomePageModel objHomePage;
	private UserPageModel objUserPage;
	private final String pathToDriver = "chromeDriver\\chromedriver.exe";
	private final String baseUrl = "https://uk-ua.facebook.com/";
	
	@Test(priority = 0)
	public void verifyMainPageIsCorrect() {
		objHomePage = new HomePageModel(driver);
		Assert.assertTrue(objHomePage.verifyTitle("Facebook Ч ув≥йд≥ть або зареЇструйтес€"));
	}
	
	@Test(priority = 1)
	public void testUserPageAppearCorrect() {
		objHomePage = new HomePageModel(driver);
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");  
		objUserPage = new UserPageModel(driver);
		Assert.assertTrue(objUserPage.verifyGreetingText("Ћаскаво просимо до Facebook"));
	}
	
	@Test(priority = 2)
	public void testExitFromUserPageIsCorrect() {
		objHomePage = new HomePageModel(driver);
		objUserPage = new UserPageModel(driver);
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
