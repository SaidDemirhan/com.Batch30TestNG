package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test10_Js_Facebook extends TestBase {

    @Test
    public void setUp() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//*[.='Alle Cookies gestatten']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementById('email').value='deneme@abc.com';");
        js.executeScript("document.getElementById('pass').value='123456';");
        //value='123456' locate edilen yere deger gonderir. (sendKeys)

        Thread.sleep(3000);
    }
}