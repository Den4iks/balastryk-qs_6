package pages;

import actors.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 29.10.2014.
 */
public class RegisterPage {
    public static WebDriver driver;
    public String NICKNAME = "nick";
    public String PASSWORD = "password";
    public String REPEATPASSWORD = "password2";
    public String EMAIL = "email";
    public String SUBMIT = "blue-button";
    public String AVAILABLEEMAIL = "/html/body/div[6]/div[2]/div[1]/div/div[1]/div/form/div[1]/span";


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
        driver.findElement(By.className(SUBMIT)).click();
        return true;
    }

    private void fillUserData(User user){
    driver.findElement(By.name(EMAIL)).sendKeys(user.email);
    driver.findElement(By.name(NICKNAME)).sendKeys(user.nickName);
    driver.findElement(By.name(PASSWORD)).sendKeys(user.password);
    driver.findElement(By.name(REPEATPASSWORD)).sendKeys(user.repeatPassword);
    }

    public boolean isPasswordsSame(){
        if (PASSWORD==REPEATPASSWORD){
            return true;
        }else{
            return false;
        }
    }

    public boolean isPasswordLengthCorrect(){
        if(PASSWORD.length()>4&&PASSWORD.length()<16){
            return true;
        }else{
            return false;
        }

    }

    public boolean isNickLengthCorrect(){
        if(NICKNAME.length()>1&&NICKNAME.length()<30){
            return true;
        }else{
            return false;
        }

    }

    public boolean isEmailValid(){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(EMAIL);
        return m.matches();
    }

    public String isOnPage(){
        return driver.findElement(By.xpath(AVAILABLEEMAIL)).getText();
    }

    public void showHiddenPassword(){

    }

    public void openTandC(){

    }
}
