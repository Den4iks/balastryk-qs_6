package selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;

/**
 * Created by pc on 10.11.2014.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String HTMLUNIT = "htmlunit";

    public static WebDriveWrapper initDriver(String driverName){
        WebDriveWrapper driveWrapper = null;
        if (driverName.equalsIgnoreCase(FIREFOX)){
          driveWrapper = new WebDriveWrapper(new FirefoxDriver());
        }else if (driverName.equalsIgnoreCase(HTMLUNIT)){
          driveWrapper = new WebDriveWrapper(new HtmlUnitDriver());
        }else{
            Assert.fail("Invalid driver configuration");
        }
        return driveWrapper;
    }
}
