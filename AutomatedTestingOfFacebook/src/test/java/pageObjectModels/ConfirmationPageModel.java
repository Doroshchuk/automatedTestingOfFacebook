package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPageModel {
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='_1vp5']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[@class='mts mbl _1v_-']")
	WebElement messageLabelWithPhoneUser;
	
	public ConfirmationPageModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean verifyUserName(String expectedName) {
		String actualUserName = userNameLabel.getText();
		return expectedName.equals(actualUserName);
	}
	
	public boolean verifyMessageText(String expectedText) {
		String actualText = messageLabelWithPhoneUser.getText();
		return expectedText.equals(actualText);
	}
}
