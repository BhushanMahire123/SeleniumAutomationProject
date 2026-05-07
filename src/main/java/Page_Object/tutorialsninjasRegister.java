package Page_Object;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class tutorialsninjasRegister extends BasePage {
	
	  WebDriver driver;
	    WebDriverWait wait;

	    private static final Logger log = LogManager.getLogger(tutorialsninjasRegister.class);

	    public  tutorialsninjasRegister(WebDriver driver) {
	       
	    	  super(driver);
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    }
	    

	    By firstName = By.id("input-firstname");
	    By lastName = By.id("input-lastname");
	    By email = By.id("input-email");
	    By telephone = By.id("input-telephone");
	    By password = By.id("input-password");
	    By confirmPassword = By.id("input-confirm");
	    By privacyPolicy = By.name("agree");
	    By continueBtn = By.xpath("//input[@value='Continue']");
	    By successMsg = By.xpath("//h1[text()='Your Account Has Been Created!']");

	    public void enterFirstName(String fname) {
	        driver.findElement(firstName).sendKeys(fname);
	    }

	    public void enterLastName(String lname) {
	        driver.findElement(lastName).sendKeys(lname);
	    }

	    public void enterEmail(String mail) {
	        driver.findElement(email).sendKeys(mail);
	    }

	    public void enterTelephone(String phone) {
	        driver.findElement(telephone).sendKeys(phone);
	    }

	    public void enterPassword(String pwd) {
	        driver.findElement(password).sendKeys(pwd);
	    }

	    public void enterConfirmPassword(String cpwd) {
	        driver.findElement(confirmPassword).sendKeys(cpwd);
	    }

	    public void clickPrivacyPolicy() {
	        driver.findElement(privacyPolicy).click();
	    }

	    public void clickContinue() {
	        driver.findElement(continueBtn).click();
	    }

	    public boolean verifyAccountCreated() {
	        return driver.findElement(successMsg).isDisplayed();
	    }
	}















