package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            synchronized (ExtentManager.class) {

                if (extent == null) {

                    String path = System.getProperty("user.dir")
                            + "/test-output/ExtentReport.html";

                    ExtentSparkReporter reporter =
                            new ExtentSparkReporter(path);

                    extent = new ExtentReports();
                    extent.attachReporter(reporter);
                }
            }
        }
        return extent;
    }
}
