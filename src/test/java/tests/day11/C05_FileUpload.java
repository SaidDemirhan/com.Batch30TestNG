package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\picture.jpg";

        WebElement dosyaYukle= driver.findElement(By.id("file-upload"));

        dosyaYukle.sendKeys(dosyaYolu);

        driver.findElement(By.id("file-submit")).click();

        Thread.sleep(3000);

        WebElement sonucYazisiElementi= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(sonucYazisiElementi.isDisplayed());


    }
}
