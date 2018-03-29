package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPageModel {
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='_1vp5']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[@class='mts mbl _1v_-']")
	WebElement messageLabelWithPhoneUser;
	
	public boolean verifyUserName(String expectedName) {
		String actualUserName = userNameLabel.getText();
		return expectedName.equals(actualUserName);
	}
	
	public boolean verifyMessageText(String expectedText) {
		String actualText = messageLabelWithPhoneUser.getText();
		return expectedText.equals(actualText);
	}
}
