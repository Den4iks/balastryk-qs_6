package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    public void entedSearchCriteria(String value) throws InterruptedException {
        driver.findElement(searchBoxLocator).sendKeys(value);
        driver.findElement(doSearchLocator).click();
        Thread.sleep(5000);

    }
}
