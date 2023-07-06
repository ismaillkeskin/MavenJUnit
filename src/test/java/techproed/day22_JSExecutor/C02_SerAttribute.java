package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.nio.file.WatchEvent;

public class C02_SerAttribute extends TestBase {

    @Test
    public void test01() {

        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz

        /*
           <input> tag'ına sahip webelementlere değer gönderirken sendKeys() methodu kullanırız
           sendKeys() methodu ile değer gönderemediğimiz durumlarda js executor ile rahatlıkla
           değer gönderebiliriz.
           <input> taglarında value attributu değeri, arama kutusu içindeki veriyi temsil eder
           */

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",aramaKutusu); //--> value attribute değer olarak QA yazdırdık

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz


        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        jsSendKeys("Java",aramaKutusu);

    }

    @Test
    public void test03() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        /*
          JS executor ile bir attribute değer atayabiliriz.Aşağıdaki örnekteki gibi
         Sayfadaki arama kutusunu locate edip arama kutusunun value attributune 'QA' değerini atarız
        */

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);


    }

    @Test
    public void test04() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','ismail')",aramaKutusu);
       //--> elementor-search-form-9f26725 normal de id attribute değeri
      driver.findElement(By.id("ismail")).sendKeys("Java");

    }

    @Test
    public void test05() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

       //Arama kutusuna QA yaz
     WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search'"));
     jsSetAttribute("value","QA",aramaKutusu);

    }
}
