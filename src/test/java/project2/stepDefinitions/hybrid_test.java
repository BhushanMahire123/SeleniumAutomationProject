package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.Hybrid;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class hybrid_test {

    Hybrid Hy;
    ExtentTest test;
    public hybrid_test() {
        WebDriver driver = Hooks.getDriver();
        Hy = new Hybrid(driver);
    }

    @Before
    public void initExtent() {
        test = Hooks.getTest();
    }

    // ================= CREATE FLOW =================

    @And("user click on create button")
    public void user_click_on_create_button() {
        Hy.clickCreate();
    }

    @And("user enter event title {string}")
    public void user_enter_event_title(String eventTitle) {
        Hy.enterEventTitle(ConfigReader.getProperty(eventTitle));
    }

    @And("user select date from date picker {string}")
    public void user_select_date_from_date_picker(String date) {
        Hy.selectDate(ConfigReader.getProperty(date));
    }

    // ================= HYBRID FLOW =================

    @And("user scroll to Hybrid section")
    public void user_scroll_to_hybrid_section() {
        Hy.scrollToHybrid();
    }

    @When("user clicks on Hybrid toggle")
    public void user_clicks_on_hybrid_toggle() {
        Hy.clickHybrid();
    }

    // ================= VERIFICATION =================

    @Then("Venue and Address fields should be visible")
    public void venue_and_address_fields_should_be_visible() {
        Assert.assertTrue(Hy.isVenueVisible(), 
            "Venue field is not visible after enabling Hybrid");
        Assert.assertTrue(Hy.isAddressVisible(), 
            "Address field is not visible after enabling Hybrid");
    }

    // ================= DATA ENTRY =================

    @And("user enters venue {string}")
    public void user_enters_venue(String venue) {
        Hy.enterVenue(ConfigReader.getProperty(venue));
    }

    @And("user enters address {string}")
    public void user_enters_address(String address) {
        Hy.enterAddress(ConfigReader.getProperty(address));
    }

    @And("user clicks on Save button")
    public void user_clicks_on_save_button() {
        Hy.clickSave();
    }
    
    @And("user scroll to email section")
    public void user_scroll_to_email_section() {
        Hy.forceScrollToElement();
    }
    
    @And("user click on preview")
    public void user_click_on_preview() {
        Hy.clickonpreview();
    }
    
    @And("user click on insert token")
    public void user_click_insert_token() {
        Hy.clickoninserttoken();
    }
    
    @And("user adds email tokens")
    public void user_adds_email_tokens() {
        Hy.addEmailTokens();
    
    }
    
    @And("user clicks on Save btn")
    public void user_clicks_on_save_btn() {
        Hy.clickonsavebutton();
    }
    

    @And("user clicks on close btn")
    public void user_clicks_on_close_btn() {
        Hy.clickonclosebutton();
    }
    
    @And("user clicks on yes btn")
    public void user_clicks_on_yes_btn() {
        Hy.clickonyesbutton();
    }
    @And("user scroll to Attendee_type section")
    public void user_scroll_to_Attendee_type_section() {
        Hy.verifyattendeetype();
    }

    @And("user clicks on link and embed  btn")
    public void user_clicks_on_linkandembed_btn() {
        Hy.click_on_link_embed();
    }
    
    @And("user clicks on Audience Link btn")
    public void user_clicks_on_Audience_Link_btn() {

        Hy.click_on_audience_link();

        // Switch to new tab
        String parent = Hooks.getDriver().getWindowHandle();

        for (String window : Hooks.getDriver().getWindowHandles()) {
            if (!window.equals(parent)) {
                Hooks.getDriver().switchTo().window(window);
            }
        }}
    
    
    @And("user enter first name {string}")
    public void user_first_name(String Firstname) {
        Hy.user_enter_first_name(ConfigReader.getProperty(Firstname));
    }
   
    @And("user enter last name {string}")
    public void user_last_name(String lasttname) {
    	 Hy.enter_last_name(ConfigReader.getProperty(lasttname));
    	
    }	
    @And("user enter email name {string}")
    public void user_email_name(String email) {
    	 Hy.enter_emaile(ConfigReader.getProperty(email));
    	
    }	
    @And("user enter company name {string}")
    public void user_company_name(String company) {
    	 Hy.enter_company(ConfigReader.getProperty(company));
    	
    }
    // In Person Selection
    @And("user select inperson {string}")
    public void select_inperson(String Attendee_Type) {

        Hy.select_inperson(ConfigReader.getProperty(Attendee_Type));

    
    }
    @And("user clicks on register button")
    public void user_clicks_on_register_button() {

        Hy.click_register_button();

    }
    
    }
  
    

