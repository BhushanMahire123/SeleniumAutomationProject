package Page_Object;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tutorialsninjaslogin extends BasePage {

	  WebDriver driver;
	    WebDriverWait wait;

	    private static final Logger log = LogManager.getLogger(tutorialsninjaslogin.class);

	    public tutorialsninjaslogin(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    @FindBy(xpath = "//input[@id='input-email']")
	    WebElement username;

	    @FindBy(xpath = "//input[@id='input-password']")
	    WebElement Password;
	    
	    
	    @FindBy(xpath = "//input[@value='Login']")
	    WebElement loginbutton;
	    
	    
public void enterUsername(String Username) {
	username.clear();
	username.sendKeys(Username);
}

public void enterPassword(String Passwordf) {
	Password.clear();
	Password.sendKeys(Passwordf);
}

public void clickonsubmit() {
	 loginbutton.click();
   
}}
