package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.security.Key;

public class C01_Actions extends TestBase {

    // Klavye Actions

    // sendKeys ==> Bir yazı gönderilirken yada bir tusa bir kez basacaksak kullanılır.
    // sendKeys(Keys.TAB)
    // sendKeys(Keys.PAGE_DOWN)

    // keyDown ==> Bir tusa basılı tutacaksak kullanılır.
    // keyDown(Keys.SHIFT)

    // keyUp ==> Tusu kaldıracaksak kullanılır.
    // keyUp(Keys.SHIFT)


    // Mause Actions

    // click() ==> sol click yapmak icin kullanılır.
    // contextClick() ==> sag click yapmak icin kullanılır.
    // doubleClick() ==> cift tıklamak icin kullanılır.
    // clickAndHold() ==> tıkla basılı tut islemi icin kullanılır.
    // dragAndDrop() ==> sürükle bırak islemi icin kullanılır.
    // moveToElement() ==> yaklasma islemi icin kullanılır.

    @Test
    public void test01() {

        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        bekle(2);

       //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        bekle(2);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release() --> methodu mouse'u bırakır
    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
               driver.get("https://techproeducation.com");
                driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
               bekle(2);
        //        //sayfanın en altına scroll yapalım
               Actions actions = new Actions(driver);
               actions.scrollByAmount(0,1500).perform();
    }
}
