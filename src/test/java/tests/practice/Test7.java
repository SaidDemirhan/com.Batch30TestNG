package tests.practice;

// 1) "http://automationpractice.com/" ADRESiNE GiDiN
// 2) 2. URUNUN UZERiNE GELiP Add to chart YAPIN
// 3) 4. URUNUN UZERiNE GELiP Add to chart YAPIN
// 4) 5. URUNUN UZERiNE GELiP Add to chart YAPIN
// 5) CHART a gelin 3 ürün olduğunu doğrulayın
// 6) CHART'A GELiP Chek out TIKLAYIN
// 7) toplam alışveriş miktarının 108.97 olduğunu doğrula

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test7 extends TestBase {

    @Test
    public void test(){
        driver.get("http://automationpractice.com/");

        Actions actions=new Actions(driver);
        WebElement ilkurun= driver.findElement(By.xpath("(/)/img[@title='Blouse'])(1)"));
        actions.moveToElement(ilkurun).perform();
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();



    }

}