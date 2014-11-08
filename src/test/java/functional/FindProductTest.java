package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Goods;
import pages.HomePage;

/**
 * Created by pc on 05.11.2014.
 */
public class FindProductTest extends AbstractTest {


    @Test
    public void findProductTest() throws InterruptedException {
        driver.get(PAGE);

        HomePage homePage = new HomePage(driver);
        homePage.entedSearchCriteria("Iphone");
        Goods goods = new Goods(driver);
        Assert.assertTrue(goods.isGoods());
    }


}
