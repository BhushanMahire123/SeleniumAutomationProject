package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.TutorialNinjasPageObject;
import Page_Object.practicetestautomationobject;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import utils.ConfigReader;

public class practicetestautomationTest {
	practicetestautomationobject practicetestautomation;
    
	ExtentTest test;
	    public practicetestautomationTest() {
	        WebDriver driver = Hooks.getDriver();
	        practicetestautomation = new 	practicetestautomationobject(driver);
	    }

	    @Before
	    public void initExtent() {
	        test = Hooks.getTest();
	    }

	    // ================= CREATE FLOW =================

	    @And("user enter username name {string}")
	    public void user_enter_username(String usernameKey) {
	        practicetestautomation.enterUsername(ConfigReader.getProperty(usernameKey));
	    }

	    @And("user enter password {string}")
	    public void user_enter_password(String passwordKey) {
	        practicetestautomation.enterPassword(ConfigReader.getProperty(passwordKey));
	    }

	    @And("user click on submit button")
	    public void user_click_on_submit_button() {
	        practicetestautomation.clickonsubmit();
	    }}
