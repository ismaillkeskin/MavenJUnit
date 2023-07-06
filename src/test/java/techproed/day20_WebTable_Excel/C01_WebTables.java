package techproed.day20_WebTable_Excel;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class C01_WebTables extends TestBase {
    /*
    WEBTABLE;
    <table> tagı ile başlar
      <thead> başlıklar için bu tag ile devam eder
       <tr> başlıkların satırı
        <th> table head
          <td>  başlıktaki veriler
           <tbody> başlıklar altındaki verileri temsil eder
            <tr> table row(satır)
              <td> table data (tablodaki veri)
     */



    @Test
    public void test01() {

        extentReport("Chrome","WebTable");
        extentTest=extentReports.createTest("ExtentReport","Test Raporu");
        /*
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hhhh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReports"+tarih+" ,html";
        extentHtmlReporter =

         */

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Url Adresine gitik");

       //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1:");
        System.out.println(table1.getText());
        extentTest.info("Table 1'i ekrana yazdırdık");


       //    Task 2 : 3. Satır verilerini yazdırın
       WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("************************");
        System.out.printf(ucuncuSatir.getText());
        extentTest.info("3. Satır Verilerini Yazdırdık");

       //    Task 3 : Son satırın verilerini yazdırın
        //WebElement sonSatir = driver.findElement(By.xpath("(//table)[1]//tbody//tr[last()]"));
                                                     // (//tbody)[1]//tr[last()] --> Bu şekilde de locate alınabilir
                                                     // last() : istenilene göre son satir yada sütün bilgilerini verir
        WebElement sonSatir = driver.findElement(By.xpath("(//table)[1]//tr[4]"));
        System.out.println("**************************");
        System.out.println("1.Tablo son satır bilgileri :" +sonSatir.getText());
        extentTest.info("Son Satır bilgilerini yazdırdık");


        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("*****************************************");
        System.out.println(besinciBaslik.getText());
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. Sütun verilerini yazdırdık");

         // Task 5 : 3. Satırdaki 1. ve 2. Sütün bilgilerini yazdırınız
        System.out.println("*********************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirr.forEach(t-> System.out.print(t.getText()+"\t"));
        extentTest.info("3. Satırdaki 1. ve2. Sütun bilgilerini yazdırdık");

        //  Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //   Parameter 1 = satır numarası
        //   Parameter 2 = sütun numarası
        //   printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();
        System.out.println("***********************");

        printData(2,3);
        extentTest.pass("Method oluştruduk");
        extentReports.flush();


    }

    @Test
    public void test02() {
        //ÖDEV
        //C03_WebTables class'ı için aldığımız rapora gidelim

        //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
        driver.get("C:\\Users\\keski\\Desktop\\Selenium\\B151MavenJUnit\\testOutput\\extentReports\\extentReport_05_54_21_05072023.html");

        //Başlığın Extent Report olduğunu test edelim
        Assert.assertEquals("Extent Report",driver.getTitle());

        //Rapor temasını dark yapalım
        driver.findElement(By.id("theme-selector")).click();

        // Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("(//*[@class='material-icons'])[3]")).click();
        WebElement table = driver.findElement(By.xpath("//*[@class='card-panel dashboard-environment']"));
        System.out.println(table.getText());

        //Tester'ın "isminiz" olduğunu doğrulayalım
        Assert.assertTrue(table.getText().contains("İsmail"));

        //Sayfayı kapatalım
        driver.close();
    }

    public String printData(int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//table)[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
        return satirSutun.getText();

    }
}
