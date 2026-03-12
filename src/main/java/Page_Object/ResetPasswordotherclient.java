package Page_Object;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordotherclient extends  BasePage {
	
	
	  WebDriverWait wait;

	    public ResetPasswordotherclient(WebDriver driver) {
	        super(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    }

	    @FindBy(xpath = "//p[normalize-space()='Select Account']")
	    private WebElement dropdownElement;

	    public void clickOnDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click();
	    }
	        
	    
	    public void selectClient(String clientName) {

	        clickOnDropdown();  // ensure dropdown open

	        String dynamicXpath = "//li[@role='option' and normalize-space()='" 
	                              + clientName.trim() + "']";

	        WebElement clientOption = wait.until(
	                ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));

	        clientOption.click();
	    }}