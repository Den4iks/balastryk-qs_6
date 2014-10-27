package simple;

import application.EmailValidator;
import com.beust.jcommander.Parameter;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by pc on 22.10.2014.
 */
public class FirstTest {
   @Test
   @Parameters({"email"})
    public void firstTest (String email) {
       boolean answer;
       EmailValidator ev= new EmailValidator();
       Assert.assertTrue(ev.emailParser(email));
    }


}
