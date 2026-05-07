package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import Page_Object.tutorialsninjaslogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.ConfigReader;

public class tutorialsninjas_Test {
	 WebDriver driver;
	tutorialsninjaslogin login;
    
	ExtentTest test;
	    public tutorialsninjas_Test() {
	    	   driver = Hooks.getDriver();
	        login = new tutorialsninjaslogin(driver);
	    }

	    @Before
	    public void initExtent() {
	        test = Hooks.getTest();
	    }

	    // ================= CREATE FLOW =================

	    @Given("User launches login page")
	    public void login_page() {

	        driver.get(ConfigReader.getProperty("loginUrl"));
	    }
	    
	    
	    
	    @And("user enter username name {string}")
	    public void user_enter_username(String usernameKey) {
	    	login.enterUsername(ConfigReader.getProperty(usernameKey));
	    }

	    @And("user enter password {string}")
	    public void user_enter_password(String passwordKey) {
	    	login.enterPassword(ConfigReader.getProperty(passwordKey));
	    }

	    @And("user click on submit button")
	    public void user_click_on_submit_button() {
	    	login.clickonsubmit();
	    }}
