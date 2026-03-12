package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import project2.stepDefinitions.BaseClass;

public class ScreenshotUtil {

    public static String captureScreenshot() throws IOException {

        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + "/target/screenshots/screenshot_" + System.currentTimeMillis() + ".png";

        File dest = new File(path);

        FileUtils.copyFile(src, dest);

        return path;
    }
}