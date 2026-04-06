package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "project2.stepDefinitions",

        plugin = {
                "pretty",   // ✅ Console में step-by-step logs दिखाएगा
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml" // ✅ Jenkins integration के लिए
        },

        monochrome = true,     // ✅ clean readable console output
        publish = true,        // ✅ online cucumber report link (optional)
        dryRun = false,        // ✅ false = execution, true = सिर्फ step check

        tags = ""              // ✅ future में tag execution के लिए
)

public class TestRunner extends AbstractTestNGCucumberTests {

    // 👉 Parallel execution (optional future use)
    // @Override
    // @DataProvider(parallel = true)
    // public Object[][] scenarios() {
    //     return super.scenarios();
    // }
}























