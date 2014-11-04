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
    public String CLOSESELECTOR = "close";
    public String OKSELECTOR2 = "blue-button";
    public String REGISTERLINK = "reg";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdvert(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(CLOSESELECTOR))));
        driver.findElement(By.className(CLOSESELECTOR)).click();
    }
    public void skipCityPopUp(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(OKSELECTOR2))));
        driver.findElement(By.className(OKSELECTOR2)).click();
    }
    public void reg(){
        driver.findElement(By.className(REGISTERLINK)).click();
    }
}
