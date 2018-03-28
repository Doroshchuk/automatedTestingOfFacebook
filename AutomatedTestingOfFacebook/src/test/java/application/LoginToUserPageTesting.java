package application;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

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
		Assert.assertTrue(objHomePage.verifyTitle("Facebook � ������ ��� �������������"));
	}
	
	@Test(priority = 1, groups = "correctLogin")
	public void testUserPageAppearCorrect() {
		objHomePage.loginToFacebook("380968113424", "doroshchuk90697");  
		Assert.assertTrue(objUserPage.verifyGreetingText("������� ������� �� Facebook"));
	}
	
	@AfterGroups(groups = "correctLogin")
	public void exitFromUserPage() {
		objUserPage.chooseFunctionInSettingsMenu("�����");
	}
	
	@Test(priority = 2)
	public void testLoginWithEmptyValues() {
		objHomePage.clearEmailTF();
		objHomePage.loginToFacebook("", "");
		String expectedText = "������� ���������� ������ (��� ����� ��������) �� ���'����� � ������ �������� �������. ������� �������� �����.";
		Assert.assertTrue(objHomePage.verifyTextOfMessageNearEmailTF(expectedText) && objHomePage.verifyTheBackgroundColorOfMessageBox("rgba(190, 75, 73, 1)"));
	}
	
	@Test(priority = 3)
	public void testLoginWithIncorrectEmailAndPassword() {
		objHomePage.clearEmailTF();
		objHomePage.repeatedLoginToFacebook("30504651287", "hfgdhfkslf");
		String expectedText = "������� ���������� ������ (��� ����� ��������) �� ���'����� � ������ �������� �������. ������� �������� �����.";
		Assert.assertTrue(objHomePage.verifyTextOfMessageNearEmailTF(expectedText) && objHomePage.verifyTheBackgroundColorOfMessageBox("rgba(190, 75, 73, 1)"));
	}
	
	@Test(priority = 4)
	public void testRepeatedLoginWithIncorrectPassword() {
		objHomePage.clearEmailTF();
		objHomePage.repeatedLoginToFacebook("+380968113424", "gfhdfcn");
		String expectedText = "�� ����� ������������ ������. ������ ������?";
		Assert.assertTrue(objHomePage.verifyTextOfMessageNearEmailTF(expectedText) && objHomePage.messageBoxContainsHyperLink() && objHomePage.verifyTheBackgroundColorOfMessageBox("rgba(190, 75, 73, 1)"));
	}
}
