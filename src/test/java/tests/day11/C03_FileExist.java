package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));

        //C:\Users\ASD\OneDrive\Masaüstü\picture.jpg

        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\picture.jpg";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //icinde oldugumuz dosyanin yolunu verir
        System.out.println(System.getProperty("user.dir"));

    }

}
