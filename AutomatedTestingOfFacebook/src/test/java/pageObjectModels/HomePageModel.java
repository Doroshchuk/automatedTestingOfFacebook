package pageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageModel extends BaseLoginModel{
	private WebDriver driver;
	
	//WebElements of authorization
	@FindBy(xpath = "//input[@value = 'Увійти']")
	WebElement submitAuthorizationBtn;
	
	//WebElements of registration
	@FindBy(xpath = "//input[@id = 'u_0_h']")
	WebElement nameTF;
	
	@FindBy(xpath = "//input[@id = 'u_0_j']")
	WebElement surnameTF;
	
	@FindBy(id = "u_0_m")
	WebElement phoneNumberOrEmailTF;
	
	@FindBy(id = "u_0_t")
	WebElement passwordForRegistrationTF;
	
	@FindBy(xpath = "//select[@id = 'day']")
	WebElement birthDaySF;
	
	@FindBy(xpath = "//select[@id = 'month']")
	WebElement birthMonthSF;
	
	@FindBy(xpath = "//select[@id = 'year']")
	WebElement birthYearSF;
	
	@FindBy(xpath = "//*[@name = 'sex' and @value = '1']")
	WebElement femaleRB;
	
	@FindBy(xpath = "//*[@name = 'sex' and @value = '2']")
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
		passwordForRegistrationTF.sendKeys(password);
		String dayOfBirth = dateOfBirth.split("/")[0];
		String monthOfBirth = dateOfBirth.split("/")[1];
		String yearOfBirth = dateOfBirth.split("/")[2];
		
		//set up day of birth
		choiceNecessaryValueInSelectField(birthDaySF, "//select[@id = 'day']//child::option", dayOfBirth);
		
		//set up day of birth
		choiceNecessaryValueInSelectField(birthMonthSF, "//select[@id = 'month']//child::option", monthOfBirth);
		
		//set up day of birth
		choiceNecessaryValueInSelectField(birthYearSF, "//select[@id = 'year']//child::option", yearOfBirth);
		if(sex.equalsIgnoreCase("жінка") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("женщина")) {
			femaleRB.click();
		}else if (sex.equalsIgnoreCase("чоловік") || sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("мужчина")) {
			maleRB.click();
		}
		submitRegitrationBtn.submit();
	}
	
	private void choiceNecessaryValueInSelectField(WebElement selectField, String xPath, String rightValue) {
		selectField.click();
		List<WebElement> listOfValues = driver.findElements(By.xpath(xPath));
		for (WebElement value: listOfValues) {
			if (value.equals(rightValue)) {
				value.click();
			}
		}
	}
}
