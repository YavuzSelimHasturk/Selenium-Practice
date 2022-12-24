package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_City_Bike_Testi {
    public static void main(String[] args) throws InterruptedException {

        /*
        1- https://www.amazon.com/ sayfasına gidin.
        2- Arama kutusuna “city bike” yazip aratin
        3- Görüntülenen sonuçların sayısını yazdırın
        4- Listeden ilk urunun resmine tıklayın.
        */


        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com/");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        WebElement bikeSayisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr=bikeSayisi.getText();
        String[] sonucYazisiArr= sonucYazisiStr.split(" ");
        String sonucAdediStr=sonucYazisiArr[2]; // "74"
        int actualSonucAdediInt= Integer.parseInt(sonucAdediStr);
        System.out.println("City bike hakkinda cikan sonuc sayisi : " +actualSonucAdediInt);

        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();


        Thread.sleep(7000);
        driver.close();


    }

}
