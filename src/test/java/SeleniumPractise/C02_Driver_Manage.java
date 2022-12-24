package SeleniumPractise;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Driver_Manage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.ebay.com");
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(500,500));

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        Thread.sleep(5000);
        driver.close();


    }
}
