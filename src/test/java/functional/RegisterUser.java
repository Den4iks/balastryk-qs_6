package functional;

import actors.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegisterPage;
import pages.WelcomePage;
import utils.Log4Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pc on 29.10.2014.
 */
public class RegisterUser extends AbstractTest {

    private User user = new User("test","1234","1234");


    @DataProvider(name = "users")
    public Object[][] createData() {

        return new Object[][] {
                new Object[]{user,true },
                new Object[]{user,false}};
    }



    @Test(dataProvider = "users")
    public void registerNewUser(User user,
                                boolean positive){
        driver.get(PAGE);
        HomePage homePage = new HomePage(driver);
        if (positive) {
            homePage.closeAdvert();
            homePage.skipCityPopUp();
        }
        homePage.reg();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(user);
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertEquals((positive)?welcomePage.isOnPage():registerPage.isOnPage(),true,"If test is positive should " +
                "be successful notification and if negative should be error ");
    }


}
