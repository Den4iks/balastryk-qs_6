package actors;

/**
 * Created by pc on 29.10.2014.
 */
public class User {
    public String nickName;
    public String password;
    public String repeatPassword;
    public String email;

    public User(String nickName, String password, String repeatPassword, String email) {
        this.nickName = nickName;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }
}
