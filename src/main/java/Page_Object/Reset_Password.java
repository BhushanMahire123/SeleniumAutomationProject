package Page_Object;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reset_Password extends BasePage {

    WebDriverWait wait;

    public Reset_Password(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /* ================= ELEMENTS ================= */
    @FindBy(css = "a[href='/webcast/profilesettings']")
    WebElement profilesettings;

    @FindBy(id = "password")
    WebElement currentPassword;

    @FindBy(id = "newPassword")
    WebElement newpasssword;

    @FindBy(id = "confirmPassword")
    WebElement confpasssword;
    
    @FindBy(xpath = " //span[contains(text(),'Reset Password')]")
    WebElement Reset_Password;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement savebutton;

    /* ================= ACTION METHODS ================= */
    public void click_on_Account_Menu() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 1️⃣ Wait for page fully loaded
            wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));

            // 2️⃣ Optional: wait 10 sec after login
            Thread.sleep(5000);

            // 3️⃣ Switch to default content (in case iframes are used)
            driver.switchTo().defaultContent();

            // 4️⃣ First shadow host
            WebElement host1 = driver.findElement(By.cssSelector("on24-elite-top-nav-bar[product-code='webcasts']"));
            SearchContext shadowRoot1 = host1.getShadowRoot();
            Thread.sleep(1000);

            // 5️⃣ Second shadow host inside first shadow root
            WebElement host2 = shadowRoot1.findElement(By.cssSelector("on24-top-nav-account-menu"));
            SearchContext shadowRoot2 = host2.getShadowRoot();
            Thread.sleep(1000);

            // 6️⃣ The actual SVG icon inside the second shadow root
            WebElement accountIcon = shadowRoot2.findElement(By.cssSelector("div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > svg:nth-child(1)"));

            // 7️⃣ Click the account menu icon
            wait.until(ExpectedConditions.elementToBeClickable(accountIcon));
            accountIcon.click();

        } catch (Exception e) {
            throw new RuntimeException("Failed to click Account Menu inside nested Shadow DOM", e);
        }
    }
    public void click_on_Profile_Settings() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 1️⃣ Wait for page fully loaded
            wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));

            // 2️⃣ Optional: wait 10 sec after login to ensure all elements are fully loaded
            Thread.sleep(10000);

            // 3️⃣ Switch to default content (in case iframes are used)
            driver.switchTo().defaultContent();

            // 4️⃣ First shadow host (on24-elite-top-nav-bar)
            WebElement host1 = driver.findElement(By.cssSelector("on24-elite-top-nav-bar[product-code='webcasts']"));
            SearchContext shadowRoot1 = host1.getShadowRoot();
            Thread.sleep(1000);  // Adding a slight delay between shadow roots

            // 5️⃣ Second shadow host (on24-top-nav-account-menu)
            WebElement host2 = shadowRoot1.findElement(By.cssSelector("on24-top-nav-account-menu"));
            SearchContext shadowRoot2 = host2.getShadowRoot();
            Thread.sleep(1000);

            // 6️⃣ Third shadow host (on24-top-nav-account-menu-options)
            WebElement host3 = shadowRoot2.findElement(By.cssSelector("on24-top-nav-account-menu-options"));
            SearchContext shadowRoot3 = host3.getShadowRoot();
            Thread.sleep(1000);

            // 7️⃣ Profile Settings link inside the third shadow root
            WebElement profileSettingsLink = shadowRoot3.findElement(By.cssSelector("a[href='/webcast/profilesettings']"));

            // 8️⃣ Ensure Profile Settings link is clickable and click it
            wait.until(ExpectedConditions.elementToBeClickable(profileSettingsLink));
            profileSettingsLink.click();

        } catch (Exception e) {
            throw new RuntimeException("Failed to click Profile Settings link inside 3 nested Shadow DOMs", e);
        }
    }
    public void enterCurrentPassword(String currentPass) {
        wait.until(ExpectedConditions.visibilityOf(currentPassword)).sendKeys(currentPass);
    }

    public void enterNewPassword(String newPass) {
        wait.until(ExpectedConditions.visibilityOf(newpasssword)).sendKeys(newPass);
    }

    public void confirmNewPassword(String confirmNewPass) {
        wait.until(ExpectedConditions.visibilityOf(confpasssword)).sendKeys(confirmNewPass);
    }
    
    
    public void clickonresetpassword() {
    	   wait.until(ExpectedConditions.visibilityOf(Reset_Password));
           wait.until(ExpectedConditions.elementToBeClickable(Reset_Password));

           Actions actions = new Actions(driver);
           actions.moveToElement(Reset_Password).pause(500).click().build().perform();
       }

       // Optional: JS click fallback
       public void clickresetpassword() {
           try {
        	   clickresetpassword();
           } catch (Exception e) {
               ((org.openqa.selenium.JavascriptExecutor) driver)
                   .executeScript("arguments[0].click();",Reset_Password);
           }
       }
   
    
    // Method to click Save button using Actions class
    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(savebutton));
        wait.until(ExpectedConditions.elementToBeClickable(savebutton));

        Actions actions = new Actions(driver);
        actions.moveToElement(savebutton).pause(500).click().build().perform();
    }

    // Optional: JS click fallback
    public void clickSaveButtonJSFallback() {
        try {
            clickSaveButton();
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", savebutton);
        }
    }
}