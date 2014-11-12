package functional;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Goods;
import pages.HomePage;

import java.util.List;

/**
 * Created by pc on 11.11.2014.
 */
public class RefrigiratorSortTest extends AbstractTest {

   @Test
    public void sortByPriceAndBrand(){
       driver.get("http://hotline.ua/bt/holodilniki/");
       HomePage homePage = new HomePage(driver);
       Goods goods = new Goods(driver);
       goods.selectFilterByBrandLg();
       goods.selectSortingByPrice();
       Assert.assertTrue(isFirstPriceLowerThanSecond(goods.getAllprices()) && isProductsTheSame(goods.getAllProductNames(),"LG"),
               "Test will pass if first price is lower than second and First two Products have same Brands");
    }

    public boolean isFirstPriceLowerThanSecond(List <WebElement> list){
        if(Integer.parseInt(list.get(0).getText().substring(0,6).replaceAll(" ",""))<Integer.parseInt(list.get(1).getText().substring(0,6).replaceAll(" ",""))) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isProductsTheSame(List <WebElement> list,String brandName){
        if(list.get(0).getText().contains(brandName)&&list.get(1).getText().contains(brandName)){
            return true;
        }else{
            return false;
        }
    }
}
