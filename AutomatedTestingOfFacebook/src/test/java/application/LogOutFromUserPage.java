package application;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;
import pageObjectModels.UserPageModel;

public class LogOutFromUserPage extends BasicTest{
	private HomePageModel objHomePage;
	private UserPageModel objUserPage;
	
	@Test(priority = 0)
	public void testExitFromUserPageIsCorrect() {
		objHomePage = new HomePageModel(driver);
		objUserPage = new UserPageModel(driver);
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");
		objUserPage.chooseFunctionInSettingsMenu("�����");
		Assert.assertTrue(objHomePage.verifyTitle("Facebook � ������ ��� �������������"));
	}
}
