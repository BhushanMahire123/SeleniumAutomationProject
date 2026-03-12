package project2.stepDefinitions;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Page_Object.Login_Page;

import Page_Object.Reset_Password;

import utils.ConfigReader;

public class BaseClass {
	public static WebDriver driver;
    public static Login_Page lp;
    public static Reset_Password RP;
    public static Reset_Password LPE;
    
    // Driver Initialize
    public static void initializeDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(ConfigReader.getProperty("url"));
        lp = new Login_Page(driver);
    }

	// Screenshot Method
	public static String captureScreenshot(String testName) {

		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		String screenshotPath = System.getProperty("user.dir") 
				+ "/Screenshots/" + testName + "_" + timestamp + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotPath;
	}
}
