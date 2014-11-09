package pages;

import actors.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pc on 29.10.2014.
 */
public class RegisterPage {
    public static WebDriver driver;
    private static final By nickNameSelector = By.name("nick");
    private static final By passwordSelector = By.name("password");
    private static final By repeatPasswordSelector = By.name("password2");
    private static final By emailSelector = By.name("email");
    private static final By submitSelector = By.className("blue-button");
    private static final By availableEmailSelector = By.className("errors");

    public RegisterPage(){}

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean registerNewUser(User user){
        fillUserData(user);
     /*   if(!isPasswordsSame()){
            System.out.println("Passwords aren't the same");
            return false;
        }
        if(!isPasswordLengthCorrect()){
            System.out.println("Password length should be between 4 and 16 symbols");
            return false;
        }
        if(!isEmailValid()){
            System.out.println("Email is not valid");
            return false;
        }
        if(!isNickLengthCorrect()){
            System.out.println("Password length should be between 1 and 30 symbols");
            return false;
        }*/
        driver.findElement(submitSelector).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void fillUserData(User user){
    driver.findElement(emailSelector).sendKeys(user.email);
    driver.findElement(nickNameSelector).sendKeys(user.nickName);
    driver.findElement(passwordSelector).sendKeys(user.password);
    driver.findElement(repeatPasswordSelector).sendKeys(user.repeatPassword);
    }

    public boolean isPasswordsSame(User user){
        if (user.password==user.repeatPassword){
            return true;
        }else{
            return false;
        }
    }

    public boolean isPasswordLengthCorrect(User user){
        if(user.password.length()>4&&user.password.length()<16){
            return true;
        }else{
            return false;
        }

    }

    public boolean isNickLengthCorrect(User user){
        if(user.nickName.length()>1&&user.nickName.length()<30){
            return true;
        }else{
            return false;
        }

    }

    public boolean isEmailValid(User user){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(user.email);
        return m.matches();
    }

    public boolean isOnPage(){
        return driver.findElement(availableEmailSelector).isDisplayed();
    }

    public void showHiddenPassword(){

    }

    public void openTandC(){

    }
}
