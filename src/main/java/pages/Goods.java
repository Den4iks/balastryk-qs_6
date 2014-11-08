package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pc on 05.11.2014.
 */
public class Goods {
    public static WebDriver driver;

    private final By closeBtn = By.className("tech-char");

    public Goods(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isGoods(){

        return driver.findElement(closeBtn).isDisplayed();
    }
}
