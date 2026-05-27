package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.tutorialsninjasRegister;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.RandomDataGenerator;

public class tutorialsninjasRegisterTest {

    WebDriver driver;

    tutorialsninjasRegister registerPage;

    ExtentTest test;

    public tutorialsninjasRegisterTest() {

        driver = Hooks.getDriver();

        registerPage = new tutorialsninjasRegister(driver);
    }

    @Before
    public void initExtent() {

        test = Hooks.getTest();
    }

    @Given("User launches register page")
    public void user_launches_register_page() {

        driver.get(ConfigReader.getProperty("registerUrl"));
    }

    @When("user enters firstname {string}")
    public void user_enters_firstname(String firstNameKey) {

        registerPage.enterFirstName(
                ConfigReader.getProperty(firstNameKey));
    }

    @And("user enters lastname {string}")
    public void user_enters_lastname(String lastNameKey) {

        registerPage.enterLastName(
                ConfigReader.getProperty(lastNameKey));
    }

    @And("user enters email {string}")
    public void user_enters_email(String emailKey) {

        String dynamicEmail =
                RandomDataGenerator.generateEmail();

        System.out.println(
                "Generated Email: " + dynamicEmail);

        registerPage.enterEmail(dynamicEmail);
    }

    @And("user enters telephone {string}")
    public void user_enters_telephone(String telephoneKey) {

        registerPage.enterTelephone(
                ConfigReader.getProperty(telephoneKey));
    }

    @And("user enters password {string}")
    public void user_enters_password(String passwordKey) {

        registerPage.enterPassword(
                ConfigReader.getProperty(passwordKey));
    }

    @And("user enters confirm password {string}")
    public void user_enters_confirm_password(String passwordKey) {

        registerPage.enterConfirmPassword(
                ConfigReader.getProperty(passwordKey));
    }

    @And("user clicks privacy policy checkbox")
    public void user_clicks_privacy_policy_checkbox() {

        registerPage.clickPrivacyPolicy();
    }

    @And("User clicks on continue button")
    public void user_clicks_on_continue_button() {

        registerPage.clickContinueBtn();
    }

    @Then("user verify Warning message {string}")
    public void user_verify_warning_message(
            String expectedWarningMsg) {

        String actualWarning =
                registerPage.getWarningMessage();

        Assert.assertTrue(
                actualWarning.contains(expectedWarningMsg));
    }

    @Then("Password mismatch warning should display {string}")
    public void password_mismatch_warning_should_display(
            String expectedMsg) {

        String actualMsg =
                registerPage.getWarningMessage();

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Then("Account should get created successfully")
    public void account_should_get_created_successfully() {

        Assert.assertTrue(
                registerPage.verifyAccountCreated());
    }
}