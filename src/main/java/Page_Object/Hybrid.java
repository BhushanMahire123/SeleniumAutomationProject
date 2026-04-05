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

public class Hybrid extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    private static final Logger log = LogManager.getLogger(Hybrid.class);

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

    @FindBy(xpath = "//button[@id='previewButton0']//span[@class='css-1tjylaa']")
    WebElement previewandedit;

    @FindBy(css = "button[id='insertToken-1'] svg")
    WebElement inserttoken;

    @FindBy(xpath = "//a[@data-param1='#CHECKINQRIMAGE#']")
    WebElement checkInQRToken;

    @FindBy(xpath = "//a[@data-param1='#CHECKINQRBADGELINK#']")
    WebElement checkInBadgeToken;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement savebtn;

    @FindBy(xpath = "//button[@class='css-1s7p710']//span[normalize-space()='Close']")
    WebElement close;

    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    WebElement yesbtn;

    @FindBy(xpath = "//div[@title='attendee_type']")
    WebElement Attendee_type;

    @FindBy(xpath = "//button[normalize-space()='Link and Embed']")
    WebElement Link_and_Embed;

    @FindBy(xpath = "//p[normalize-space()='Event/Audience Link']")
    WebElement Audience_Link;

    @FindBy(id = "firstname")
    WebElement firstname;

    @FindBy(id = "lastname")
    WebElement lastname;

    @FindBy(id = "email")
    WebElement emailid;

    @FindBy(id = "company")
    WebElement companyname;

    @FindBy(id = "attendee_type198")
    WebElement In_Person;

    @FindBy(id = "submitRegister")
    WebElement registerButton;

    // ================= ACTION METHODS =================

    public void clickCreate() {
        log.info("Clicking on Create button");
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void enterEventTitle(String title) {
        log.info("Entering Event Title: {}", title);
        wait.until(ExpectedConditions.visibilityOf(eventTitleField)).clear();
        eventTitleField.sendKeys(title);
    }

    public void selectDate(String date) {
        log.info("Selecting Date: {}", date);
        wait.until(ExpectedConditions.elementToBeClickable(dateButton)).clear();
        dateButton.sendKeys(date);
    }

    public void scrollToHybrid() {
        log.info("Scrolling to Hybrid section");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hybridToggle);
    }

    public void clickHybrid() {
        log.info("Clicking on Hybrid toggle");
        wait.until(ExpectedConditions.elementToBeClickable(hybridToggle)).click();
    }

    public boolean isVenueVisible() {
        log.info("Verifying Venue field visibility");
        return wait.until(ExpectedConditions.visibilityOf(venueField)).isDisplayed();
    }

    public boolean isAddressVisible() {
        log.info("Verifying Address field visibility");
        return wait.until(ExpectedConditions.visibilityOf(addressField)).isDisplayed();
    }

    public void enterVenue(String venue) {
        log.info("Entering Venue: {}", venue);
        wait.until(ExpectedConditions.visibilityOf(venueField)).clear();
        venueField.sendKeys(venue);
    }

    public void enterAddress(String address) {
        log.info("Entering Address");
        wait.until(ExpectedConditions.visibilityOf(addressField)).clear();
        addressField.sendKeys(address);
    }

    public void clickSave() {
        log.info("Clicking on Save button");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);

        wait.until(ExpectedConditions.visibilityOf(saveButton));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("Interrupted while clicking Save", e);
        }

        js.executeScript("arguments[0].click();", saveButton);
    }

    public void forceScrollToElement() {
        log.info("Scrolling to Email section");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailsection);
    }

    public void clickonpreview() {
        log.info("Clicking on Preview button");
        wait.until(ExpectedConditions.elementToBeClickable(previewandedit)).click();
    }

    public void clickoninserttoken() {
        log.info("Clicking on Insert Token");
        wait.until(ExpectedConditions.elementToBeClickable(inserttoken)).click();
    }

    public void addEmailTokens() {
        log.info("Adding Email Tokens");

        wait.until(ExpectedConditions.visibilityOf(checkInQRToken));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkInQRToken);
        checkInQRToken.click();

        clickoninserttoken();

        wait.until(ExpectedConditions.visibilityOf(checkInBadgeToken));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkInBadgeToken);
        checkInBadgeToken.click();

        log.info("Email tokens added successfully");
    }

    public void clickonsavebutton() {
        log.info("Clicking on Save button (Email section)");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", savebtn);

        wait.until(ExpectedConditions.visibilityOf(savebtn));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("Interrupted while clicking save button", e);
        }

        js.executeScript("arguments[0].click();", savebtn);
    }

    public void clickonclosebutton() {
        log.info("Clicking on Close button");
        wait.until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void clickonyesbutton() {
        log.info("Clicking on Yes button");
        wait.until(ExpectedConditions.elementToBeClickable(yesbtn)).click();
    }

    public void verifyattendeetype() {
        log.info("Scrolling to Attendee Type section");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Attendee_type);
    }

    public void click_on_link_embed() {
        log.info("Clicking on Link and Embed");
        wait.until(ExpectedConditions.elementToBeClickable(Link_and_Embed)).click();
    }

    public void click_on_audience_link() {
        log.info("Clicking on Audience Link");
        wait.until(ExpectedConditions.elementToBeClickable(Audience_Link)).click();
    }

    public void user_enter_first_name(String firstnameVal) {
        log.info("Entering First Name: {}", firstnameVal);

        wait.until(ExpectedConditions.elementToBeClickable(firstname));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstname);

        firstname.clear();
        firstname.sendKeys(firstnameVal);
    }

    public void enter_last_name(String lastName) {
        log.info("Entering Last Name: {}", lastName);
        wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(lastName);
    }

    public void enter_emaile(String email) {
        log.info("Entering Email");
        wait.until(ExpectedConditions.visibilityOf(emailid)).sendKeys(email);
    }

    public void enter_company(String company) {
        log.info("Entering Company: {}", company);
        wait.until(ExpectedConditions.visibilityOf(companyname)).sendKeys(company);
    }

    public void select_inperson(String type) {
        log.info("Selecting In-Person attendee type");

        wait.until(ExpectedConditions.elementToBeClickable(In_Person));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", In_Person);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", In_Person);
    }

    public void click_register_button() {
        log.info("Clicking on Register button");

        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);

        registerButton.click();
    }
}