package SeleniumPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Title_And_Url_Test_2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
     // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://youtube.com");
        String expectWord="youtube";
        String actualResult=driver.getTitle();

        System.out.println("========================");
        if (actualResult.equals(expectWord)){
            System.out.println("Title test PASSED");
        }else
            System.out.println("Title test FAILED. Actual title : " + driver.getTitle());

        System.out.println("========================");
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains(expectWord)){
            System.out.println("Url test PASSED");
        }else
            System.out.println("URL test FAILED. Actual URL : "+ driver.getCurrentUrl());

        driver.get("https://www.amazon.com");

        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);

        driver.navigate().refresh();
        driver.navigate().forward();

        driver.manage().window().maximize();

        String word = "Amazon";
        String actualTitle = driver.getTitle();

        System.out.println("========================");
        if (actualTitle.contains(word)){
            System.out.println("Title test passed");
        }else System.out.println("Title test FAILED. Actual Title : "+driver.getTitle());

        String aranacakWord= "https://www.amazon.com/";
        System.out.println("========================");
        if (driver.getCurrentUrl().equals(aranacakWord)){
            System.out.println("URL dogrulama testi PASSED");
        }else
            System.out.println("URL dogrulama testi FAILED. Actual URL :"+driver.getCurrentUrl());

        Thread.sleep(5000);
        driver.close();




    }
}
