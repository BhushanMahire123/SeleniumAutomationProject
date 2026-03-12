package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.Reset_Password;
import Page_Object.login_page_element;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

public class loging_page_test {
	

	login_page_element LPE;
    ExtentTest test;

    public loging_page_test() {
        WebDriver driver = Hooks.getDriver();
        LPE = new login_page_element(driver);
    }

    @Before
    public void initExtent() {
        test = Hooks.getTest();
    }

    // Step: Wait 10 seconds after login
    @And("user wait 10 sec")
    public void user_wait_10_sec() {
        try {
        	Thread.sleep(10000); // Wait 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
    }

    @And("User Verify logo {string}")
    public void user_verify_logo() {
        LPE.verifyLogo();
    }

}
