package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {

    @Test
    public void implicitlyWaitTest(){
        //1. Bir class olusturun : C01_WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //  Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        //4. Remove butonuna basin.
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //6. Add buttonuna basin
        //7. It’s back mesajinin gorundugunu test edin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        SoftAssert softAssert=new SoftAssert();
        WebElement sonucYazisi=driver.findElement(By.id("message"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());

        sonucYazisi= driver.findElement(By.xpath("//button[text()='Add']"));
        sonucYazisi.click();

        Assert.assertTrue(sonucYazisi.isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void explicitlyWaitTest(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        WebDriverWait wait =new WebDriverWait(driver,20);

        //Explicitly waite i istersek locate islemi ile birlikte tek satirda yapabiliriz.

        WebElement yaziLocateyleBirlikte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(yaziLocateyleBirlikte.isDisplayed());

        //veya once locate edip uygun method kullanarak eklemeyi yaptirabiliriz.

/*        WebElement sonucYazisi=driver.findElement(By.id("message"));

        //bu mantiksiz olur wait olmadan o element olmaz o element olmadan wait olmaz

        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());
 */

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement itsBackLocateIle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackLocateIle.isDisplayed());
    }
}
