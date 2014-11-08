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
                new Object[]{user,"Поздравляем! Вы успешно зарегистрировались на Hotline",true },
                new Object[]{user,"Извините, но такой e-mail уже занят" ,false}};
    }



    @Test(dataProvider = "users")
    public void registerNewUser(User user,
                                String checkText,
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
        Assert.assertEquals((positive)?welcomePage.isOnPage():registerPage.isOnPage(),checkText);
    }


}
