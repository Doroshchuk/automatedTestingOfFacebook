package application;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;

public class LogOutFromUserPage extends BasicTest{
	private HomePageModel objHomePage;
	private UserPageModel objUserPage;
	
	@BeforeClass
	public void createNecessaryObjects() {
		objHomePage = new HomePageModel(driver);
		objUserPage = new UserPageModel(driver);
	}
	
	@Test(priority = 0)
	public void testExitFromUserPageIsCorrect() {
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");
		objUserPage.chooseFunctionInSettingsMenu("¬ийти");
		Assert.assertTrue(objHomePage.verifyTitle("Facebook Ч ув≥йд≥ть або зареЇструйтес€"));
	}
}
