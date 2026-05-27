package Page_Object;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tutorialsninjasRegister extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    private static final Logger log =
            LogManager.getLogger(tutorialsninjasRegister.class);

    public tutorialsninjasRegister(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // WebElements

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//div[@class='text-danger']")
    WebElement warningMsg;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement successMsg;

    // Action Methods

    public void enterFirstName(String fName) {

        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {

        lastName.sendKeys(lName);
    }

    public void enterEmail(String mail) {

        email.sendKeys(mail);
    }

    public void enterTelephone(String mobile) {

        telephone.sendKeys(mobile);
    }

    public void enterPassword(String pwd) {

        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {

        confirmPassword.sendKeys(cpwd);
    }

    public void clickPrivacyPolicy() {

        privacyPolicy.click();
    }

    public void clickContinueBtn() {

        continueBtn.click();
    }

    public String getWarningMessage() {

        return warningMsg.getText();
    }

    public boolean verifyAccountCreated() {

        return successMsg.isDisplayed();
    }
}