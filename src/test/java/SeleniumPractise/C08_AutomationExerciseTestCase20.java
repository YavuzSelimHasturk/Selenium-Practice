package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_AutomationExerciseTestCase20 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //2. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //3. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedmetin = "ALL PRODUCTS";
        String actualMetin=driver.getTitle();

        if (expectedmetin.contains(actualMetin)){
            System.out.println("Sayfa testi PASSED");
        }else {
            System.out.println("Sayfa testi FAILED");
        }
        //4. Enter product name in search input and click search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchButton.sendKeys("Jeans");

        WebElement clickButton = driver.findElement(By.xpath("//button[@id='submit_search']"));
        clickButton.click();

        //5. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedValue=driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        if (searchedValue.isDisplayed()){
            System.out.println("Searched products test is PASSED");
        }else {
            System.out.println("Searched products test is FAILED");
        }

        //6. Verify all the products related to search are visible
        WebElement products = driver.findElement(By.xpath("//div[@class='features_items']"));
        if (products.isDisplayed()){
            System.out.println("Searched all products visible test is PASSED");
        }else {
            System.out.println("Searched all products visible test is FAILED");
        }

        //7. Add those products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='33'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='35'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='37'])[1]")).click();
        Thread.sleep(5000);

        //8. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.linkText("View Cart")).click();
        WebElement cartContainer = driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        if (cartContainer.isDisplayed()){
            System.out.println("All products are visible, Test PASSED");
        }else {
            System.out.println("Products are invisible, Test FAILED");
        }
        Thread.sleep(5000);
        driver.close();
    }
}
