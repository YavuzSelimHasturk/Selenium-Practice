package SeleniumPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Driver_Manage {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.ebay.com");
        System.out.println("pazisyon : "+driver.manage().window().getPosition());
        System.out.println("boyut : "+ driver.manage().window().getSize());

        driver.manage().window().minimize();

        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        System.out.println("fullscreen pazisyon : "+driver.manage().window().getPosition());
        System.out.println("fullscreen boyut : "+ driver.manage().window().getSize());


        Thread.sleep(3000);
        driver.close();

    }
}
