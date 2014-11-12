package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.WebDriveWrapper;
import utils.Log4Test;

/**
 * Created by pc on 03.11.2014.
 */

public class WelcomePage {
    private static final By isRegistredLocator= By.className("registr-successful");

    private static WebDriveWrapper driver;

    public WelcomePage(){}

    public WelcomePage(WebDriveWrapper driver){
        this.driver = driver;
    }

    public boolean isOnPage(){
    if(driver.findElement(isRegistredLocator).isDisplayed()){
        Log4Test.info("User have been registered");
    }
        return driver.findElement(isRegistredLocator).isDisplayed();
    }
}
