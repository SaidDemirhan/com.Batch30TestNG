package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
    @Test
    public void test() throws InterruptedException {
// "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//*[.='Alle Cookies gestatten']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement nameKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
//"create new account"  butonuna basin

//"firstName" giris kutusuna bir isim yazin

        Faker faker=new Faker();

        String email=faker.internet().emailAddress();

        Actions actions=new Actions(driver);
        actions.click(nameKutusu)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,28)))
                .sendKeys(Keys.TAB)
                .sendKeys("Mai")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1956,2000)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click()
                .perform();

        Thread.sleep(15000);



//"surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//Sayfayi kapatin
    }
}
