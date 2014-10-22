package simple;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pc on 22.10.2014.
 */
public class FirstTest {


   @Test
    public void firstTest () {
        System.out.println("new print");
        Assert.assertTrue(true);
    }
}
