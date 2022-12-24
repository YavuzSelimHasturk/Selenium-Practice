package SeleniumPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Title_And_Url_Testi {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");
        String actualResult= driver.getTitle();
        String expectResult="Facebook";

        if (actualResult.contains(expectResult)){
            System.out.println("Verify");
        }else {
            System.out.println("not verify : "+driver.getTitle());
        }
        String url = driver.getCurrentUrl();
        String word = "facebook";
        if (url.contains(word)){
            System.out.println("Test passed");
        }else {
            System.out.println("mevcut URL :" + driver.getCurrentUrl());
        }

        driver.get("https://www.walmart.com");
        String expectedword="Walmart.com";
        String actualtitle = driver.getTitle();

        if (actualtitle.contains(expectedword)){
            System.out.println("Test passed");
        }else
            System.out.println("Mevcut title : " +driver.getTitle());

        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().refresh();

        driver.manage().window().maximize();
        Thread.sleep(7000);
        driver.close();

    }
}
