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
public class RegisterUser {
    public String PAGE = "http://hotline.ua/";
    public static WebDriver driver;


    @DataProvider(name = "users")
    public Object[][] createData() {

        return new Object[][] {
                new Object[]{ "Cedri@26dd6.com","testUser1","1234","1234","Поздравляем! Вы успешно зарегистрировались на Hotline",true },
                new Object[]{ "Cedri@26dd6.com","testUser1","1234","1234","Извините, но такой e-mail уже занят" ,false}};
    }




    @BeforeSuite
    public void initEnv(){
    driver=new FirefoxDriver();
    }


    @Test(dataProvider = "users")
    public void registerNewUser(String email,
                                String name,
                                String password,
                                String repeatPassword,
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
        registerPage.registerNewUser(new User(email,name,password,repeatPassword));
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertEquals((positive)?welcomePage.isOnPage():registerPage.isOnPage(),checkText);
    }

    @AfterSuite
    public void closeDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
