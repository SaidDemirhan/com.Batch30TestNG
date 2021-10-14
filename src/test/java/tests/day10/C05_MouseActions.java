package tests.day10;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions extends TestBase {

    // Yeni bir class olusturalim: C05_MouseActions3
    //1- https://www.amazon.com/ adresine gidelim
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
    //3- “Create a list” butonuna basalim
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    @Test
    public void test(){
        driver.get("https://amazon.com");


    }
}
