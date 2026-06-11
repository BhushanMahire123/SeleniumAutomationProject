package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.productpage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class Product_Test {

    WebDriver driver;
    productpage pp;
    ExtentTest test;

    public Product_Test() {

        driver = Hooks.getDriver();
        pp = new productpage(driver);
    }

    @Before
    public void initExtent() {

        test = Hooks.getTest();
    }

    @Given("User launches orangehrm url")
    public void user_launches_register_page() {

        driver.get(ConfigReader.getProperty("orangehrmurl"));
        driver.manage().window().maximize();
    }

    @When("user scroll to featured section")
    public void user_scroll_to_featured_section() throws InterruptedException {

        pp.scrollToFeaturedSection();
        Thread.sleep(2000);
    }

    @Then("featured section should be visible")
    public void featured_section_should_be_visible() {

        Assert.assertTrue(
                pp.isFeaturedSectionDisplayed(),
                "Featured section is not visible");
    }

    @And("user click on macbook product")
    public void clickonproduct() throws InterruptedException {

        pp.userclickonmacbook();
        Thread.sleep(2000);
    }

    @When("user scroll to addtocart section")
    public void user_scroll_to_addtocart_section() throws InterruptedException {

        pp.scrollToaddtocart();
        Thread.sleep(2000);
    }

    @Then("add to cart section should be visible")
    public void cart_section_should_be_visible() {

        Assert.assertTrue(
                pp.isaddtocardSectionDisplayed(),
                "addtocard section is not visible");
    }

    @And("user click on add to cart button")
    public void clickonadtocart() throws InterruptedException {

        pp.userclickonaddtocartbutton();
        Thread.sleep(2000);
    }

    @And("user click on add to cart icon")
    public void clickonadtocarticon() throws InterruptedException {

  
        pp.userclickonaddcart();
        Thread.sleep(2000);
    }
}