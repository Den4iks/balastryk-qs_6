package functional;

import actors.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.WelcomePage;
import utils.Log4Test;

import java.io.IOException;

/**
 * Created by pc on 23.11.2014.
 */
public class ScreenShootTestFail extends AbstractTest{

    private static Log4Test mLog = new Log4Test(ScreenShootTestFail.class.getName());

    @DataProvider(name = "users")
    public Object[][] createData() {
        return new Object[][] {
                new Object[]{user }};
    }

    @Test(dataProvider = "users")
    public void registerNewUser(User user){
        HomePage homePage = new HomePage(driver);
            homePage.closeAdvert();
            homePage.skipCityPopUp();
        homePage.reg();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(user);
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertEquals(welcomePage.isOnPage(), false, "If test is positive should " +
                "be successful notification and if negative should be error ");
    }
}
