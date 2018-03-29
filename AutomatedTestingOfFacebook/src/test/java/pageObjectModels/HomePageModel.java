package pageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.UpAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageModel extends BaseLoginModel{
	private WebDriver driver;
	
	//WebElements of authorization
	@FindBy(xpath = "//input[@value = 'Увійти']")
	WebElement submitAuthorizationBtn;
	
	//WebElements of registration
	@FindBy(xpath = "//input[@id = 'u_0_p']")
	WebElement nameTF;
	
	@FindBy(xpath = "//input[@id = 'u_0_r']")
	WebElement surnameTF;
	
	@FindBy(id = "u_0_u")
	WebElement phoneNumberOrEmailTF;
	
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
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
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
	
	public void registerAccount(String name, String surname, String phoneOrEmail, String password, String dateOfBirth, String sex) { 
		nameTF.sendKeys(name);
		surnameTF.sendKeys(surname);
		phoneNumberOrEmailTF.sendKeys(phoneOrEmail);
		String dayOfBirth = dateOfBirth.split("/")[0];
		String monthOfBirth = dateOfBirth.split("/")[1];
		String yearOfBirth = dateOfBirth.split("/")[2];
		
		//set up day of birth
		birthDaySF.click();
		List<WebElement> days = driver.findElements(By.xpath("//select[@id = 'day']//child::option"));
		for (WebElement day: days) {
			if (day.equals(dayOfBirth)) {
				day.click();
			}
		}
		birthMonthSF.click();
		List<WebElement> months = driver.findElements(By.xpath("//select[@id = 'month']//child::option"));
		for (WebElement month: months) {
			if (month.equals(monthOfBirth)) {
				month.click();
			}
		}
		birthYearSF.click();
		List<WebElement> years = driver.findElements(By.xpath("//select[@id = 'year']//child::option"));
		for (WebElement year: years) {
			if (year.equals(yearOfBirth)) {
				year.click();
			}
		}
	}
}
