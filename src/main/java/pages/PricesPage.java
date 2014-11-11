package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.WebDriveWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 09.11.2014.
 */
public class PricesPage {
    private static WebDriveWrapper driver;
    private final By priceSelector = By.className("price");

    public PricesPage(){}

    public PricesPage(WebDriveWrapper driver){
        this.driver = driver;
    }

    public List allPrices(){
        List <WebElement> list = new ArrayList<WebElement>();
        list=driver.findElements(priceSelector);
        ArrayList listTexts = new ArrayList();
        for (WebElement l  : list) {
            listTexts.add(l.getText());
        }


        return listTexts;
    }

    public List returnAllUniqPrices( List list){
        for (int i = 0; i <list.size()-1 ; i++) {
            for (int j = 1; j <list.size()-1 ; j++) {
                if (list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }

        }
        return list;
    }
}
