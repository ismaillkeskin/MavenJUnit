package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");

        //getTitle() sayfa başlığını verir
        System.out.println("Amazon Actual Title: " +driver.getTitle());
        System.out.println("Amazon Actual Url: " +driver.getCurrentUrl());
        String amazonWindowHanle = driver.getWindowHandle();
        System.out.println("Amazon Window Handle Değeri : "+amazonWindowHanle);

        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Actual Title : " +driver.getTitle());//driver.getTitle() method'u sayfa başlığını verir

        //getCurrentUrl() Gidilen sayfanın Url'sini verir
        System.out.println("Techproed Actual Url: " +driver.getCurrentUrl());

        //getPageSource() Açılan sayfanın kaynak kodlarını verir
        //System.out.println(driver.getPageSource()); "Bilerek yoruma aldık her çalıştığında kanak kodlarını verecek"

        //getWindowHandle() Gidilen sayfanın handle değerini(hashcode) verir. Bu handle değerini sayfalar arası geçiş için kullanırız
        System.out.println("Techproed Window Handle Değeri: "+driver.getWindowHandle()); //8EE4C2C910C1A7D0FA1C0BE29BD79321



    }
}
