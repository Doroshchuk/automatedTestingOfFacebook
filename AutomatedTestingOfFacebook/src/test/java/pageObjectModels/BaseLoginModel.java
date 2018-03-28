package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseLoginModel {
	private WebDriver driver;
	
	//WebElements of authorization
	@FindBy(id = "email")
	WebElement emailTF;
		
	@FindBy(id = "pass")
	WebElement passwordTF;
	
	public BaseLoginModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	protected void setUserEmailOrPhone(String emailAddressOrPhone) {
		emailTF.sendKeys(emailAddressOrPhone);
	}
	
	protected void setUserPassword(String passwordValue) {
		passwordTF.sendKeys(passwordValue);
	}
	
	protected void clearEmailTF() {
		emailTF.clear();
	}
}
