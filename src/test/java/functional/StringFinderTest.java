package functional;

import application.StringFinder;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pc on 27.10.2014.
 */
public class StringFinderTest {


    FileWriter fstream1;
    BufferedWriter out1;
    StringFinder sf;
    @DataProvider
    public Object [][] strings(){
        return new Object[][]{
            new Object[]{"Java is a good language","Java"}
        };
    }

    @BeforeClass
    public void clearFile(){
        try {
            fstream1 = new FileWriter("Strings");
            out1 = new BufferedWriter(fstream1);
            out1.write("");
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }

    @Test(dataProvider="strings")
    public void testStringFinder(String string1, String string2){
        sf = new StringFinder();
        Assert.assertTrue(sf.stringMatcher(string1, string2));
        try {
            fstream1.write(string1 + " " +string2);
            fstream1.close();
        } catch (IOException e) {
            System.err.println("Error in file writing: " + e.getMessage());
        }

    }


}