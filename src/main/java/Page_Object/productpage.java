package Page_Object;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productpage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    private static final Logger log =
            LogManager.getLogger(productpage.class);

    public productpage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    private WebElement featuredSection;

    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    private WebElement MacBook;

    @FindBy(xpath = "  //button[@id='button-cart']")
    private WebElement button;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement button_cart;
    
    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement cart_total;
    
 



   
    public void scrollToFeaturedSection() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                featuredSection);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFeaturedSectionDisplayed() {
        return featuredSection.isDisplayed();
    }
    
    public void userclickonmacbook() {
    	
    	MacBook.click();
    }
    		
    public void scrollToaddtocart() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                button);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isaddtocardSectionDisplayed() {
        return button.isDisplayed();
    }
public void userclickonaddtocartbutton() {
    	
	button_cart.click();
    }
    		
public void userclickonaddcart() {
	
	cart_total.click();
}
    		
}