package application;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModels.ConfirmationPageModel;
import pageObjectModels.HomePageModel;

public class RegisrationTesting extends BasicTest{
	private HomePageModel objHomePage;
	private ConfirmationPageModel objConfirmationPage;
	
	@BeforeClass
	public void createNecessaryObjects() {
		objHomePage = new HomePageModel(driver);
		objConfirmationPage = new ConfirmationPageModel(driver);
	}
	
	@Test(priority = 0)
	public void executeRegistrationTest() {
		String userName = "Dasha";
		String phone = "29032018";
		String message = "Підтвердьте, що це ваш номер мобільного телефону. Введіть код з SMS, надісланий на номер " + phone +  " (Україна).";
		objHomePage.registerAccount(userName, "Ivanova", "ivanova090697", "+380652147825", "09/06/1997", "female");
		Assert.assertTrue(objConfirmationPage.verifyUserName(userName) && objConfirmationPage.verifyMessageText(message));
	}
}
