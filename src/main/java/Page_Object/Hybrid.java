package Page_Object;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hybrid extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public Hybrid(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ================= LOCATORS =================

    @FindBy(xpath = "//button[normalize-space()='Create']")
    WebElement createButton;

    @FindBy(id = "eventTitle")
    WebElement eventTitleField;

    @FindBy(id = "startDate")
    WebElement dateButton;

    // ✅ CORRECT Hybrid Toggle Locator
    @FindBy(xpath = "//span[normalize-space()='Hybrid']")
    WebElement hybridToggle;

    @FindBy(id = "hybridVenue")
    WebElement venueField;

    @FindBy(id = "hybridAddress")
    WebElement addressField;

    @FindBy(xpath = "//button[contains(@class,'css-1pbvwrv')]")
    WebElement saveButton;
    

    @FindBy(xpath = "//h2[normalize-space()='Email Notifications']")
    WebElement emailsection;
    
    @FindBy(xpath = " //button[@id='previewButton0']//span[@class='css-1tjylaa']")
    WebElement previewandedit;
    
    @FindBy(css = "button[id='insertToken-1'] svg")
    WebElement inserttoken;

 // ================= TOKEN LOCATORS =================

    @FindBy(xpath = "//a[@data-param1='#CHECKINQRIMAGE#']")
    WebElement checkInQRToken;

    @FindBy(xpath = "//a[@data-param1='#CHECKINQRBADGELINK#']")
    WebElement checkInBadgeToken;
   
    
    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement savebtn;

    
    @FindBy(xpath = "//button[@class='css-1s7p710']//span[@class='css-qa3ytp'][normalize-space()='Close']")
    WebElement close;
    
    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    WebElement yesbtn;
    
    @FindBy(xpath = "//div[@title='attendee_type']")
    WebElement Attendee_type;
    
    
    @FindBy(xpath = "  //button[normalize-space()='Link and Embed']")
    WebElement Link_and_Embed;
    
    @FindBy(xpath = "  //p[normalize-space()='Event/Audience Link']")
    WebElement Audience_Link;
    
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement   firstname;
    
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement   lastname;
   
    @FindBy(xpath = "//input[@id='email']")
    WebElement   emailid;
    
    @FindBy(xpath = "//input[@id='company']")
    WebElement   companyname;
   
    
    @FindBy(xpath = "//span[input[@value='In-Person']]")
    WebElement In_Person;
    
    @FindBy(xpath = "//button[@id='submitRegister']")
    WebElement registerButton;

   
  
    // ================= ACTION METHODS =================

    public void clickCreate() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void enterEventTitle(String title) {
        wait.until(ExpectedConditions.visibilityOf(eventTitleField)).clear();
        eventTitleField.sendKeys(title);
    }

    public void selectDate(String date) {
        wait.until(ExpectedConditions.elementToBeClickable(dateButton)).clear();
        dateButton.sendKeys(date);
    }

    // ✅ Scroll to Hybrid Toggle
    public void scrollToHybrid() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hybridToggle);
    }

    // ✅ Click Hybrid Toggle
    public void clickHybrid() {
        wait.until(ExpectedConditions.elementToBeClickable(hybridToggle)).click();
    }
    
    // ✅ Verify Venue Visible
    public boolean isVenueVisible() {
        return wait.until(ExpectedConditions.visibilityOf(venueField)).isDisplayed();
    }

    // ✅ Verify Address Visible
    public boolean isAddressVisible() {
        return wait.until(ExpectedConditions.visibilityOf(addressField)).isDisplayed();
    }

    public void enterVenue(String venue) {
        wait.until(ExpectedConditions.visibilityOf(venueField)).clear();
        venueField.sendKeys(venue);
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressField)).clear();
        addressField.sendKeys(address);
    }
    
    
    
    public void clickSave() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to element
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);

        // Wait until visible
        wait.until(ExpectedConditions.visibilityOf(saveButton));

        // Small wait for overlay animation (optional but useful)
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click using JavaScript
        js.executeScript("arguments[0].click();", saveButton);
    }
    
    public void forceScrollToElement() {

    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", emailsection);
     }
    
    
    
    public void clickonpreview() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(previewandedit)).click();;
    }
    
    
    // ✅ Scroll to Hybrid Toggle
    public void clickoninserttoken() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(inserttoken)).click();;
    }
    
    
    public void scrollToToken(WebElement token) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            token
        );

        wait.until(ExpectedConditions.visibilityOf(token));
    }
    
    public void addEmailTokens() {

        wait.until(ExpectedConditions.visibilityOf(checkInQRToken));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll & click QR token
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkInQRToken);
        checkInQRToken.click();

        // If dropdown closes, reopen it
        clickoninserttoken();

        wait.until(ExpectedConditions.visibilityOf(checkInBadgeToken));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkInBadgeToken);
        checkInBadgeToken.click();
    }
    
    public void clickonsavebutton() {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;

          // Scroll to element
          js.executeScript("arguments[0].scrollIntoView({block: 'center'});", savebtn);

          // Wait until visible
          wait.until(ExpectedConditions.visibilityOf(savebtn));

          // Small wait for overlay animation (optional but useful)
          try {
              Thread.sleep(500);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          // Click using JavaScript
          js.executeScript("arguments[0].click();", savebtn);
      }
    public void clickonclosebutton() {
    	 wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    
    
    }
    public void clickonyesbutton() {
   	 wait.until(ExpectedConditions.elementToBeClickable(yesbtn)).click();
   
   
   }
    
   public void verifyattendeetype() {
	   
		 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", Attendee_type);
     }
   
   public void click_on_link_embed() {
	   
		 wait.until(ExpectedConditions.elementToBeClickable(Link_and_Embed)).click();     
   }
   
   public void click_on_audience_link() {
	   
	   wait.until(ExpectedConditions.elementToBeClickable(Audience_Link)).click();  
   
   }
   
  

	public void user_enter_first_name(String firs_tname) {
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(firstname));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", firstname);

		firstname.clear();
		firstname.sendKeys(firs_tname);
		
		
		
		   
	}

	public void enter_last_name(String last_name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(last_name);
	
	    
	}
	public void enter_emaile(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(emailid)).sendKeys(email);
		
	
	    
	}

	public void enter_company(String company) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(companyname)).sendKeys(company);
	
	    
	}


	public void select_inperson(String inperson) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.elementToBeClickable(In_Person));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", In_Person);

	    js.executeScript("arguments[0].click();", In_Person);
	}
	public void click_register_button() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.elementToBeClickable(registerButton));

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", registerButton);

	    registerButton.click();
	}
	    
	}


	
   
   



    
    
   
