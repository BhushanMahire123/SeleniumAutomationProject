package project2.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Page_Object.ResetPasswordotherclient;
import Page_Object.Reset_Password;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ResetPasswordtestclient {
	
	ResetPasswordotherclient RPC;
    ExtentTest test;

    public ResetPasswordtestclient() {
        WebDriver driver = Hooks.getDriver();
        RPC = new ResetPasswordotherclient(driver);
    }

    @Before
    public void initExtent() {
        test = Hooks.getTest();
    }


    @And("user click on client the dropdown")
    public void select_from_dropdown() {
    	RPC.clickOnDropdown();
    }
    
    @And("user selects {string} from the dropdown")
    public void user_selects_client(String clientName) {
    	
    

        RPC.selectClient(clientName);
    }
    }

   
    	
   

    



