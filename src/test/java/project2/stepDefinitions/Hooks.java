package project2.stepDefinitions;

import org.openqa.selenium.*;
import com.aventstack.extentreports.*;

import io.cucumber.java.*;

import utils.*;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Hooks {

    static ExtentReports extent = ExtentManager.getInstance();
    static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {

        BaseClass.initializeDriver(); //initialise browser

        ExtentTest test = extent.createTest(scenario.getName());
        extentTest.set(test);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            try {

                // Screenshot for Cucumber report
                byte[] screenshot = ((TakesScreenshot) BaseClass.driver)
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Failed Screenshot");

                // Scenario name clean
                String scenarioName = scenario.getName().replaceAll(" ", "_");

                // Screenshot save
                File src = ((TakesScreenshot) BaseClass.driver)
                        .getScreenshotAs(OutputType.FILE);

                String path = "target/screenshots/" + scenarioName + ".png";

                File dest = new File(path);

                FileUtils.copyFile(src, dest);

                // Extent report screenshot
                extentTest.get().fail("Test Failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(path).build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        BaseClass.driver.quit();
        extent.flush();
    }

    public static WebDriver getDriver() {
        return BaseClass.driver;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}