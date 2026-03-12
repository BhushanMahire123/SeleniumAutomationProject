package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = "project2.stepDefinitions",
        tags = "@Hybrid",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {

}

























