package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.WebDriveWrapper;
import utils.Log4Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 05.11.2014.
 */
public class Goods {
    public static WebDriveWrapper driver;

    private final By availableSelector = By.className("tech-char");
    private final By compareSelector = By.className("but-box");
    private final By dropDownOpen = By.className("ddopener");
    private final By getAllPrices = By.className("orng");
    private final By filterLG = By.xpath("//a[@href='/bt/holodilniki/627/']");
    private final By getAllNames = By.xpath("//div[@class='title-box']/h3/a");
    private final By sortingByPrice = By.xpath("//a[@href='http://hotline.ua/bt/holodilniki/627/?sort=0']");
    private final By absentSelector = By.xpath("//div[contains(@class, 'search-result-page') and contains(@class, 'no')]");
    private static Log4Test mLog = new Log4Test(Goods.class.getName());


    public Goods(WebDriveWrapper driver) {
        this.driver=driver;
    }

    public boolean isGoods(){
    if(driver.findElement(availableSelector).isDisplayed()){
        mLog.info("Current product have been found");
    }
        return driver.findElement(availableSelector).isDisplayed();
    }

    public boolean noGoods(){
     if(driver.findElement(absentSelector).isDisplayed()){
         mLog.info("Current product aren't found");
      }
        return driver.findElement(absentSelector).isDisplayed();
    }

    public void comparePrices(){
        mLog.info("Prices is being compired");
       driver.findElement(compareSelector).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Assert.assertFalse(false,"Error in thread.sleep ,comparePrices()");
        }
    }

    public void selectFilterByBrandLg(){
        mLog.info("Filter by Brand is being selected");
        driver.findElement(filterLG).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage() + "in selectFilterByBrandLg method");
        }
    }

    public void selectSortingByPrice(){
        mLog.info("Sorting by price is being selected");
        driver.findElement(dropDownOpen).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage() + "in selectSortingByPrice method");
        }
        driver.findElement(sortingByPrice).click();
    }
    public List getAllprices(){
        return driver.findElements(getAllPrices);
    }
    public List getAllProductNames(){
        return driver.findElements(getAllNames);
    }
}
