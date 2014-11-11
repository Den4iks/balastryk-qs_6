package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriveWrapper;
import selenium.WebDriverFactory;
import utils.PropertyLoader;

/**
 * Created by pc on 05.11.2014.
 */
public class AbstractTest {
    public static WebDriveWrapper driver;
    public String PAGE = "http://hotline.ua/";

    @BeforeSuite
    public void initEnv(){
        driver= WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
    }

    @AfterSuite
    public void closeDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
