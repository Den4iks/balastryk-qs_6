package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.WebDriveWrapper;
import utils.Log4Test;

/**
 * Created by pc on 03.11.2014.
 */
public class HomePage {

    private static WebDriveWrapper driver;
    private static final By closeSelector  = By.className("close");
    private static final By okSelector = By.className("blue-button");
    private static final By registerLink = By.className("reg");
    private static final By searchBoxLocator = By.id("searchbox");
    private static final By doSearchLocator = By.id("doSearch");


    public HomePage(WebDriveWrapper driver) {
        this.driver = driver;

    }

    public void closeAdvert(){
        driver.findElement(closeSelector).click();
    }
    public void skipCityPopUp(){
        driver.findElement(okSelector).click();
    }
    public void reg(){
        driver.findElement(registerLink).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Log4Test.error("InterruptedException in HomePage.reg()");
            Assert.fail("InterruptedException in HomePage.reg()");
        }
        /*WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailSelector)));*/
    }

    public void entedSearchCriteria(String value)  {
        driver.findElement(searchBoxLocator).sendKeys(value);
        driver.findElement(doSearchLocator).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log4Test.error("InterruptedException in HomePage.entedSearchCriteria()");
            Assert.fail("InterruptedException in HomePage.entedSearchCriteria()");
        }

    }
}
