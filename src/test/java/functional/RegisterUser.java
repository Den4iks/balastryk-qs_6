package functional;

import actors.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pc on 29.10.2014.
 */
public class RegisterUser {

    @Test
    public void registerNewUser(User user){
     RegisterPage registerPage = new RegisterPage();
     Assert.assertTrue(registerPage.registerNewUser(user));
    }
}
