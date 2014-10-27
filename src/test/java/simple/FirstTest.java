package simple;

import application.Summ;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pc on 22.10.2014.
 */
public class FirstTest {


   @Test
    public void firstTest () {
       int answer;
       Summ testClass= new Summ();
       answer=testClass.summTwoInteger(2,2);
       Assert.assertEquals(answer,4);
    }


}
