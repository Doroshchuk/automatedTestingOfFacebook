package pageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPageModel {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//h2[@class='uiHeaderTitle']")
	WebElement userPageGreeting;
	
	@FindBy(xpath = "//span[@class='_1vp5']")
	WebElement userNameLbl;
	
	@FindBy(id = "userNavigationLabel")
	WebElement settingsMenuBtn;
	
	@FindBy(xpath = "//div[@id='BLUE_BAR_ID_DO_NOT_USE']//ul//li//a//span")
	List<WebElement> menuFunctions;
	
	public UserPageModel(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 20);
		PageFactory.initElements(this.driver, this);
	}
	
	private String getActualGreetingText() {
		return userPageGreeting.getText();
	}
	
	public boolean verifyGreetingText(String expectedGreeting) {
		return getActualGreetingText().equalsIgnoreCase(expectedGreeting + ", " + userNameLbl.getText() + ".");
	}
	
	public void chooseFunctionInSettingsMenu(String functionName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavigationLabel")));
		settingsMenuBtn.click();
		for (WebElement function: menuFunctions) {
			if (function.getText().equalsIgnoreCase(functionName)) {
				function.click();
				break;
			}
		}
	}
}
