package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void nutella() throws InterruptedException {
        driver.get("https://amazon.com/");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        Thread.sleep(3000);

        //bulabilmesi icin elle asagi inmemiz lazimmis.
        driver.findElement(By.xpath("//img[@data-image-index='9']")).click();


    }
}
