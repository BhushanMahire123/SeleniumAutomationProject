package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.Hybrid;
import Page_Object.TutorialNinjasPageObject;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class TutorialNinjasPageObjectTest {

	TutorialNinjasPageObject tutorialninjas;
	    
	ExtentTest test;
	    public TutorialNinjasPageObjectTest() {
	        WebDriver driver = Hooks.getDriver();
	        tutorialninjas = new TutorialNinjasPageObject(driver);
	    }

	    @Before
	    public void initExtent() {
	        test = Hooks.getTest();
	    }

	    // ================= CREATE FLOW =================

	    @And("user enter f name {string}")
	    public void user_enter_first_name(String firstName) {
	    	tutorialninjas.enterFirstName(ConfigReader.getProperty(firstName));
	    }

	    @And("user enter l name {string}")
	    public void user_enter_last_name(String lastName) {
	    	tutorialninjas.enterLastName(ConfigReader.getProperty(lastName));
	    }

	    @And("user enter mail {string}")
	    public void user_enter_email(String email) {
	    	tutorialninjas.enterEmail(ConfigReader.getProperty(email));
	    }

	    @And("user enter telephone {string}")
	    public void user_enter_telephone(String phone) {
	    	tutorialninjas.enterTelephone(ConfigReader.getProperty(phone));
	    }

	    @And("user enter pass {string}")
	    public void user_enter_password(String password) {
	    	tutorialninjas.enterPassword(ConfigReader.getProperty(password));
	    }

	    @And("user enter conf password {string}")
	    public void user_enter_confirm_password(String confPassword) {
	    	tutorialninjas.enterConfirmPassword(ConfigReader.getProperty(confPassword));
	    }

	    @And("user select newsletter yes")
	    public void user_select_newsletter_yes() {
	    	tutorialninjas.selectNewsletterYes();
	    }

	  

	    @And("user accept privacy policy")
	    public void user_accept_privacy_policy() {
	    	tutorialninjas.acceptPrivacyPolicy();
	    }

	    @And("user clicks on continue button")
	    public void user_clicks_on_continue_button() {
	    	tutorialninjas.clickContinue();
	    }
	}