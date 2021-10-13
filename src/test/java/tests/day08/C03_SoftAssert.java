package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert {
    //Yeni bir Class Olusturun : D10_SoftAssertTest
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password.” yazin
    // 5. Sign in tusuna basin
    // 6. Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
    // "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
    // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
    // (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
    // "Thailand (baht)"

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

        driver.navigate().to("http://zero.webappsecurity.com/");

        driver.findElement(By.cssSelector(".icon-signin")).click();

        driver.findElement(By.id("user_login")).sendKeys("username");

        driver.findElement(By.id("user_password")).sendKeys("password"+ Keys.ENTER);


        driver.navigate().back();

        driver.findElement(By.id("onlineBankingMenu")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        WebElement currency =driver.findElement(By.id("pc_currency"));

        Select options= new Select(currency);

        options.selectByValue("EUR");

        String actualBolge=  options.getFirstSelectedOption().getText();
        String expectedBolge= "Eurozone (euro)";

        softAssert.assertEquals(actualBolge,expectedBolge,"Bölge euro degil");

        List<WebElement> tumOpsiyonlar=options.getOptions();

        List<String> tumOpsiyonlarString= new ArrayList<>();

        for (WebElement each:tumOpsiyonlar){
            tumOpsiyonlarString.add(each.getText());
        }

        //options.stream().forEach(t-> strOptions.add(t.getText()));
        //lambda ile yapim

        List<String> expectedOptionList= Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)");

        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionList,"liste farkli");



        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }

}
