package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 05.11.2014.
 */
public class Goods {
    public static WebDriver driver;

    private final By availableSelector = By.className("tech-char");
    private final By compareSelector = By.className("but-box");

    private final By absentSelector = By.xpath("//div[contains(@class, 'search-result-page') and contains(@class, 'no')]");

    public Goods(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isGoods(){

        return driver.findElement(availableSelector).isDisplayed();
    }

    public boolean noGoods(){

        return driver.findElement(absentSelector).isDisplayed();
    }

    public void comparePrices(){
       driver.findElement(compareSelector).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Assert.assertFalse(false,"Error in threa.sleep ,comparePrices()");
        }
    }

}
