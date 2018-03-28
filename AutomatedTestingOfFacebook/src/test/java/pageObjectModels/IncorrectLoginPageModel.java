package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncorrectLoginPageModel {
	private WebDriver driver;
	
	//WebElements of authorization
	@FindBy(id = "email")
	WebElement emailTF;
	
	@FindBy(id = "pass")
	WebElement passwordTF;
	
	@FindBy(xpath = "//a[contains(text(),'Забули пароль?')]")
	WebElement link_ForgotPassword;
	
	@FindBy(xpath = "//div[@class='_4rbf _53ij']")
	WebElement messageBox;
	
	@FindBy(xpath = "//button[@id = 'loginbutton']")
	WebElement repeatedAuthorizationBtn;
	
	public IncorrectLoginPageModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	private void setUserEmailOrPhone(String emailAddressOrPhone) {
		emailTF.sendKeys(emailAddressOrPhone);
	}
	
	private void setUserPassword(String passwordValue) {
		passwordTF.sendKeys(passwordValue);
	}
	
	public void repeatedLoginToFacebook(String emailAddressOrPhone, String password) {
		setUserEmailOrPhone(emailAddressOrPhone);
		setUserPassword(password);
		repeatedAuthorizationBtn.submit();
	}
	
	
	public boolean messageBoxContainsLink() {
		return link_ForgotPassword.isDisplayed();
	}
	
	private String findOutTheBackgroundColorOfElement(WebElement element) {
		return element.getCssValue("background-color");
	}
	
	public boolean verifyTheBackgroundColorOfMessageBox(String expectedColor) {
		return findOutTheBackgroundColorOfElement(messageBox).equals(expectedColor);
	}
	
	public boolean verifyTextOfMessageNearEmailTF(String expectedText) {
		String actualText = messageBox.getText();
		return actualText.equals(expectedText);
	}
	
	public void clearEmailTF() {
		emailTF.clear();
	}
}
