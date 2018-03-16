package application;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;
import org.testng.Assert;

public class LoginToUserPageTesting extends BasicTest{
	private HomePageModel objHomePage;
	private UserPageModel objUserPage;
	
	@Test(priority = 0)
	public void verifyMainPageIsCorrect() {
		objHomePage = new HomePageModel(driver);
		Assert.assertTrue(objHomePage.verifyTitle("Facebook Ч ув≥йд≥ть або зареЇструйтес€"));
	}
	
	@Test(priority = 1, groups = "correctLogin")
	public void testUserPageAppearCorrect() {
		objUserPage = new UserPageModel(driver);
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");  
		Assert.assertTrue(objUserPage.verifyGreetingText("Ћаскаво просимо до Facebook"));
	}
	
	@AfterGroups(groups = "correctLogin")
	public void exitFromUserPage() {
		objUserPage.chooseFunctionInSettingsMenu("¬ийти");
	}
}
