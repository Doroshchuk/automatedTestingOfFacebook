package application;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModels.HomePageModel;

public class RegisrationTesting extends BasicTest{
	private HomePageModel objHomePage;
	
	@BeforeClass
	public void createNecessaryObjects() {
		objHomePage = new HomePageModel(driver);
	}
	
	@Test(priority = 0)
	public void executeRegistrationTest() {
		
	}
}
