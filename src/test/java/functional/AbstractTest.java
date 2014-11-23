package functional;

import actors.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriveWrapper;
import selenium.WebDriverFactory;
import utils.Log4Test;
import utils.PropertyLoader;
import utils.ScreenShotMaker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc on 05.11.2014.
 */
public class AbstractTest {
    public static Log4Test mLog = new Log4Test(AbstractTest.class.getName());
    public static WebDriveWrapper driver;
    public String PAGE = "http://hotline.ua/";
    public User user = new User("test","1234","1234");


    @BeforeSuite
    public void initEnv(){
        driver= WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.get(PAGE);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
            Date date = new Date();
            String screenName = dateFormat.format(date).toString() + "." + getClass().getName();
            ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
            screenShotMaker.takeScreenShot(screenName);
            mLog.info("Test failed. Screenshot with name: '" + screenName + "' was made.");
        }
        mLog.info("Returning to the main page.");
        driver.get(PAGE);
    }

    @AfterSuite
    public void closeDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
