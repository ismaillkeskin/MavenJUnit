package techproed.day14_Actions_Faker;


import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {

    @Test
    public void faker() {
        /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdıralım
        System.out.println("isim: " +faker.name().firstName());

        //faker objesini kullanarak bir soyisim yazdıralım
        System.out.println("soyisim:" +faker.name().lastName());

        //faker objesini kullanarak bir tamisim yazdıralım
        System.out.println("Fullname:" +faker.name().fullName());

        //faker objesini kullanarak bir adres yazdıralım
        System.out.println("Adres:" +faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdıralım
        System.out.println("Cep_No : " +faker.phoneNumber().cellPhone());
        System.out.println("Tel_No : " +faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdiralim
        System.out.println("Rastgele 15 haneli bir numara : "+faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println("Meslek:" +faker.job().position());
    }
}
