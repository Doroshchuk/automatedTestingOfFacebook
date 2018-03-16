package application;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;
import org.testng.Assert;

public class LoginToUserPageTesting extends BasicTest{
	private HomePageModel objHomePage;
	private UserPageModel objUserPage;
	
	@BeforeClass
	public void createNecessaryObjects() {
		objHomePage = new HomePageModel(driver);
		objUserPage = new UserPageModel(driver);
	}
	
	@Test(priority = 0)
	public void verifyMainPageIsCorrect() {
		Assert.assertTrue(objHomePage.verifyTitle("Facebook Ч ув≥йд≥ть або зареЇструйтес€"));
	}
	
	@Test(priority = 1, groups = "correctLogin")
	public void testUserPageAppearCorrect() {
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");  
		Assert.assertTrue(objUserPage.verifyGreetingText("Ћаскаво просимо до Facebook"));
	}
	
	@AfterGroups(groups = "correctLogin")
	public void exitFromUserPage() {
		objUserPage.chooseFunctionInSettingsMenu("¬ийти");
	}
}
