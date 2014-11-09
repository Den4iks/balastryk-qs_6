package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by pc on 03.11.2014.
 */
public class HomePage {

    private static WebDriver driver;
    private static final By closeSelector  = By.className("close");
    private static final By okSelector = By.className("blue-button");
    private static final By registerLink = By.className("reg");
    private static final By searchBoxLocator = By.id("searchbox");
    private static final By doSearchLocator = By.id("doSearch");
    private static final By emailSelector = By.name("email");


    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void closeAdvert(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(closeSelector)));
        driver.findElement(closeSelector).click();
    }
    public void skipCityPopUp(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(okSelector)));
        driver.findElement(okSelector).click();
    }
    public void reg(){
        driver.findElement(registerLink).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Assert.fail("");
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
            Assert.assertFalse(true,"InterruptedException in HomePage.entedSearchCriteria()");
        }

    }
}
