package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageModel {
	private WebDriver driver;
	
	//WebElements of authorization
	@FindBy(id = "email")
	WebElement emailTF;
	
	@FindBy(id = "pass")
	WebElement passwordTF;
	
	@FindBy(xpath = "//input[@value = 'Увійти']")
	WebElement submitAuthorizationBtn;
	
	//WebElements of registration
	@FindBy(xpath = "//input[@id = 'u_0_p']")
	WebElement nameTF;
	
	@FindBy(xpath = "//input[@id = 'u_0_r']")
	WebElement surnameTF;
	
	@FindBy(id = "u_0_u")
	WebElement phoneNumberTF;
	
	@FindBy(id = "u_0_11")
	WebElement passwordForRegistrationTF;
	
	@FindBy(xpath = "//select[@id = 'day']")
	WebElement birthDaySF;
	
	@FindBy(xpath = "//select[@id = 'month']")
	WebElement birthMonthSF;
	
	@FindBy(xpath = "//select[@id = 'year']")
	WebElement birthYearSF;
	
	@FindBy(xpath = "//*[@name = 'sex' AND @value = '1']")
	WebElement femaleRB;
	
	@FindBy(xpath = "//*[@name = 'sex' AND @value = '2']")
	WebElement maleRB;
	
	@FindBy(xpath = "//button[text() = 'Створити обліковий запис']")
	WebElement submitRegitrationBtn;
	
	public HomePageModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	private void setUserEmailOrPhone(String emailAddressOrPhone) {
		emailTF.sendKeys(emailAddressOrPhone);
	}
	
	private void setUserPassword(String passwordValue) {
		passwordTF.sendKeys(passwordValue);
	}
	
	public void loginToFacebook(String emailAddressOrPhone, String password) {
		setUserEmailOrPhone(emailAddressOrPhone);
		setUserPassword(password);
		submitAuthorizationBtn.submit();
	}
	
	public boolean verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		return actualTitle.equals(expectedTitle);
	}
	
	public void clearEmailTF() {
		emailTF.clear();
	}
}
