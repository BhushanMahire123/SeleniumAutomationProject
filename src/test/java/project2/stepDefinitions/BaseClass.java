package project2.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseClass {
	
    public static WebDriver driver;
   

	public static Logger log = LogManager.getLogger(BaseClass.class);
    
	public static void initializeDriver() {

	    log.info("Initializing Chrome Browser...");

	    WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();

	    driver.manage().window().maximize();

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	  
	
    // ✅ Screenshot Method (No Change)
    public static String captureScreenshot(String testName) {

    	log.info("Capturing screenshot for test: " + testName);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String screenshotPath = System.getProperty("user.dir")
                + "/Screenshots/" + testName + "_" + timestamp + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            FileUtils.copyFile(source, destination);
            log.info("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            log.error("Failed to capture screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }}