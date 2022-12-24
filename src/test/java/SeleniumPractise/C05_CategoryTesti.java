package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_CategoryTesti {
    public static void main(String[] args) throws InterruptedException {

        /*
        1- https://www.automationexercise.com/ adresine gidin
        2- Category bolumundeki elementleri locate edin
        3- Category bolumunde 3 element oldugunu test edin
        4- Category isimlerini yazdirin
        5- Sayfayi kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.automationexercise.com/products");

        Thread.sleep(5000);

        List<WebElement> categoryElementi = driver.findElements(By.className("panel-heading"));

        if (categoryElementi.size()==3){
            System.out.println("Category'de 3 element mevcut");

            for (WebElement each: categoryElementi
                 ) {
                System.out.print(each.getText()+"-");
            }
        }else{
            System.out.println("Category'de "+categoryElementi.size()+" adet element var");
        }

        Thread.sleep(5000);
        driver.close();
    }
}
