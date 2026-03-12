package Page_Object;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page  extends BasePage{
	  public Login_Page(WebDriver driver) {
	        super(driver);
	    }

	    @FindBy(id = "username")
	    WebElement username;

	    @FindBy(id = "password")
	    WebElement password;

	    @FindBy(xpath = "//span[contains(text(),'Login')]")
	    WebElement login;

	    @FindBy(id = "eventSearch")
	    WebElement eventSearch;

	    @FindBy(css = "button[data-testid='Events_searchButton']")
	    WebElement searchbtn;

	    // ✅ Generic & Stable
	    @FindBy(linkText = "Vanity")
	    WebElement eventTitle;

	    // ✅ NEVER use dynamic class
	    @FindBy(xpath = "//h1[normalize-space()='Overview']")
	    WebElement pageTitle;

	    @FindBy(xpath = "//p[normalize-space()='Registration']")
	    WebElement Registration;

	    // ✅ Proper Wait Usage Everywhere

	    public void enter_username(String user) {

	      
	        username.clear();
	        username.sendKeys(user);
	    }

	    public void enter_Password(String Pass) {

	       
	        password.clear();
	        password.sendKeys(Pass);
	    }

	    public void clickonlogin() {

	       
	        login.click();
	    }

	    public void entereventid(String eventId) {

	      
	        eventSearch.clear();
	        eventSearch.sendKeys(eventId);
	    }

	    public void clicksearchbutton() {
	    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	    	    wait.until(ExpectedConditions.elementToBeClickable(searchbtn));

	    	    ((JavascriptExecutor) driver).executeScript(
	    	        "arguments[0].scrollIntoView({block:'center'});", searchbtn
	    	    );

	    	    try {
	    	    	searchbtn.click();
	    	    } 
	    	    catch (ElementClickInterceptedException e) {

	    	        System.out.println("Normal click failed, using JS click");

	    	        ((JavascriptExecutor) driver).executeScript(
	    	            "arguments[0].click();",searchbtn
	    	        );
	    	    }}
	    	

	    public String getEventTitle() {
	    	new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(eventTitle));

	       
	        return eventTitle.getText();
	    }

	    public void clickEventTitle() {
	    	new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(eventTitle));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click;", eventTitle);
	    }

	    public String getTitleText() {

	        return pageTitle.getText();
	    }

	    public void clickonregtab() {

	     
	        Registration.click();
	    }
	}
