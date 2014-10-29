package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pc on 27.10.2014.
 */
public class StringFinder {


    FileWriter fstream1;
    BufferedWriter out1;
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
    public void stringMatcher(String string1, String string2){
        Assert.assertTrue(string1.indexOf(string2) != -1);
        try {
            fstream1.write(string1 + " " +string2);
            fstream1.close();
        } catch (IOException e) {
            System.err.println("Error in file writing: " + e.getMessage());
        }

    }

}