package project2.stepDefinitions;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.Login_Page;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class LoginSteps {

	 Login_Page lp;
	    ExtentTest test;

	
	    public  LoginSteps() {

	       this.lp=BaseClass.lp;
	    }

	 @Before   
	 public void initExtent() {
		 
		 test=Hooks.getTest();
	 }
	    
	    @When("User opens URL {string}")
	    public void open_url(String urlKey) {

	        String url = ConfigReader.getProperty(urlKey);
	        BaseClass.driver.get(url);

	      

	        test.info("Opened URL → " + url);
	    }

	    @And("User enters Email as {string} and Password as {string}")
	    public void enter_credentials(String userKey, String passKey) {

	        lp.enter_username(ConfigReader.getProperty(userKey));
	        lp.enter_Password(ConfigReader.getProperty(passKey));

	        test.info("Entered Credentials");
	    }

	    @And("Click on Login")
	    public void click_login() {

	        lp.clickonlogin();
	        test.info("Clicked Login");
	    }

	    @When("User searches webcast event with event ID {string}")
	    public void searchEvent(String eventKey) {

	        String eventId = ConfigReader.getProperty(eventKey);

	        lp.entereventid(eventId);

	        test.info("Event searched → " + eventId);
	    }

	    @When("User clicks on Search button")
	    public void clickSearch() {

	        lp.clicksearchbutton();
	        test.info("Clicked Search Button");
	    }

	    @Then("Verify the title of the searched event is displayed")
	    public void verifyTitle() {

	        String eventTitle = lp.getEventTitle();

	        Assert.assertFalse(eventTitle.isEmpty(),
	                "Event Title NOT displayed");

	        test.pass("Event Title Displayed → " + eventTitle);
	    }

	    @Then("User clicks on the title of the searched event")
	    public void clickTitle() {

	        lp.clickEventTitle();
	        test.info("Clicked Event Title");
	    }

	    @Then("User can see overview page title {string}")
	    public void verifyOverview(String Title) {

	        String actualTitle = lp.getTitleText();

	        Assert.assertEquals(Title,lp.getTitleText());
	    }

	    @And("User clicks on Reg Tab")
	    public void clickReg() {

	        lp.clickonregtab();
	        test.info("Clicked Registration Tab");
	    }
	}