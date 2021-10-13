package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IFrame {

    //● Bir class olusturun: C02_IframeTest
    //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //  ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
    // ve  konsolda  yazdirin.
    // ○ Text Box’a “Merhaba Dunya!” yazin.
    // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
    // gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iframeTest() throws InterruptedException {
        WebElement baslik= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(baslik.isEnabled(),"basliga erisilemiyor.");
        System.out.println(baslik.getText());

        //driver.switchTo().frame("mce_0_ifr");//id olur
        //veya
        //driver.switchTo().frame(0);// index olarak da bulabilir ve hizlidir.
        //veya
        WebElement iFrame= driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iFrame);


        WebElement yorumKutusu=driver.findElement(By.cssSelector("#tinymce"));
        yorumKutusu.clear();
        yorumKutusu.sendKeys("Merhaba Dunya");

        //Bir ifame e gecis yaptiktan sonra ana sayfa ile islem yapmak gerekirse Iframe den geri cikmaliyiz.

        driver.switchTo().parentFrame(); //bir ust sayfaya gecirir
        // Bazen ic ice frame lere girmis oluruz onun icin.
        //driver.switchTo().defaultContent(); // en ust sayfaya getirir.


        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        // gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

        WebElement elementalLinki=driver.findElement(By.linkText("Elemental Selenium"));

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(elementalLinki.isDisplayed(), "yazi görünmüyor");
        softAssert.assertAll();

        System.out.println(elementalLinki.getText());

        elementalLinki.click();

        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
