package application;

import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestingOfHomePage {
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
		Assert.assertTrue(objUserPage.verifyGreetingText("Ћаскаво просимо до Facebook, Daria."));
  }
  
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", pathToDriver);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
}
