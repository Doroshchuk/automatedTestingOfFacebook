package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPageModel {
	private WebDriver driver;
	
	@FindBy(xpath = "//h2[@class='uiHeaderTitle']")
	WebElement userPageGreeting;
	
	@FindBy(xpath = "//span[@class='_1vp5']")
	WebElement userNameLbl;
	
	public UserPageModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	private String getActualGreetingText() {
		return userPageGreeting.getText();
	}
	
	public boolean verifyGreetingText(String expectedGreeting) {
		return getActualGreetingText().equalsIgnoreCase(expectedGreeting + ", " + userNameLbl.getText() + ".");
	}
}
