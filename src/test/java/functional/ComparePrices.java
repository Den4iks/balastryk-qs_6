package functional;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Goods;
import pages.HomePage;
import pages.PricesPage;
import utils.Log4Test;

/**
 * Created by pc on 09.11.2014.
 */
public class ComparePrices extends AbstractTest{

    @DataProvider(name = "products")
    public Object[][] createData() {

        return new Object[][] {
                new Object[]{"Iphone"}};
    }

    @Test(dataProvider = "products")
    public void isAvailableSevPrices(String product){
        HomePage homePage = new HomePage(driver);
        /*  homePage.closeAdvert();
          homePage.skipCityPopUp();*/
        homePage.entedSearchCriteria(product);
        Goods goods = new Goods(driver);
        goods.comparePrices();
        PricesPage pricesPage = new PricesPage(driver);
        Assert.assertEquals(pricesPage.returnAllUniqPrices(pricesPage.allPrices()).size()>=2,true,"More than 2 prices on the page");
    }
}
