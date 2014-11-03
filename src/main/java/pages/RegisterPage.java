package pages;

import actors.User;

/**
 * Created by pc on 29.10.2014.
 */
public class RegisterPage {

    public String nickName;
    public String password;
    public String repeatPassword;
    public String email;

    public boolean registerNewUser(User user){
        fillUserData(user);
        if(!isPasswordsSame(this)){
            System.out.println("Passwords aren't the same");
            return false;
        }
        if(!isPasswordLengthCorrect(this)){
            System.out.println("Password length should be between 4 and 16 symbols");
        }
        if(!isEmailValid(this)){
            System.out.println("Email is not valid");
            return false;
        }
        if(!isNickLengthCorrect(this)){
            System.out.println("Password length should be between 1 and 30 symbols");
        }

        return true;
    }

    private void fillUserData(User user){
    this.nickName = user.nickName;
    this.email = user.email;
    this.password = user.password;
    this.repeatPassword = user.repeatPassword;
    }

    public boolean isPasswordsSame(RegisterPage registerPage){
        if (this.password==this.repeatPassword){
            return true;
        }else{
            return false;
        }
    }

    public boolean isPasswordLengthCorrect(RegisterPage registerPage){
        if(this.password.length()>4&&this.password.length()<16){
            return true;
        }else{
            return false;
        }

    }

    public boolean isNickLengthCorrect(RegisterPage registerPage){
        if(this.nickName.length()>1&&this.nickName.length()<30){
            return true;
        }else{
            return false;
        }

    }

    public boolean isEmailValid(RegisterPage registerPage){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(this.email);
        return m.matches();
    }

    public void showHiddenPassword(){

    }

    public void openTandC(){

    }
}
