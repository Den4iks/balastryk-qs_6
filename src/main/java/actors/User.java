package actors;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pc on 29.10.2014.
 */
public class User {
    Date today = new Date();
    public String email;
    public String nickName;
    public String password;
    public String repeatPassword;


    public User() {

    }

    public User(String email,String nickName, String password, String repeatPassword) {
        this.nickName = nickName;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }

    /*public String generateEmail(){
        return today.getTime()+"@lolwhat.com.ua";
    }

    public String generateNickName(){

        return "test"+today.getTime();
    }*/
}
