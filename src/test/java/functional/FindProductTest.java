package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Goods;
import pages.HomePage;
import utils.Log4Test;

/**
 * Created by pc on 05.11.2014.
 */
public class FindProductTest extends AbstractTest {
    @DataProvider(name = "products")
    public Object[][] createData() {

        return new Object[][] {
                new Object[]{"Iphone",true },
                new Object[]{"Faiiill",false}};
    }

    @Test(dataProvider = "products")
    public void findProductTest(String productName,boolean testType)  {
        HomePage homePage = new HomePage(driver);
        homePage.entedSearchCriteria(productName);
        Goods goods = new Goods(driver);
        Assert.assertEquals((testType)?goods.isGoods():goods.noGoods(),true,"If test positive should be at once 1 result" +
                "if test is negative shouldn't be results");
        }

    }
