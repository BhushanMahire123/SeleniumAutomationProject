package Page_Object;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TutorialNinjasPageObject  extends BasePage {

	  WebDriver driver;
	    WebDriverWait wait;

	    private static final Logger log = LogManager.getLogger(Hybrid.class);

	    public TutorialNinjasPageObject(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    // ================= LOCATORS =================

	    @FindBy(xpath = "//input[@id='input-firstname']")
	    WebElement fname;

	    @FindBy(xpath = "//input[@id='input-lastname']")
	    WebElement lname;

	    @FindBy(xpath = "//input[@id='input-email']")
	    WebElement email;

	    @FindBy(xpath = "//input[@id='input-telephone']")
	    WebElement Telephone;

	    @FindBy(xpath = "//input[@id='input-password']")
	    WebElement password;

	    @FindBy(xpath = "//input[@id='input-confirm']")
	    WebElement confpassword;

	    @FindBy(xpath = "input[value='0']")
	    WebElement newsletter;

	    @FindBy(xpath = "//input[@name='agree']")
	    WebElement privacypolicy;

	    @FindBy(xpath = "//input[@value='Continue']")
	    WebElement continuebtn;

	  
	    // ================= ACTION METHODS =================

	    public void enterFirstName(String firstName) {
	        fname.clear();
	        fname.sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        lname.clear();
	        lname.sendKeys(lastName);
	    }

	    public void enterEmail(String mail) {
	        email.clear();
	        email.sendKeys(mail);
	    }

	    public void enterTelephone(String phone) {
	    	 Telephone.clear();
	    	 Telephone.sendKeys(phone);
	    }

	    public void enterPassword(String pwd) {
	        password.clear();
	        password.sendKeys(pwd);
	    }

	    public void enterConfirmPassword(String cpwd) {
	        confpassword.clear();
	        confpassword.sendKeys(cpwd);
	    }

	    public void selectNewsletterYes() {
	    	newsletter.click();
	    }

	   

	    public void acceptPrivacyPolicy() {
	       
	            privacypolicy.click();
	        }
	    

	    public void clickContinue() {
	        continuebtn.click();
	    }}