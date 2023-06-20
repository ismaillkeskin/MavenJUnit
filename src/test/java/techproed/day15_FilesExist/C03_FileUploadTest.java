package techproed.day15_FilesExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


         /*
        Eğer dosyaSec butonuna basmamız istenirse ve otomasyon ile bu butona click yapmak istediğimizde
        exception alıyorsak, direk upload yapmak istediğimiz dosya yolunu alıp sendKeys() methodu ile dosyayı sayfaya
        upload yapabiliriz
        Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa , o webelemente sendKeys() methodu
        ile dosya gonderemeyebilirsiniz. Boyle bir durumla karsilasirsaniz Robot class'indan obje ile methodlar kullanarak
        bunu asabilirsiniz
         */

        String dosyaYolu = "C:/Users/keski/Desktop/Exercises.txt";

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click(); // click yapmadı

       //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);

       //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
