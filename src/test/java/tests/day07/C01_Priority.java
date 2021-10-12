package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {
    //3 test methodu olusturalim
    //amazon
    //techpro
    //faceboook ana sayfa ya gitsin
    //sayfa title lari yazdirsin

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //priority yazilmayan methodlar 0 kabul edilir. - de olsa en kücük hangisiyse ondan baslar.
    @Test(priority = 2)
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 1)
    public void techproTest(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 3)
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    // beforemethod ve aftermethod un toplam test saysisinca calsitigina dikkat et

}
