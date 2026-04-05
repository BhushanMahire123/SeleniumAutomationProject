package Page_Object;

import java.time.Duration;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page_element extends BasePage {

    WebDriverWait wait;

    public login_page_element(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Simple & stable locator
    @FindBy(xpath = "//div[@class='MuiBox-root css-hshm0p']//a[@aria-label='ON24 Home Page']//*[name()='svg']//*[name()='path' and contains(@d,'M43.345 18')]")
    WebElement logo;

    /* ================= METHODS ================= */

    public void verifyLogo() {
    	logo.isDisplayed();
    }
    }
