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

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {
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
    public void test(){
        driver.get("https://www.amazon.com");

        //url amazon icerdigini test edin

        //String baslik= driver.getCurrentUrl();
        //System.out.println(baslik.contains("amazon") ? "url amazon iceriyor" : "url amazon icermiyor");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //ttitle da amazon var mi
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //java kelimesini arat ve ilk urun java iceriyor mu bak

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(ilkUrun.getText().contains("Java"));


    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
