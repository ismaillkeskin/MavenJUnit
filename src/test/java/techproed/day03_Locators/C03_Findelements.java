package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Findelements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdıralım
        /*
        findelement ile bir webelemente ulaşabilirken, birden fazla webelement için findelements() methodunu kullanırız
        Bu webelementlerin sayısına ulaşmak için yada bu elementlerin yazısını konsola yazdırabilmek için
        List<Webelement> linlerListesi = driver.findElements(By.locator("locator değeri")) olarak kullanırız
        Oluşturmuş olduğumuz List'i loop ile konsola yazdırabiliriz
         */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayısı = "+linklerListesi.size());
        /*
        for (WebElement w:linklerListesi) {
            if (!w.getText().isEmpty()){
                System.out.println(w.getText());
            }

        }
         */
        //Lambda ile yazdıralım
        linklerListesi.
                forEach(link -> {if (!link.getText().isEmpty())
                {System.out.println(link.getText());}});

        //Shop deals in Electronics webElementinin yazısını yazdıralım
        System.out.println("**********************************************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazisi = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(webElementYazisi.getText());
        //webelementin üzerindeki yazıyı almak istiyorsak getText() methodunu kullanırız


        //Sayfayı kapatalım
        driver.close();



    }
     //Amazon sayfasına gidiniz
     //iphone aratınız
     //çıkan sonuç yazısını konsola yazdırınız
     //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
}
