package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import Page_Object.Reset_Password;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import utils.ConfigReader;

public class Reset_Password_Test {

    Reset_Password RP;
    ExtentTest test;

    public Reset_Password_Test() {
        WebDriver driver = Hooks.getDriver();
        RP = new Reset_Password(driver);
    }

    @Before
    public void initExtent() {
        test = Hooks.getTest();
    }

   

    @And("User clicks on Account Menu")
    public void user_clicks_account_menu() {
        RP.click_on_Account_Menu();
    }

    @And("User clicks on Profile Setting")
    public void user_clicks_profile_setting() {
        RP.click_on_Profile_Settings();
    }

 // Step Definitions for Cucumber

    @And("User enters Current Password {string}")
    public void user_enters_current_password(String currentPasswordKey) {
        String currentPass = ConfigReader.getProperty(currentPasswordKey);
        if (currentPass == null) {
            throw new IllegalArgumentException("Property for key '" + currentPasswordKey + "' is null! Check your config.properties file.");
        }
        RP.enterCurrentPassword(currentPass);
    }

    @And("User enters New Password {string}")
    public void user_enters_new_password(String newPasswordKey) {
        String newPass = ConfigReader.getProperty(newPasswordKey);
        if (newPass == null) {
            throw new IllegalArgumentException("Property for key '" + newPasswordKey + "' is null! Check your config.properties file.");
        }
        RP.enterNewPassword(newPass);
    }

    @And("User enters Confirm Password {string}")
    public void user_enters_confirm_password(String confirmPasswordKey) {
        String confirmPass = ConfigReader.getProperty(confirmPasswordKey);
        if (confirmPass == null) {
            throw new IllegalArgumentException("Property for key '" + confirmPasswordKey + "' is null! Check your config.properties file.");
        }
        RP.confirmNewPassword(confirmPass);
    }
    
    
    @And("user click on reset password button")
    public void user_click_on_reset_password_button() {
    	
    	RP.clickonresetpassword();
    	
    }
    
    
    @And("user wait additional 10 sec")
    public void user_wait_10_sec1() {
        try {
            Thread.sleep(5000);  // Wait 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @And("User clicks on Save Button")
    public void user_clicks_save_button() {
    	
        RP.clickSaveButton();
    }
}