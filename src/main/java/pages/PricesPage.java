package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 09.11.2014.
 */
public class PricesPage {
    private static WebDriver driver;
    private final By priceSelector = By.className("price");

    public PricesPage(){}

    public PricesPage(WebDriver driver){
        this.driver = driver;
    }

    public List allPrices(){
        List list = new ArrayList();
        list=driver.findElements(priceSelector);
        return list;
    }
}
