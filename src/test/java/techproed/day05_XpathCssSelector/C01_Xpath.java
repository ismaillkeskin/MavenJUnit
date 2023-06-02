package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

           // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

          // arama kutusuna "city bike"  yazıp aratın
        // WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        //WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));//-->//*[@*='text']
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

         // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();//--> //*[.='Hybrid Bikes']


        // sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuç Sayısı " +sonucSayisi[0]);

       // ilk ürününe tıklayın
        driver.findElement(By.xpath("(//h2)[1]")).click();

      // Sayfayı kapatınız
        driver.close();




    }
}
