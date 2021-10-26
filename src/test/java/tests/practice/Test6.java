package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test6 extends TestBase {



    // "http://automationpractice.com/" ADRESiNE GiDiP UYE OL.
    @Test
    public void test() throws InterruptedException {
       driver.get("http://automationpractice.com/");
       driver.findElement(By.cssSelector(".login")).click();
       driver.findElement(By.cssSelector("#email_create")).sendKeys("karaoke125@gmail.com");
       driver.findElement(By.cssSelector(".icon-user")).click();
       driver.findElement(By.cssSelector("#id_gender1")).click();

        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.ENTER)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.ENTER)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.ENTER)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,28)))
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(String.valueOf(faker.number().numberBetween(1950,2000)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddressNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().country())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.ENTER)
                .perform();



       Thread.sleep(5000);
   }



}
