package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {
    //amazon a gi
    //url amazon icerdigini test edin
    //ttitle da amazon var mi
    //java kelimesini arat ve ilk urun java iceriyor mu bak

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.amazon.com");

        //url amazon icerdigini test edin

        //Assert.assertTrue(driver.getCurrentUrl().contains("amazon")); yerine

        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"), "url amazon icermiyor");


        //ttitle da amazon var mi


        //java kelimesini arat ve ilk urun java iceriyor mu bak

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(ilkUrun.getText().contains("Java"));

        softAssert.assertAll();
        //assertAll bir kez en sona yazilmak zorundadir. nesne olusturmak gibi.

    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
