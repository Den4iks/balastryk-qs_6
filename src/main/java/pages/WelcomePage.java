package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 03.11.2014.
 */

public class WelcomePage {
    private static final By isRegistredLocator= By.className("title-sub");

    private static WebDriver driver;

    public WelcomePage(){}

    public WelcomePage(WebDriver driver){
        this.driver = driver;
    }

    public String isOnPage(){
    return driver.findElement(isRegistredLocator).getText();
    }
}
